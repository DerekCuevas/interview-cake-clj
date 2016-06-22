(ns cake-thief.core
  (:gen-class))

(defn- max-value-for [current-capacity max-value-at-capacity cakes]
  (reduce
   (fn [max-value {:keys [weight value]}]
     (if (< current-capacity weight)
       max-value
       (->> (- current-capacity weight)
            (get max-value-at-capacity)
            (+ value)
            (max max-value))))
   0
   cakes))

(defn max-duffel-bag-value
  "O(n*k) time solution, where k = capacity - dynamic and bottom up."
  [cakes capacity]
  (let [init-max-value-at-capacity (vec (repeat (inc capacity) 0))]
    (get (reduce-kv
          (fn [max-value-at-capacity current-capacity _]
            (->> (max-value-for current-capacity max-value-at-capacity cakes)
                 (assoc max-value-at-capacity current-capacity)))
          init-max-value-at-capacity
          init-max-value-at-capacity) capacity)))
