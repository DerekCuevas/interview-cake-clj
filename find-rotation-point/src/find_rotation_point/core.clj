(ns find-rotation-point.core
  (:gen-class))

(def ^:private gt? (comp pos? compare))
(def ^:private lt? (comp neg? compare))

(defn find-rotation-point
  "O(n) time solution."
  [words]
  (loop [idx 1]
    (if (gt? (words (dec idx)) (words idx))
      idx
      (recur (inc idx)))))

(defn- midpoint [start end]
  (+ (int (/ (- end start) 2)) start))

(defn find-rotation-point-fast
  "O(lgn) - binary search like solution."
  [[first-word :as words]]
  (loop [start 0
         end (count words)]
    (let [mid (midpoint start end)
          mid-word (words mid)]
      (cond
        ;; TODO: double check for edge conds
        (<= (- end start) 1) end
        (gt? mid-word first-word) (recur mid end)
        (lt? mid-word first-word) (recur start mid)))))
