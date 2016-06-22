(ns which-appears-twice.core
  (:gen-class))

(defn find-dup-in-range
  "O(n) time & space solution - partitioning by id."
  [range n]
  (->> (partition-by identity range)
       (filter #(>= (count %) 2))
       ffirst))

(defn- sum-of-range [n]
  (/ (* n (inc n)) 2))

(defn find-dup-in-range-with-sum
  "O(n) time solution - taking difference of actual and expected sums from 1 to n."
  [range n]
  (- (apply + range) (sum-of-range n)))
