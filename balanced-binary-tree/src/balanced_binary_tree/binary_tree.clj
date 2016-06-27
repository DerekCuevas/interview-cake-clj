(ns balanced-binary-tree.binary-tree
  (:gen-class))

(defn node [value]
  {:value value :left nil :right nil})

(defn max-height [root]
  (if (nil? root)
    0
    (inc (max (max-height (:left root))
              (max-height (:right root))))))

(defn min-height [root]
  (if (nil? root)
    0
    (inc (min (min-height (:left root))
              (min-height (:right root))))))

(defn insert [root value]
  (loop [current root
         path []]
    (cond
      (nil? current)
        (assoc-in root path (node value))
      (neg? (compare value (:value current)))
        (recur (:left current) (conj path :left))
      (pos? (compare value (:value current)))
        (recur (:right current) (conj path :right)))))

(defn coll->binary-search-tree [coll]
  (reduce insert
          (node (first coll))
          (rest coll)))

(defn tree->preorder-lazy-seq [root]
  (if (empty? root)
    '()
    (lazy-cat (list (:value root))
              (tree->preorder-lazy-seq (:left root))
              (tree->preorder-lazy-seq (:right root)))))

(defn tree->inorder-lazy-seq [root]
  (if (empty? root)
    '()
    (lazy-cat (tree->inorder-lazy-seq (:left root))
              (list (:value root))
              (tree->inorder-lazy-seq (:right root)))))

(defn tree->postorder-lazy-seq [root]
  (if (empty? root)
    '()
    (lazy-cat (tree->postorder-lazy-seq (:left root))
              (tree->postorder-lazy-seq (:right root))
              (list (:value root)))))

(defn largest [{:keys [value right]}]
  (if (nil? right)
    value
    (recur right)))

(defn smallest [{:keys [value left]}]
  (if (nil? left)
    value
    (recur left)))
