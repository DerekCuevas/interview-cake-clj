(ns simulate-5-sided-die.core-test
  (:require [clojure.test :refer :all]
            [simulate-5-sided-die.core :refer :all]))

(deftest rand5-test
  (testing "should return random number between 1 and 5"
    (loop [n 5000]
      (let [rand (rand5)]
        (is (<= rand 5))
        (is (>= rand 1))
        (when-not (zero? (dec n))
          (recur (dec n)))))))
