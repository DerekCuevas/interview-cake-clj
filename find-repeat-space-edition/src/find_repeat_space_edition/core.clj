(ns find-repeat-space-edition.core
  (:gen-class))

(defn- midpoint [floor ceiling]
  (+ (int (/ (- ceiling floor) 2)) floor))

(defn- occurrences-in-range [arr floor ceiling]
  (reduce
    (fn [count item]
      (if (<= floor item ceiling)
        (inc count)
        count))
    0
    arr))

(defn find-repeat
  "O(nlgn) time + O(1) space solution."
  [arr]
  (loop [floor 1
         ceiling (dec (count arr))]
    (let [mid (midpoint floor ceiling)]
      (cond
        (>= floor ceiling)
          floor
        (> (occurrences-in-range arr floor mid) (inc (- mid floor)))
          (recur floor mid)
        :else
          (recur (inc mid) ceiling)))))
