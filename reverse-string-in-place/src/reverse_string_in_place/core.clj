(ns reverse-string-in-place.core
  (:gen-class))

(defn- swap [arr idx-a idx-b]
  (-> arr
      (assoc idx-a (get arr idx-b))
      (assoc idx-b (get arr idx-a))))

(defn reverse-string
  "O(n) time - not in place (converting to vector) ~ but similar algorithm."
  [s]
  (loop [lower-idx 0
         upper-idx (dec (count s))
         reversed (vec s)]
    (if (>= lower-idx upper-idx)
      (apply str reversed)
      (recur (inc lower-idx)
             (dec upper-idx)
             (swap reversed lower-idx upper-idx)))))
