(ns rectangular-love.core
  (:gen-class))

(defn- range->length [{:keys [start end]}]
  (- end start))

(defn- intersection [range-a range-b]
  (let [[first-range second-range] (sort-by :start [range-a range-b])]
    (when (>= (first-range :end) (second-range :start))
      {:start (max (first-range :start) (second-range :start))
       :end (min (first-range :end) (second-range :end))})))

(defn- rect->vertical-range [rect]
  {:start (rect :y)
   :end (+ (rect :y) (rect :height))})

(defn- rect->horizontal-range [rect]
  {:start (rect :x)
   :end (+ (rect :x) (rect :width))})

(defn- find-vertical-intersection [rect-a rect-b]
  (intersection (rect->vertical-range rect-a)
                (rect->vertical-range rect-b)))

(defn- find-horizontal-intersection [rect-a rect-b]
  (intersection (rect->horizontal-range rect-a)
                (rect->horizontal-range rect-b)))

(defn rectangular-overlap
  "O(1) time solution - will return overlapping rectangle, nil if no overlap."
  [rect-a rect-b]
  (let [vertical-intersection (find-vertical-intersection rect-a rect-b)
        horizontal-intersection (find-horizontal-intersection rect-a rect-b)]
    (when (and vertical-intersection horizontal-intersection)
      {:x (horizontal-intersection :start)
       :y (vertical-intersection :start)
       :width (range->length horizontal-intersection)
       :height (range->length vertical-intersection)})))
