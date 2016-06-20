(ns find-repeat-space-edition.core
  (:gen-class))

(defn- bound [floor ceiling]
  {:floor floor :ceiling ceiling})

(defn- bound->midpoint [{:keys [floor ceiling]}]
  (+ (int (/ (- ceiling floor) 2)) floor))

(defn- bound->length [{:keys [floor ceiling]}]
  (inc (- ceiling floor)))

(defn- lower-bound [{:keys [floor ceiling] :as bounds}]
  (bound floor (bound->midpoint bounds)))

(defn- upper-bound [{:keys [floor ceiling] :as bounds}]
  (bound (inc (bound->midpoint bounds)) ceiling))

(defn- items-in-bound [arr {:keys [floor ceiling]}]
  (count (filter #(<= floor % ceiling) arr)))

(defn find-dup
  "O(nlgn) time + O(1) space solution."
  [arr]
  (loop [{:keys [floor ceiling] :as bounds} (bound 1 (dec (count arr)))]
    (let [lower (lower-bound bounds)
          upper (upper-bound bounds)]
      (cond
        (>= floor ceiling)
          floor
        (> (items-in-bound arr lower) (bound->length lower))
          (recur lower)
        :else
          (recur upper)))))
