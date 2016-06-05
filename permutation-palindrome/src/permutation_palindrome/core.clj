(ns permutation-palindrome.core
  (:gen-class))

(defn odd-occurrences [s]
  (reduce (fn [counts char]
            (if (contains? counts char)
              (disj counts char)
              (conj counts char)))
          #{}
          s))

(defn permutation-palindrome?
  "O(n) time & space solution - counting occurrences with a set."
  [s]
  (<= (count (odd-occurrences s)) 1))
