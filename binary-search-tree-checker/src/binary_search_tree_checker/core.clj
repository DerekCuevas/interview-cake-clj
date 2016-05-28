(ns binary-search-tree-checker.core
  (:require [binary-search-tree-checker.binary-tree :as tree])
  (:gen-class))

(defn valid-binary-search-tree?
  "O(n) time & space - checking if the inorder traversal is sorted."
  [root]
  (if-let [sorted (tree/tree->inorder-lazy-seq root)]
    (or (zero? (count sorted)) (apply <= sorted))
    false))

(defn valid-binary-search-tree-rec?
  ([root]
    (valid-binary-search-tree-rec? root Integer/MIN_VALUE Integer/MAX_VALUE))
  ([root min max]
    (cond
      (empty? root) true
      (not (< min (root :value) max)) false
      :else (and (valid-binary-search-tree-rec? (root :left) min (root :value))
                 (valid-binary-search-tree-rec? (root :right) (root :value) max)))))
