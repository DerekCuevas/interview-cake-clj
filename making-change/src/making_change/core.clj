(ns making-change.core
  (:gen-class))

(defn ways-to-make-amount
  "O(n * m) time and O(n) space solution, where m = # of denominations."
  [amount denominations]
  (get (reduce
        (fn [ways-of-doing-n-cents coin]
          (loop [higher-amount coin
                 ways-of-doing-n-cents ways-of-doing-n-cents]
            (if (> higher-amount amount)
              ways-of-doing-n-cents
              (recur (inc higher-amount)
                     (->> (ways-of-doing-n-cents (- higher-amount coin))
                          (update ways-of-doing-n-cents higher-amount +))))))
        (vec (conj (replicate amount 0) 1))
        denominations) amount))
