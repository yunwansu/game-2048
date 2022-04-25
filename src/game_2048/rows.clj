(ns game-2048.rows)

(defn make-paritions [row f]
  (partition-by f row))
  
(defn merge-paritions [partitions]
  (flatten partitions))

(defn fill-right [row n fill]
  (vec (concat row (take n (repeat fill)))))

(defn remove-partition [row f]
  (filterv (comp not f) row))
