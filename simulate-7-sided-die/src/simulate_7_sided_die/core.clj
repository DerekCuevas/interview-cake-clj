(ns simulate-7-sided-die.core
  (:gen-class))

(defn- random [floor ceiling]
  (+ floor (rand-int (inc (- ceiling floor)))))

(defn- rand5 []
  (random 1 5))

(def ^:private rand-table
  [[1 2 3 4 5]
   [6 7 1 2 3]
   [4 5 6 7 1]
   [2 3 4 5 6]
   [7 0 0 0 0]])

(defn rand7-table []
  (loop [row (dec (rand5))
         column (dec (rand5))]
    (if (and (= row 4) (> column 0))
      (recur (dec (rand5)) (dec (rand5)))
      (get-in rand-table [row column]))))

(defn rand7 []
  (loop [rand-a (rand5)
         rand-b (rand5)]
    (let [out (inc (+ (* (dec rand-a) 5)
                      (dec rand-b)))]
      (if (<= out 21)
        (inc (mod out 7))
        (recur (rand5) (rand5))))))
