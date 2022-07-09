(ns game-2048.core
  (:require [game-2048.game :refer [run]]
            [game-2048.gui.main :refer [draw]])
  (:gen-class))

(defn -main [& args]
  (do
    (draw)
    (run)))
