(ns cake-thief.core
  (:gen-class))

(defn- steel-cakes [{:keys [capacity-left max-value] :as totals}
                    {:keys [weight value]}]
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

(defn- max-value-for-current-capacity
  [max-value-at-capacity current-capacity cakes]
  (reduce (fn [max-value {:keys [weight value]}]
            (if (>= current-capacity weight)
              (let [diff-value (max-value-at-capacity (- current-capacity weight))]
                (max max-value (+ diff-value value)))
              max-value))
          0
          cakes))

(defn max-duffel-bag-value
  "O(n*k) time solution, where k = capacity - dynamic and bottom up"
  [cakes capacity]
  (let [max-value-at-capacity (vec (repeat (inc capacity) 0))]
    ((reduce-kv
      (fn [max-value-at-capacity current-capacity _]
        (assoc max-value-at-capacity
               current-capacity
               (max-value-for-current-capacity max-value-at-capacity current-capacity cakes)))
      max-value-at-capacity
      max-value-at-capacity) capacity)))
