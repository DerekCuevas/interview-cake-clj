(ns top-scores.core
  (:gen-class))

(defn- sorted-frequencies [coll max-value]
  (reduce
   (fn [counts value]
     (update counts value inc))
   (vec (replicate (inc max-value) 0))
   coll))

(defn counting-sort
  "O(n) time & O(n + k) space solution, where k = max-value."
  [coll max-value]
  (reduce-kv
   (fn [sorted value count]
     (into sorted (replicate count value)))
   []
   (sorted-frequencies coll max-value)))
