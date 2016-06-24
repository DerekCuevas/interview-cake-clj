(ns merging-meeting-times.core
  (:gen-class))

(defn- merge-if-overlap [meeting-a meeting-b]
  (let [[earlier later] (sort-by :start [meeting-a meeting-b])]
    (when (>= (:end earlier) (:start later))
      {:start (:start earlier)
       :end (max (:end earlier) (:end later))})))

(defn merge-meeting-times
  "O(nlgn) soluting - sorting input meeting times."
  [meeting-times]
  (let [[first-meeting & rest-meetings] (sort-by :start meeting-times)]
    (reduce
     (fn [merged-so-far meeting]
       (if-let [merged (merge-if-overlap (last merged-so-far) meeting)]
         (conj (pop merged-so-far) merged)
         (conj merged-so-far meeting)))
     [first-meeting]
     rest-meetings)))
