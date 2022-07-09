(ns game-2048.board)

(def default-value 0)

(defn create [size]
  (vec
   (for [count (range)
         :let [row (vec (repeat size default-value))]
         :while (< count size)]
     row)))

(defn add [game-map position value]
  (assoc-in game-map position value))

;(defn move [game-map move-rules]
;  (move-rules game-map))

;(defn transpose [game-map]
;  (apply mapv vector game-map))

;(defn reverse [game-map]
;  (mapv (comp vec reverse) game-map))
