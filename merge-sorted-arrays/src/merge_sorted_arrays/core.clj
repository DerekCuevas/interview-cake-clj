(ns merge-sorted-arrays.core
  (:gen-class))

(defn merge-colls
  "O(n) time & space solution."
  [coll-a coll-b]
  (loop [[a & as :as coll-a] coll-a
         [b & bs :as coll-b] coll-b
         merged []]
    (cond
      (and (empty? coll-a) (empty? coll-b))
        merged
      (or (nil? b) (and (not (nil? a)) (< a b)))
        (recur as coll-b (conj merged a))
      :else
        (recur coll-a bs (conj merged b)))))
