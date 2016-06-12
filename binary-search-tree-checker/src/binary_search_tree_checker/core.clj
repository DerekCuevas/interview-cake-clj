(ns binary-search-tree-checker.core
  (:gen-class))

(defn bst?
  "O(n) time solution - recursively checking every node agaist range."
  ([root]
    (bst? root Integer/MIN_VALUE Integer/MAX_VALUE))
  ([root min max]
    (cond
      (empty? root) true
      (not (< min (root :value) max)) false
      :else (and (bst? (root :left) min (root :value))
                 (bst? (root :right) (root :value) max)))))
