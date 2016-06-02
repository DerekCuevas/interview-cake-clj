(ns kth-to-last-linked-list.core
  (:require [kth-to-last-linked-list.list :as list])
  (:gen-class))

(defn kth-to-last-node
  "O(n) time solution"
  [head k]
  (let [length (list/count head)
        k-idx (- (dec length) k)]
    (when (< k length)
      (loop [current head
             idx 0]
        (if (= idx k-idx)
          (current :value)
          (recur (current :next) (inc idx)))))))
