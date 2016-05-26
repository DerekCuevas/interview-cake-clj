(ns balanced-binary-tree.core
  (:require [balanced-binary-tree.binary-tree :as tree])
  (:gen-class))

(defn balanced? [root]
  (>= 1 (- (tree/max-height root) (tree/min-height root))))
