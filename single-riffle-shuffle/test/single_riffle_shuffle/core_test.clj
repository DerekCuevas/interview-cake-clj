(ns single-riffle-shuffle.core-test
  (:require [clojure.test :refer :all]
            [single-riffle-shuffle.core :refer :all]))

(def half-a-a [6 3 2])
(def half-a-b [4 1 7])
(def shuffled-a [6 3 4 2 1 7])

(def half-b-a [6 3 2])
(def half-b-b [4 1 7])
(def shuffled-b [7 2 3 1 4 6])

(def half-c-a [12 5 3 8 7])
(def half-c-b [9 2 1 0 5 6])
(def shuffled-c [12 5 9 2 1 0 5 3 8 7 6])

(def half-d-a [12 5 3 8 7])
(def half-d-b [9 2 1 0 5 6])
(def shuffled-d [12 5 9 2 5 6 0 1 3 8 7])

(deftest single-riffle-shuffle?-test
  (testing "Returns true if shuffled deck was single riffle shuffled."
    (is (= (single-riffle-shuffle? shuffled-a half-a-a half-a-b) true))
    (is (= (single-riffle-shuffle? shuffled-b half-b-a half-b-b) false))
    (is (= (single-riffle-shuffle? shuffled-c half-c-a half-c-b) true))
    (is (= (single-riffle-shuffle? shuffled-d half-d-a half-d-b) false))))
