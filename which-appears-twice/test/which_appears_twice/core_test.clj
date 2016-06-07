(ns which-appears-twice.core-test
  (:require [clojure.test :refer :all]
            [which-appears-twice.core :refer :all]))

(def range-a '(1 2 3 3))
(def range-b '(1 2 2 3 4))
(def range-c '(1 2 3 4 4 5 6 7 8 9))
(def range-d '(1 2 3 4 5 6 7 8 9 10 11 12 12 13))
(def range-e (concat (range 10) (range 9 20 1)))

(def edge-a '(1 1))
(def edge-b '(1 2 2))

(deftest find-dup-in-range-test
  (testing "edge cases"
    (is (= (find-dup-in-range edge-a 1) 1))
    (is (= (find-dup-in-range edge-b 2) 2)))
  (testing "should return duplicate value in range of 1...n"
    (is (= (find-dup-in-range range-a 3) 3))
    (is (= (find-dup-in-range range-b 4) 2))
    (is (= (find-dup-in-range range-c 9) 4))
    (is (= (find-dup-in-range range-d 13) 12))
    (is (= (find-dup-in-range range-e 19) 9))))

(deftest find-dup-in-range-with-sum-test
  (testing "edge cases"
    (is (= (find-dup-in-range-with-sum edge-a 1) 1))
    (is (= (find-dup-in-range-with-sum edge-b 2) 2)))
  (testing "should return duplicate value in range of 1...n"
    (is (= (find-dup-in-range-with-sum range-a 3) 3))
    (is (= (find-dup-in-range-with-sum range-b 4) 2))
    (is (= (find-dup-in-range-with-sum range-c 9) 4))
    (is (= (find-dup-in-range-with-sum range-d 13) 12))
    (is (= (find-dup-in-range-with-sum range-e 19) 9))))
