(ns balanced-binary-tree.core
  (:require [balanced-binary-tree.binary-tree :as tree])
  (:gen-class))

(def tree (-> (tree/node 10)
              (tree/set-left (-> (tree/node 5)
                                 (tree/set-left (tree/node 2))))
              (tree/set-right (tree/node 15))))

(defn balanced? [root]
  (>= 1 (- (tree/max-height root) (tree/min-height root))))
