(ns game-2048.board)

(defn create [row col fill]
  (take row (repeat (take col (repeat fill)))))

(defn add [game-map position value]
  (assoc-in game-map position value))

(defn move [game-map move-rules]
  (move-rules game-map))

(defn transpose [game-map]
  (apply mapv vector game-map))

(defn reverse [game-map]
  (mapv (comp vec reverse) game-map))
