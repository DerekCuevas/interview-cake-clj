(ns reverse-linked-list.core
  (:require [reverse-linked-list.list :as list])
  (:gen-class))

(defn reverse-list
  "O(n) time & space - not in-place, returns new list."
  [head]
  (loop [head head
         reversed nil]
    (if (nil? head)
      reversed
      (recur (head :next)
             (list/insert reversed (head :value))))))
