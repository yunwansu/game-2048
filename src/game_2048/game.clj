(ns game-2048.game)

(defn append-zero-right [coll]
  (vec (concat coll (take (- 4 (count coll)) (repeat 0)))))

(defn join-tiles [coll]
  (flatten coll))

(defn sum-left
  ([x] [x])
  ([x y] [(+ x y)])
  ([x y & more] (vec (concat (sum-left x y) (apply sum-left more)))))

(defn split-into-duplicate-tiles [coll]
  (partition-by identity coll))

(defn remove-zero [coll]
  (filterv (comp not zero?) coll))

(defn move [coll]
  (->> coll
       (remove-zero)
       (split-into-duplicate-tiles)
       (mapv #(apply sum-left %))
       (join-tiles)
       (append-zero-right)))

(defn transpose [game-map]
  (apply mapv vector game-map))

(defn reverse-map [game-map]
  (mapv (comp vec reverse) game-map))

(defn move-left [game-map]
  (mapv move game-map))

(defn move-right [game-map]
  (->> game-map
       (reverse-map)
       (move-left)
       (reverse-map)))

(defn move-up [game-map]
  (->> game-map
       (transpose)
       (move-left)
       (transpose)))

(defn move-down [game-map]
  (->> game-map
       (transpose)
       (move-right)
       (transpose)))

(defn add-tile [position value game-map]
  (assoc-in game-map position value))

(defn make-index [[row col]]
  (if (= col 3)
    [(inc row) 0]
    [row (inc col)]))

(defn mix-two-vectors [c1 c2]
  (mapv vector c1 c2))

(defn get-zero-index [game-map]
  (let [index (take 16 (iterate make-index [0 0]))]
    (->> (mix-two-vectors (flatten game-map) index)
         (filter #(= 0 (first %)))
         (mapv second))))
