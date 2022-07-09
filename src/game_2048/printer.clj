(ns game-2048.printer)

(defn print-map [game-map]
  (doall (map println game-map)))
