(ns game-2048.game
  (:require   [game-2048.board :as board]
              [game-2048.rows :as rows]
              [game-2048.command :as command]))

(defn game []
  (let [game-map (board/create 4 4 0)
        move-left (board/move game-map
        command (command/get-command!)]
    
    
   

