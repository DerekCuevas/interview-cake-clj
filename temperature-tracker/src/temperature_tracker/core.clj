(ns temperature-tracker.core
  (:gen-class))

(def ^:private MAX_TEMP 110)
(def ^:private MIN_TEMP 0)

(defn insert
  ([temp]
    {:max-temp temp
     :min-temp temp
     :mean temp
     :sum temp
     :length 1
     :occurrences (assoc (vec (take MAX_TEMP (repeat 0))) temp 1)})
  ([stats temp]
    (let [sum (+ (stats :sum) temp)
          length (inc (stats :length))
          occurrences (stats :occurrences)
          updated-occurrences (assoc occurrences temp (inc (occurrences temp)))]
      {:max-temp (max temp (stats :max-temp))
       :min-temp (min temp (stats :min-temp))
       :mean (/ sum length)
       :sum sum
       :length length
       :occurrences updated-occurrences})))

(defn temps->stats [temps]
  (reduce insert (insert (first temps)) (rest temps)))
