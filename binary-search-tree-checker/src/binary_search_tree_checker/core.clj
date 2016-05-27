(ns binary-search-tree-checker.core
  (:require [binary-search-tree-checker.binary-tree :as tree])
  (:gen-class))

(defn valid-binary-search-tree?
  "O(n) time & space - checking if the inorder traversal is sorted."
  [root]
  (if-let [sorted (tree/tree->inorder-lazy-seq root)]
    (or (zero? (count sorted)) (apply <= sorted))
    false))
