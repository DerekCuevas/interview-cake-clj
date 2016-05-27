(ns binary-search-tree-checker.binary-tree
  (:gen-class))

(defn node [value]
  {:value value :left nil :right nil})

(defn max-height [root]
  (if (nil? root)
    0
    (inc (max (max-height (root :left))
              (max-height (root :right))))))

(defn min-height [root]
  (if (nil? root)
    0
    (inc (min (min-height (root :left))
              (min-height (root :right))))))

(defn insert [root value]
  (loop [current-node root
         path []]
    (cond
      (nil? current-node)
        (assoc-in root path (node value))
      (empty? current-node)
        (node value)
      (< value (current-node :value))
        (recur (current-node :left) (conj path :left))
      (> value (current-node :value))
        (recur (current-node :right) (conj path :right)))))

(defn coll->binary-search-tree [coll]
  (reduce insert {} coll))
