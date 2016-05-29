(ns find-in-ordered-set.core
  (:gen-class))

(def ^:private gt? (comp pos? compare))
(def ^:private lt? (comp neg? compare))
(def ^:private eq? (comp zero? compare))

(defn- midpoint [start end]
  (+ (int (/ (- end start) 2)) start))

(defn binary-search [arr item]
  (loop [start 0
         end (count arr)]
    (let [mid (midpoint start end)]
      (cond
        (zero? (- end start)) -1
        (= (- end start) 1) (if (eq? (arr start) item) start -1)
        (eq? (arr mid) item) mid
        (gt? (arr mid) item) (recur start mid)
        (lt? (arr mid) item) (recur mid end)))))
