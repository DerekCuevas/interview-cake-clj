(ns find-in-ordered-set.core
  (:gen-class))

(def ^:private gt? (comp pos? compare))
(def ^:private lt? (comp neg? compare))
(def ^:private eq? (comp zero? compare))

(defn- midpoint [start end]
  (-> (/ (- end start) 2)
      int
      (+ start)))

(defn binary-search
  "O(lgn) - returns index of item in sorted vector, -1 if not found."
  [arr item]
  (loop [start 0
         end (count arr)]
    (let [mid (midpoint start end)]
      (cond
        (zero? (- end start)) -1
        (= (- end start) 1) (if (eq? (get arr start) item) start -1)
        (eq? (get arr mid) item) mid
        (gt? (get arr mid) item) (recur start mid)
        (lt? (get arr mid) item) (recur mid end)))))
