(ns simulate-7-sided-die.core
  (:gen-class))

(defn- random [floor ceiling]
  (+ floor (rand-int (inc (- ceiling floor)))))

(defn- rand5 []
  (random 1 5))

(defn rand7 []
  -1)
