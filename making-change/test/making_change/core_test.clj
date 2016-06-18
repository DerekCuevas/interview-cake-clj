(ns making-change.core-test
  (:require [clojure.test :refer :all]
            [making-change.core :refer :all]))

(def denominations-a #{1 2 3})
(def denominations-b #{1 2 3 4 5})
(def denominations-e #{8 6 4 2 0})
(def denominations-c #{2 5 8 9})

(def edge-a #{1})
(def edge-b #{1 2})
(def edge-c #{100 200})

(deftest ways-to-make-amount-test
  (testing "edge cases"
    (is (= (ways-to-make-amount 1 edge-a) 1))
    (is (= (ways-to-make-amount 5 edge-a) 1))
    (is (= (ways-to-make-amount 4 edge-b) 3))
    (is (= (ways-to-make-amount 5 edge-c) 0))
    (is (= (ways-to-make-amount 50 edge-c) 0)))
  (testing "returns number of distinct ways to make amount using denominations"
    (is (= (ways-to-make-amount 1 denominations-a) 1))
    (is (= (ways-to-make-amount 2 denominations-a) 2))
    (is (= (ways-to-make-amount 3 denominations-a) 2))
    (is (= (ways-to-make-amount 4 denominations-a) 4))))
