(ns merge-sorted-arrays.core
  (:gen-class))

(defn merge-vectors
  "O(n) time & space solution." 
  [vec-a vec-b]
  (loop [idx-a 0
         idx-b 0
         merged []]
    (let [a (get vec-a idx-a)
          b (get vec-b idx-b)]
      (cond
        (and (nil? a) (nil? b))
          merged
        (or (nil? b) (and (some? a) (< a b)))
          (recur (inc idx-a) idx-b (conj merged a))
        :else
          (recur idx-a (inc idx-b) (conj merged b))))))
