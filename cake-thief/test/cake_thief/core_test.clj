(ns cake-thief.core-test
  (:require [clojure.test :refer :all]
            [cake-thief.core :refer :all]))

(def cakes-a [{:weight 7 :value 160} {:weight 3 :value 90} {:weight 2 :value 15}])

(deftest max-duffel-bag-value-greedy-test
  (testing "Should return max monetary value duffel bag can hold."
    (is (= (max-duffel-bag-value-greedy cakes-a 20) 555))))
