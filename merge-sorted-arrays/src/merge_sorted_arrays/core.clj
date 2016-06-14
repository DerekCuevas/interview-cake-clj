(ns merge-sorted-arrays.core
  (:gen-class))

(defn merge-colls [coll-a coll-b]
  (loop [idx-a 0
         idx-b 0
         merged []]
    (let [a (get coll-a idx-a)
          b (get coll-b idx-b)]
      (cond
        (and (nil? a) (nil? b))
          merged
        (nil? a)
          (recur idx-a (inc idx-b) (conj merged b))
        (nil? b)
          (recur (inc idx-a) idx-b (conj merged a))
        (< a b)
          (recur (inc idx-a) idx-b (conj merged a))
        :else
          (recur idx-a (inc idx-b) (conj merged b))))))
