(ns find-repeat-space-edition.core-test
  (:require [clojure.test :refer :all]
            [find-repeat-space-edition.core :refer :all]))

(deftest find-dup-test
  (testing "edge cases"
    (is (= (find-dup []) 1))
    (is (= (find-dup [1 1]) 1)))
  (testing "returns duplicate item in range"
    (is (= (find-dup [1 2 2]) 2))
    (is (= (find-dup [2 2 1]) 2))
    (is (= (find-dup [3 4 4 5 1 2]) 4))
    (is (= (find-dup [5 4 3 7 1 2 6 6 8 9 10]) 6))
    (is (= (find-dup [1 1 2 3 4 5 6 7 8 9 10 11 12 13]) 1))
    (is (= (find-dup [1 2 3 4 5 6 7 8 9 10 11 12 13 13]) 13))
    (is (= (find-dup (concat (range 1 100) (range 99 200))) 99))))
