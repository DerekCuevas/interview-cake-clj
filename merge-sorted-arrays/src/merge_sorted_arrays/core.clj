(ns merge-sorted-arrays.core
  (:gen-class))

(defn merge-colls
  "O(n) time & space solution."
  [coll-a coll-b]
  (loop [coll-a coll-a
         coll-b coll-b
         merged []]
    (let [[a & as] coll-a
          [b & bs] coll-b]
      (cond
        (and (empty? coll-a) (empty? coll-b))
          merged
        (or (nil? b) (and (not (nil? a)) (< a b)))
          (recur as coll-b (conj merged a))
        :else
          (recur coll-a bs (conj merged b))))))
