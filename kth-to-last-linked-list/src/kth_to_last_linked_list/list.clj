(ns kth-to-last-linked-list.list
  (:gen-class))

(defn node [value]
  {:value value :next nil :count 1})

(defn insert [head value]
  (if (empty? head)
    (node value)
    (-> (node value)
        (assoc :next head)
        (assoc :count (inc (:count head))))))

(defn coll->list [coll]
  (reduce insert {} (reverse coll)))

(defn length [head]
  (:count head 0))
