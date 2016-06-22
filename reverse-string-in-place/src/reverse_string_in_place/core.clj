(ns reverse-string-in-place.core
  (:gen-class))

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
             (-> reversed
                 (assoc lower-idx (get reversed upper-idx))
                 (assoc upper-idx (get reversed lower-idx)))))))
