(ns game-2048.rule
  (:require [game-2048.game :as game]))

(defn add-tile-in-empty-position [value game-map]
  (game/add-tile (->> game-map
                      (game/get-zero-index)
                      (shuffle)
                      (first))
                 value
                 game-map))

(defn print-map [game-map]
  (run! prn game-map))
                 
(defn run []
  (let [game-map (vec (take 4 (repeat [0 0 0 0])))
        game-map (game/add-tile (take 2 (repeatedly #(rand-int 4))) 2 game-map)]
    (loop [game-map (add-tile-in-empty-position 2 game-map)]
      (print-map game-map)
      (let [new-game-map (case (read)
                           left (game/move-left game-map)
                           right (game/move-right game-map)
                           up (game/move-up game-map)
                           down (game/move-down game-map))]
        (if (= game-map new-game-map)
          (recur game-map)
          (recur (add-tile-in-empty-position 2 new-game-map)))))))
      
