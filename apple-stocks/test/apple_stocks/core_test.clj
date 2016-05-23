(ns apple-stocks.core-test
  (:require [clojure.test :refer :all]
            [apple-stocks.core :refer :all]))

(deftest get-max-profit-test
  (testing "edge cases"
    (is (= (get-max-profit []) 0))
    (is (= (get-max-profit '()) 0))
    (is (= (get-max-profit [0]) 0))
    (is (= (get-max-profit '(0)) 0))
    (is (= (get-max-profit '(2 7)) (- 7 2))))
  (testing "given set of stock prices, returns maximum profit"
    (is (= (get-max-profit [10 7 5 8 11 9]) 6))
    (is (= (get-max-profit [57 34 67 90 77]) 56))
    (is (= (get-max-profit [23 4 56 88 100 150]) 146))
    (is (= (get-max-profit (range 10)) 9))
    (is (= (get-max-profit (reverse (range 10))) 0))
    (is (= (get-max-profit (range 10 100 5)) 85))))
