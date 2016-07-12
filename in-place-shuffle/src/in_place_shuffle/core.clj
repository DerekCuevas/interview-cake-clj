(ns in-place-shuffle.core
  (:gen-class))

(defn- random [floor ceiling]
  (+ floor (rand-int (inc (- ceiling floor)))))

(defn- swap [arr idx-a idx-b]
  (-> arr
      (assoc idx-a (get arr idx-b))
      (assoc idx-b (get arr idx-a))))

(defn fisher-yates-shuffle
  "O(n) time solution - can't do this in-place ~ but can use similar algorithm."
  [arr]
  (reduce
   (fn [shuffled idx]
     (->> (random idx (dec (count arr)))
          (swap shuffled idx)))
   arr
   (range (count arr))))
