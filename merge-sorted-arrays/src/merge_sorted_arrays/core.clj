(ns merge-sorted-arrays.core
  (:gen-class))

(defn merge-colls
  "O(n) time & space solution."
  [coll-a coll-b]
  (loop [coll-a coll-a
         coll-b coll-b
         merged []]
    (let [a (first coll-a)
          b (first coll-b)]
      (cond
        (and (empty? coll-a) (empty? coll-b))
          merged
        (or (nil? b) (and (not (nil? a)) (< a b)))
          (recur (rest coll-a) coll-b (conj merged a))
        :else
          (recur coll-a (rest coll-b) (conj merged b))))))
