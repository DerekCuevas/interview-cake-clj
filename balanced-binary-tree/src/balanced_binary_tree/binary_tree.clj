(ns balanced-binary-tree.binary-tree
  (:gen-class))

(defn node [value]
  {:value value :left nil :right nil})

(defn set-left [root n]
  (assoc root :left n))

(defn set-right [root n]
  (assoc root :right n))

(defn- height [root pred]
  (if (nil? root)
    0
    (inc (pred (height (root :left) pred)
               (height (root :right) pred)))))

(defn max-height [root]
  (height root max))

(defn min-height [root]
  (height root min))
