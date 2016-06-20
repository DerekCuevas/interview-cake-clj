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
  (loop [current root
         path []]
    (cond
      (nil? current)
        (assoc-in root path (node value))
      (empty? current)
        (node value)
      (neg? (compare value (current :value)))
        (recur (current :left) (conj path :left))
      (pos? (compare value (current :value)))
        (recur (current :right) (conj path :right)))))

(defn coll->binary-search-tree [coll]
  (reduce insert {} coll))

(defn tree->preorder-lazy-seq [root]
  (if (empty? root)
    '()
    (lazy-cat (list (root :value))
              (tree->preorder-lazy-seq (root :left))
              (tree->preorder-lazy-seq (root :right)))))

(defn tree->inorder-lazy-seq [root]
  (if (empty? root)
    '()
    (lazy-cat (tree->inorder-lazy-seq (root :left))
              (list (root :value))
              (tree->inorder-lazy-seq (root :right)))))

(defn tree->postorder-lazy-seq [root]
  (if (empty? root)
    '()
    (lazy-cat (tree->postorder-lazy-seq (root :left))
              (tree->postorder-lazy-seq (root :right))
              (list (root :value)))))

(defn largest [{:keys [value right]}]
  (if (nil? right)
    value
    (recur right)))

(defn smallest [{:keys [value left]}]
  (if (nil? left)
    value
    (recur left)))
