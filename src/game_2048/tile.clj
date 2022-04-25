(ns game-2048.tile)

(defn sum-left
  ([tile] [tile])
  ([t1 t2] [(+ t1 t2)])
  ([t1 t2 & more] (vec (concat (sum-left t1 t2) (apply sum-left more)))))
  
