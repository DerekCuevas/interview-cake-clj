(ns making-change.core-test
  (:require [clojure.test :refer :all]
            [making-change.core :refer :all]))

(def denominations-a #{1 2 3})
(def denominations-b #{1 2 3 4 5})
(def denominations-c #{2 5 8 9})

(def edge-denominations-a #{1})
(def edge-denominations-b #{1 2})
(def edge-denominations-c #{100 200})

(deftest ways-to-make-amount-test
  (testing "edge cases"
    (is (= (ways-to-make-amount 1 edge-denominations-a) 1))
    (is (= (ways-to-make-amount 5 edge-denominations-a) 1))
    (is (= (ways-to-make-amount 4 edge-denominations-b) 3))
    (is (= (ways-to-make-amount 5 edge-denominations-c) 0))
    (is (= (ways-to-make-amount 50 edge-denominations-c) 0)))
  (testing "returns number of distinct ways to make amount using denominations"
    (is (= (ways-to-make-amount 1 denominations-a) 1))
    (is (= (ways-to-make-amount 2 denominations-a) 2))
    (is (= (ways-to-make-amount 3 denominations-a) 3))
    (is (= (ways-to-make-amount 4 denominations-a) 4))
    (is (= (ways-to-make-amount 3 denominations-b) 3))
    (is (= (ways-to-make-amount 5 denominations-b) 7))
    (is (= (ways-to-make-amount 1 denominations-c) 0))
    (is (= (ways-to-make-amount 2 denominations-c) 1))
    (is (= (ways-to-make-amount 18 denominations-c) 7))))
