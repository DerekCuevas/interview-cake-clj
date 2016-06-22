(ns the-stolen-breakfast-drone.core
  (:gen-class))

(defn find-unique
  "O(n) time & space solution - using a set."
  [ids]
  (first (reduce
          (fn [uniques id]
            (if (contains? uniques id)
              (disj uniques id)
              (conj uniques id)))
          #{}
          ids)))

(defn find-unique-bitwise
  "O(n) time solution - using bitwise xor."
  [ids]
  (reduce bit-xor ids))
