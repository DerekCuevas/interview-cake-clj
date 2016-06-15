(ns cake-thief.core-test
  (:require [clojure.test :refer :all]
            [cake-thief.core :refer :all]))

(def cakes-a
  [{:weight 7 :value 160}
   {:weight 3 :value 90}
   {:weight 2 :value 15}])

(def cakes-b
  [{:weight 1 :value 30}
   {:weight 50 :value 200}])

(def cakes-c
  [{:weight 3 :value 40}
   {:weight 5 :value 70}])

(def cakes-d
  [{:weight 8 :value 90}
   {:weight 23 :value 150}
   {:weight 17 :value 160}
   {:weight 32 :value 290}
   {:weight 4 :value 5}
   {:weight 55 :value 140}
   {:weight 7 :value 55}])

(deftest max-duffel-bag-value-greedy-test
  (testing "returns max monetary value duffel bag can hold - greedy approximation"
    (is (= (max-duffel-bag-value-greedy cakes-a 20) 555))
    (is (= (max-duffel-bag-value-greedy cakes-b 100) 3000))
    (is (= (max-duffel-bag-value-greedy cakes-c 8) 110))
    (is (= (max-duffel-bag-value-greedy cakes-d 500) 5585))

    ;; edge case - should fail greedy approximation
    (is (= (max-duffel-bag-value-greedy cakes-c 9) 120))))

(deftest max-duffel-bag-value-test
  (testing "returns max monetary value duffel bag can hold"
    (is (= (max-duffel-bag-value cakes-a 20) 555))
    (is (= (max-duffel-bag-value cakes-b 100) 3000))
    (is (= (max-duffel-bag-value cakes-c 8) 110))
    (is (= (max-duffel-bag-value cakes-c 9) 120))
    (is (= (max-duffel-bag-value cakes-d 17) 180))
    (is (= (max-duffel-bag-value cakes-d 34) 360))
    (is (= (max-duffel-bag-value cakes-d 500) 5585))))
