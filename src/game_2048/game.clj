(ns game-2048.game
  (:require [game-2048.board :as board]
            [game-2048.move :as move]
            [game-2048.printer :refer [print-map]]))

(def map-size 4)
(def default-value 2)

(defn random-position! []
  [(rand-int map-size) (rand-int map-size)])

(defn get-index [game-map]
  (for [x (range map-size)
        y (range map-size)
        :when (= 0 (get-in game-map [x y]))]
    [x y]))
  
(defn run []
  (let [game-map (board/create map-size)]
    (loop [game-map (board/add game-map (random-position!) default-value)]
      (print-map game-map)
      (let [next-game-map (case (read)
                            left (move/move-left game-map)
                            right (move/move-right game-map)
                            up (move/move-up game-map)
                            down (move/move-down game-map))]
        (if (= game-map next-game-map)
          (recur game-map)
          (recur (board/add
                  next-game-map
                  (-> next-game-map
                      get-index
                      shuffle
                      first)
                  default-value)))))))
