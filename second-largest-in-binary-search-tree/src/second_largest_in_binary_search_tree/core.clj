(ns second-largest-in-binary-search-tree.core
  (:gen-class))

(defn largest [root]
  (loop [current root]
    (if (nil? (current :right))
      (current :value)
      (recur (current :right)))))

(defn second-largest [root]
  (loop [parent nil
         current root]
    (if (nil? (current :right))
      (if (nil? (current :left))
        (and parent (parent :value))
        (largest (current :left)))
      (recur current (current :right)))))
