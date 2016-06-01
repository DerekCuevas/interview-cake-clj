(ns the-stolen-breakfast-drone.core
  (:gen-class))

(defn find-unique
  "O(n) time & space solution - using a set"
  [ids]
  (first (reduce (fn [unique-ids id]
                   (if (contains? unique-ids id)
                     (disj unique-ids id)
                     (conj unique-ids id)))
                 #{}
                 ids)))

(defn find-unique-bitwise
  "O(n) time solution - using bitwise xor"
  [ids]
  (reduce bit-xor ids))
