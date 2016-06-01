(ns cake-thief.core-test
  (:require [clojure.test :refer :all]
            [cake-thief.core :refer :all]))

(def cakes-a [{:weight 7 :value 160} {:weight 3 :value 90} {:weight 2 :value 15}])
(def cakes-b [{:weight 1 :value 30} {:weight 50 :value 200}])
(def cakes-c [{:weight 3 :value 40} {:weight 5 :value 70}])

(deftest max-duffel-bag-value-greedy-test
  (testing "Should return max monetary value duffel bag can hold."
    (is (= (max-duffel-bag-value-greedy cakes-a 20) 555))
    (is (= (max-duffel-bag-value-greedy cakes-b 100) 3000))
    (is (= (max-duffel-bag-value-greedy cakes-c 8) 110))))
    ;; (is (= (max-duffel-bag-value-greedy cakes-c 9) 120)))) ;; edge case

(deftest max-duffel-bag-value-greedy-test
  (testing "Should return max monetary value duffel bag can hold."
    (is (= (max-duffel-bag-value cakes-a 20) 555))
    (is (= (max-duffel-bag-value cakes-b 100) 3000))
    (is (= (max-duffel-bag-value cakes-c 8) 110))
    (is (= (max-duffel-bag-value cakes-c 9) 120))))
