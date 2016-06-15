(ns inflight-entertainment.core-test
  (:require [clojure.test :refer :all]
            [inflight-entertainment.core :refer :all]))

(def movies-lengths-a [109 130 80 65 150 75 120])
(def movies-lengths-b [100 105 80 60 120 50 160])
(def movies-lengths-c [34 88])

(def edge-a [])
(def edge-b [1])
(def edge-c [1 2])

(deftest can-two-movies-fill-flight?-test
  (testing "edge cases"
    (is (= (can-two-movies-fill-flight? edge-a 100) false))
    (is (= (can-two-movies-fill-flight? edge-b 1) false))
    (is (= (can-two-movies-fill-flight? edge-c 3) true)))
  (testing "returns true if the sum of two movies can fit in flight length"
    (is (= (can-two-movies-fill-flight? movies-lengths-a 100) false))
    (is (= (can-two-movies-fill-flight? movies-lengths-a 155) true))
    (is (= (can-two-movies-fill-flight? movies-lengths-a 259) true))
    (is (= (can-two-movies-fill-flight? movies-lengths-b 56) false))
    (is (= (can-two-movies-fill-flight? movies-lengths-b 110) true))
    (is (= (can-two-movies-fill-flight? movies-lengths-b 265) true))
    (is (= (can-two-movies-fill-flight? movies-lengths-c 45) false))
    (is (= (can-two-movies-fill-flight? movies-lengths-c 122) true))))
