(ns permutation-palindrome.core
  (:gen-class))

(defn permutation-palindrome?
  "O(n) time & space solution - counting occurrences with a set."
  [s]
  (let [odd-counts (reduce (fn [counts char]
                             (if (contains? counts char)
                               (disj counts char)
                               (conj counts char)))
                           #{}
                           s)]
    (if (even? (count s))
      (empty? odd-counts)
      (= 1 (count odd-counts)))))
