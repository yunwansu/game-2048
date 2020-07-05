(ns game-2048.core
  (:require [game-2048.rule :as rule])
  (:gen-class))

(defn -main [& args]
  (rule/run))
