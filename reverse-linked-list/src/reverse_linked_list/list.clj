(ns reverse-linked-list.list
  (:gen-class))

(defn node [value]
  {:value value :next nil})

(defn insert [head value]
  (if (empty? head)
    (node value)
    (assoc (node value) :next head)))

(defn coll->list [coll]
  (reduce insert {} (reverse coll)))
