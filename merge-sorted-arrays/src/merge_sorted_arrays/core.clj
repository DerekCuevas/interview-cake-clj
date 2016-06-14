(ns merge-sorted-arrays.core
  (:gen-class))

(defn- lt? [a b]
  (and (some? a) (neg? (compare a b))))

(defn merge-vectors [vec-a vec-b]
  (loop [idx-a 0
         idx-b 0
         merged []]
    (let [a (get vec-a idx-a)
          b (get vec-b idx-b)]
      (cond
        (and (nil? a) (nil? b))
          merged
        (or (nil? b) (lt? a b))
          (recur (inc idx-a) idx-b (conj merged a))
        :else
          (recur idx-a (inc idx-b) (conj merged b))))))
