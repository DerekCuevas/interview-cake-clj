(ns find-repeat-space-edition.core
  (:gen-class))

(defn- bound [floor ceiling]
  {:floor floor :ceiling ceiling})

(defn- midpoint [{:keys [floor ceiling]}]
  (+ (int (/ (- ceiling floor) 2)) floor))

(defn- length [{:keys [floor ceiling]}]
  (inc (- ceiling floor)))

(defn- lower [{:keys [floor ceiling] :as bounds}]
  (bound floor (midpoint bounds)))

(defn- upper [{:keys [floor ceiling] :as bounds}]
  (bound (inc (midpoint bounds)) ceiling))

(defn- items-in-bound [arr {:keys [floor ceiling]}]
  (reduce
    (fn [in-bound item]
      (if (<= floor item ceiling)
        (inc in-bound)
        in-bound))
    0
    arr))

(defn find-dup
  "O(nlgn) time + O(1) space solution."
  [arr]
  (loop [bounds (bound 1 (dec (count arr)))]
    (let [lower-bound (lower bounds)
          upper-bound (upper bounds)]
      (cond
        (>= (bounds :floor) (bounds :ceiling))
          (bounds :floor)
        (> (items-in-bound arr lower-bound) (length lower-bound))
          (recur lower-bound)
        :else
          (recur upper-bound)))))
