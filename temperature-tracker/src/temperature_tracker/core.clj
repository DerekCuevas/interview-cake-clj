(ns temperature-tracker.core
  (:gen-class))

(def ^:private MAX_TEMP 110)
(def ^:private MIN_TEMP 0)

(defn stats []
  {:max-temp MAX_TEMP
   :min-temp MIN_TEMP
   :mean 0
   :mode 0
   :sum 0
   :length 0
   :occurrences (into [] (repeat 110 0))})

(defn insert [{:keys [max-temp min-temp mean mode sum length occurrences]} temp]
  (let [updated-sum (+ sum temp)
        updated-length (inc length)
        updated-occurrences (assoc occurrences temp (inc (occurrences temp)))]
    {:max-temp (max temp max-temp)
     :min-temp (min temp min-temp)
     :mean (/ updated-sum updated-length)
     :mode (if (> (updated-occurrences temp) ))
     :sum updated-sum
     :length updated-length
     :occurrences updated-occurrences}))
