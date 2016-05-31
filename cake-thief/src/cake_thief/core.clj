(ns cake-thief.core
  (:gen-class))

(defn max-duffel-bag-value-greedy
  "O(nlgn) time solution - close and greedy approximation"
  [cakes capacity]
  (let [sorted-by-ratio (sort-by #(/ (:value %) (:weight %)) > cakes)]
    ((reduce (fn [{:keys [capacity-left max-value]} {:keys [weight value]}]
              (let [can-take (int (/ capacity-left weight))]
                (if (>= can-take 0)
                  {:capacity-left (- capacity-left (* weight can-take))
                   :max-value (+ max-value (* value can-take))})))
            {:capacity-left capacity :max-value 0}
            sorted-by-ratio) :max-value)))
