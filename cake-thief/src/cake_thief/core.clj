(ns cake-thief.core
  (:gen-class))

(defn- steel-cakes [{:keys [capacity-left max-value] :as totals} {:keys [weight value]}]
  (let [can-take (int (/ capacity-left weight))]
    {:capacity-left (- capacity-left (* weight can-take))
     :max-value (+ max-value (* value can-take))}))

(defn max-duffel-bag-value-greedy
  "O(nlgn) time solution - greedy approximation"
  [cakes capacity]
  (let [sorted-by-ratio (sort-by #(/ (:value %) (:weight %)) > cakes)]
    ((reduce steel-cakes
             {:capacity-left capacity :max-value 0}
             sorted-by-ratio) :max-value)))
