(ns making-change.core
  (:gen-class))

(defn ways-to-make-amount
  "O(n * m) time and O(n) space solution, where m = # of denominations."
  [amount denominations]
  (get (reduce
        (fn [ways-of-doing-n-cents coin]
          (reduce
           (fn [ways-of-doing-n-cents higher-amount]
             (->> (- higher-amount coin)
                  (get ways-of-doing-n-cents)
                  (update ways-of-doing-n-cents higher-amount +)))
           ways-of-doing-n-cents
           (range coin (inc amount))))
        (vec (conj (replicate amount 0) 1))
        denominations)
       amount))
