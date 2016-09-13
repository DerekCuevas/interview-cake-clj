(ns simulate-7-sided-die.core
  (:gen-class))

(defn- random [floor ceiling]
  (+ floor (rand-int (inc (- ceiling floor)))))

(defn- rand5 []
  (random 1 5))

(def ^:private rand7-matrix
  (->> (range 1 8)
       (cycle)
       (take 21)
       (partition 5 5 (repeat 0))
       (mapv vec)))

(defn rand7-with-matrix []
  (loop [row (dec (rand5))
         column (dec (rand5))]
    (if (and (= row 4) (> column 0))
      (recur (dec (rand5)) (dec (rand5)))
      (get-in rand7-matrix [row column]))))

(defn rand7 []
  (loop [rand-a (rand5)
         rand-b (rand5)]
    (let [out (inc (+ (* (dec rand-a) 5) (dec rand-b)))]
      (if (<= out 21)
        (inc (mod out 7))
        (recur (rand5) (rand5))))))
