(ns top-scores.core
  (:gen-class))

(defn- int-frequencies [coll max-int]
  (reduce
    (fn [counts value]
      (update counts value inc))
    (vec (replicate (inc max-int) 0))
    coll))

(defn counting-sort
  "O(n) time & O(n + k) space solution, where k = max-value."
  [coll max-value]
  (reduce-kv
    (fn [sorted value count]
      (into sorted (replicate count value)))
    []
    (int-frequencies coll max-value)))
