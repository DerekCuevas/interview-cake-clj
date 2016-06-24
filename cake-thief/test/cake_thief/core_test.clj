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

(def edge-a
 [{:weight 5 :value 30}])

(deftest max-duffel-bag-value-test
  (testing "edge cases"
    (is (= (max-duffel-bag-value [] 10) 0))
    (is (= (max-duffel-bag-value edge-a 4) 0))
    (is (= (max-duffel-bag-value edge-a 5) 30))
    (is (= (max-duffel-bag-value edge-a 20) 120)))
  (testing "returns max monetary value duffel bag can hold"
    (is (= (max-duffel-bag-value cakes-a 20) 555))
    (is (= (max-duffel-bag-value cakes-b 100) 3000))
    (is (= (max-duffel-bag-value cakes-c 8) 110))
    (is (= (max-duffel-bag-value cakes-c 9) 120))
    (is (= (max-duffel-bag-value cakes-d 17) 180))
    (is (= (max-duffel-bag-value cakes-d 34) 360))
    (is (= (max-duffel-bag-value cakes-d 500) 5585))))
