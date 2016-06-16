(ns recursive-string-permutations.core
  (:gen-class))

(defn- remaining-subs [s idx]
  (str (subs s 0 idx)
       (subs s (inc idx) (count s))))

(defn permutations
  "O(n!) time solution - recursively computing permutations."
  [s]
  (if (<= (count s) 1)
    #{s}
    (reduce-kv
      (fn [permutations-so-far idx char]
        (into permutations-so-far
          (map (partial str char)
               (permutations (remaining-subs s idx)))))
      #{}
      (vec s))))
