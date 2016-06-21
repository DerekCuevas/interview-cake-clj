(ns kth-to-last-linked-list.core
  (:require [kth-to-last-linked-list.list :as list])
  (:gen-class))

(defn kth-to-last-node
  "O(n) time solution."
  [head k]
  (let [length (list/length head)
        k-idx (- (dec length) k)]
    (when-not (neg? k-idx)
      (loop [{:keys [value next]} head
             idx 0]
        (if (= idx k-idx)
          value
          (recur next (inc idx)))))))
