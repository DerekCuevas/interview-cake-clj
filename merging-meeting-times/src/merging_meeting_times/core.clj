(ns merging-meeting-times.core
  (:gen-class))

(defn meetings-overlap?
  "Returns ordered (by start time) meetings if overlap, nil otherwise."
  [meeting-a meeting-b]
  (let [[earlier later :as sorted] (sort-by :start [meeting-a meeting-b])]
    (when (>= (earlier :end) (later :start))
      sorted)))

(defn merge-meetings
  "Merges meetings if overlap, nil otherwise."
  [meeting-a meeting-b]
  (when-let [[earlier later] (meetings-overlap? meeting-a meeting-b)]
    {:start (earlier :start)
     :end (max (earlier :end) (later :end))}))

(defn merge-meeting-times
  "O(nlgn) soluting - sorting input meeting times"
  [meeting-times]
  (let [sorted (sort-by :start meeting-times)]
    (reduce (fn [merged meeting]
              (let [last-meeting (last merged)]
                (if (meetings-overlap? last-meeting meeting)
                  (conj (pop merged)
                        (merge-meetings last-meeting meeting))
                  (conj merged meeting))))
            [(first sorted)]
            (rest sorted))))
