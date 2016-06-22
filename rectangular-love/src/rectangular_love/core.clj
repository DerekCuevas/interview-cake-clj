(ns rectangular-love.core
  (:gen-class))

(defn- range->length [{:keys [start end]}]
  (- end start))

(defn- intersection [range-a range-b]
  (let [[first-range second-range] (sort-by :start [range-a range-b])]
    (when (>= (:end first-range) (:start second-range))
      {:start (max (:start first-range) (:start second-range))
       :end (min (:end first-range) (:end second-range))})))

(defn- rect->vertical-range [rect]
  {:start (:y rect)
   :end (+ (:y rect) (:height rect))})

(defn- rect->horizontal-range [rect]
  {:start (:x rect)
   :end (+ (:x rect) (:width rect))})

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
      {:x (:start horizontal-intersection)
       :y (:start vertical-intersection)
       :width (range->length horizontal-intersection)
       :height (range->length vertical-intersection)})))
