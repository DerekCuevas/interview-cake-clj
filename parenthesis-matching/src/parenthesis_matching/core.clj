(ns parenthesis-matching.core
  (:gen-class))

(defn find-closing-parenthesis
  "O(n) time & O(1) space solution - doesn't handle no closing parenthesis."
  [s open-idx]
  (reduce
   (fn [open-count idx]
     (case (get s idx)
       \( (inc open-count)
       \) (if (zero? open-count) (reduced idx) (dec open-count))
       open-count))
   0
   (range (inc open-idx) (count s))))
