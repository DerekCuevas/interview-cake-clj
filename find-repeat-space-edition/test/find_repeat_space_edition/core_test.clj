(ns find-repeat-space-edition.core-test
  (:require [clojure.test :refer :all]
            [find-repeat-space-edition.core :refer :all]))

(deftest find-repeat-test
  (testing "edge cases"
    (is (= (find-repeat []) 1))
    (is (= (find-repeat [1 1]) 1))
    (is (= (find-repeat '()) 1))
    (is (= (find-repeat '(1 2 2 3)) 2)))
  (testing "returns duplicate item in range"
    (is (= (find-repeat [1 2 2]) 2))
    (is (= (find-repeat [2 2 1]) 2))
    (is (= (find-repeat [3 4 4 5 1 2]) 4))
    (is (= (find-repeat '(3 4 4 5 1 2)) 4))
    (is (= (find-repeat [5 4 3 7 1 2 6 6 8 9 10]) 6))
    (is (= (find-repeat [1 1 2 3 4 5 6 7 8 9 10 11 12 13]) 1))
    (is (= (find-repeat [1 2 3 4 5 6 7 8 9 10 11 12 13 13]) 13))
    (is (= (find-repeat (concat (range 1 100) (range 99 200))) 99))
    (is (= (find-repeat (reverse (concat (range 1 50) (range 49 60)))) 49))
    (is (= (find-repeat (shuffle (concat (range 1 50) (range 49 200)))) 49))))
