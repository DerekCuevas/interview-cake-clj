(ns apple-stocks.core-test
  (:require [clojure.test :refer :all]
            [apple-stocks.core :refer :all]))

(deftest get-max-profit-test
  (testing "edge cases"
    (is (= (get-max-profit []) 0))
    (is (= (get-max-profit [0]) 0)))
  (testing "given set of stock prices, returns maximum profit"
    (is (= (get-max-profit [10 7 5 8 11 9]) 6))))
