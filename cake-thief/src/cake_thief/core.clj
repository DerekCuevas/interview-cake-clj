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

(defn- max-value-for-current-capacity [max-value-at-capacity current-capacity]
  (fn [max-value {:keys [weight value]}]
    (if (>= current-capacity weight)
      (max max-value
           (+ (max-value-at-capacity (- current-capacity weight)) value))
      max-value)))

;; FIXME: clean up names
(defn max-duffel-bag-value
  "O(n*k) time solution, where k = capacity - dynamic and bottom up"
  [cakes capacity]
  (loop [max-value-at-capacity (vec (repeat (inc capacity) 0))
         current-capacity 1]
    (if (> current-capacity capacity)
      (max-value-at-capacity capacity)
      (recur (assoc max-value-at-capacity
                    current-capacity
                    (reduce (max-value-for-current-capacity max-value-at-capacity
                                                            current-capacity) 0 cakes))
             (inc current-capacity)))))
