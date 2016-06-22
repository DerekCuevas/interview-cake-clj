(ns second-largest-in-binary-search-tree.core
  (:require [second-largest-in-binary-search-tree.binary-tree :as tree])
  (:gen-class))

(defn second-largest
  "O(lgn) time solution."
  [root]
  (loop [parent nil
         {:keys [value left right] :as current} root]
    (if (nil? right)
      (if (nil? left)
        (:value parent)
        (tree/largest left))
      (recur current right))))
