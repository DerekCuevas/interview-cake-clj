(ns which-appears-twice.core
  (:gen-class))

(defn find-dup-in-range
  "O(n) time solution - partitioning by id."
  [range n]
  (ffirst (filter #(>= (count %) 2)
                  (partition-by identity range))))
