(ns in-place-shuffle.core
  (:gen-class))

(defn- random [floor ceiling]
  (+ floor (rand-int (inc (- ceiling floor)))))

(defn fisher-yates-shuffle
  "O(n) time solution - can't do this in-place ~ but can use similar algorithm."
  [arr]
  (reduce
   (fn [shuffled idx]
     (let [rand-idx (random idx (dec (count arr)))]
       (-> shuffled
           (assoc rand-idx (get shuffled idx))
           (assoc idx (get shuffled rand-idx)))))
   arr
   (range (count arr))))
