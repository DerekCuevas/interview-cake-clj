(ns kth-to-last-linked-list.core
  (:require [kth-to-last-linked-list.list :as list])
  (:gen-class))

(defn kth-to-last-node
  "O(n) time solution."
  [head k]
  (let [k-idx (- (dec (list/length head)) k)]
    (when-not (neg? k-idx)
      (->> (range k-idx)
           (reduce :next head)
           :value))))
