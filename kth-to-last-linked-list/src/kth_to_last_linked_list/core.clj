(ns kth-to-last-linked-list.core
  (:require [kth-to-last-linked-list.list :as list])
  (:gen-class))

(defn kth-to-last-node
  "O(n) time solution"
  [head k]
  (let [length (list/count-list head)
        k-idx (- (dec length) k)]
    (when (< k length)
      (loop [current head
             idx 0]
        (if (= idx k-idx)
          (current :value)
          (recur (current :next) (inc idx)))))))

(defn kth-to-last-node-other
  "O(n) time solution"
  [head k]
  (let [length (list/count-list head)
        k-idx (- (dec length) k)]
    (when (< k length)
      ((reduce (fn [list _] (list :next))
               head
               (range k-idx)) :value))))
