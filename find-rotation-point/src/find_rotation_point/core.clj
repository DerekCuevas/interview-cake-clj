(ns find-rotation-point.core
  (:gen-class))

(def ^:private gt? (comp pos? compare))
(def ^:private lt? (comp neg? compare))

(defn- midpoint [start end]
  (-> (/ (- end start) 2)
      int
      (+ start)))

(defn find-rotation-point
  "O(lgn) time solution - binary search like."
  [[first-word :as words]]
  (loop [start 0
         end (count words)]
    (let [mid (midpoint start end)]
      (cond
        (<= (- end start) 1) end
        (gt? (get words mid) first-word) (recur mid end)
        (lt? (get words mid) first-word) (recur start mid)))))
