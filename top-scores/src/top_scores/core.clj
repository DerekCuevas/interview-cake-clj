(ns top-scores.core
  (:gen-class))

(defn- int-frequencies [coll max-value]
  (reduce
    (fn [counts value]
      (assoc counts value (inc (counts value))))
    (vec (replicate (inc max-value) 0))
    coll))

(defn counting-sort
  "O(n) time & O(n + k) space solution, where k = max-value."
  [coll max-value]
  (reduce-kv
    (fn [sorted value count]
      (into sorted (take count (repeat value))))
    []
    (int-frequencies coll max-value)))
