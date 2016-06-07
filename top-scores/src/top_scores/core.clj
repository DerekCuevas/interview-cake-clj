(ns top-scores.core
  (:gen-class))

(defn- count-items [coll max-value]
  (reduce
    (fn [counts value]
      (assoc counts value (inc (counts value))))
    (vec (take (inc max-value) (repeat 0)))
    coll))

(defn counting-sort
  "O(n) time & O(k) space solution, where k = max-value."
  [coll max-value]
  (reduce-kv
    (fn [sorted value count]
      (into sorted (take count (repeat value))))
    []
    (count-items coll max-value)))
