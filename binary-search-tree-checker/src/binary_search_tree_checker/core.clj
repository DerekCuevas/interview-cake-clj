(ns binary-search-tree-checker.core
  (:gen-class))

(defn bst?
  "O(n) time solution - recursively checking every node agaist range."
  ([root]
    (bst? root Integer/MIN_VALUE Integer/MAX_VALUE))
  ([{:keys [value left right] :as root} min max]
    (cond
      (empty? root) true
      (not (< min value max)) false
      :else (and (bst? left min value)
                 (bst? right value max)))))
