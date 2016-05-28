(ns second-largest-in-binary-search-tree.core
  (:require [second-largest-in-binary-search-tree.binary-tree :as tree])
  (:gen-class))

(defn second-largest [root]
  (loop [parent nil
         current root]
    (if (nil? (current :right))
      (if (nil? (current :left))
        (and parent (parent :value))
        (tree/largest (current :left)))
      (recur current (current :right)))))
