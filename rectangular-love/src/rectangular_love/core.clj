(ns rectangular-love.core
  (:gen-class))

(defn- intersection
  "Returns intersection of ranges, nil if no overlap."
  [range-a range-b]
  (let [[under over] (sort-by :start [range-a range-b])]
    (when (>= (under :end) (over :start))
      {:start (max (under :start) (over :start))
       :end (min (under :end) (over :end))})))

(defn- rect->vertical-range [rect]
  {:start (rect :y) :end (+ (rect :y) (rect :height))})

(defn- rect->horizontal-range [rect]
  {:start (rect :x) :end (+ (rect :x) (rect :width))})

(defn- find-vertical-overlap [rect-a rect-b]
  (intersection (rect->vertical-range rect-a)
                (rect->vertical-range rect-b)))

(defn- find-horizontal-overlap [rect-a rect-b]
  (intersection (rect->horizontal-range rect-a)
                (rect->horizontal-range rect-b)))

(defn- range->length [{:keys [start end]}]
  (- end start))

(defn rectangular-overlap
  "O(1) time solution - will return overlapping rectangle, nil if no overlap."
  [rect-a rect-b]
  (let [vertical-overlapping-range (find-vertical-overlap rect-a rect-b)
        horizontal-overlapping-range (find-horizontal-overlap rect-a rect-b)]
    (when (and vertical-overlapping-range horizontal-overlapping-range)
      {:x (horizontal-overlapping-range :start)
       :y (vertical-overlapping-range :start)
       :width (range->length horizontal-overlapping-range)
       :height (range->length vertical-overlapping-range)})))
