(ns which-appears-twice.core
  (:gen-class))

(defn find-dup-in-range
  "O(n) time & space solution - partitioning by id."
  [range n]
  (ffirst (filter #(>= (count %) 2)
                  (partition-by identity range))))

(defn find-dup-in-range-with-sum
  "O(n) time solution - taking difference of actual and expected sums from 1 to n."
  [range n]
  (- (apply + range) (/ (* n (inc n)) 2)))
