(ns parenthesis-matching.core
  (:gen-class))

(defn find-closing-parenthesis
  "O(n) time & space solution - using a stack."
  [s open-idx]
  (if (>= open-idx (dec (count s)))
    -1
    (reduce-kv
      (fn [stack idx char]
        (cond
          (and (= \) char) (= (count stack) 1))
            (reduced (+ open-idx idx))
          (= \( char)
            (conj stack char)
          (= \) char)
            (pop stack)
          :else
            stack))
      []
      (vec (subs s open-idx)))))
