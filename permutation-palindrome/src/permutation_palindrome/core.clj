(ns permutation-palindrome.core
  (:gen-class))

(defn- odd-frequencies [s]
  (reduce
   (fn [counts char]
     (if (contains? counts char)
       (disj counts char)
       (conj counts char)))
   #{}
   s))

(defn permutation-palindrome?
  "O(n) time & space solution - counting odd frequencies with a set."
  [s]
  (<= (count (odd-frequencies s)) 1))

(defn permutation-palindrome-better?
  "O(n) time & space solution - counting odd frequencies w/frequencies fn."
  [s]
  (<= (count (filter odd? (vals (frequencies s)))) 1))
