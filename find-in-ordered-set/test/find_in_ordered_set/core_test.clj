(ns find-in-ordered-set.core-test
  (:require [clojure.test :refer :all]
            [find-in-ordered-set.core :refer :all]))

(deftest binary-search-test
  (testing "edge cases"
    (is (= (binary-search '() 1) -1))
    (is (= (binary-search (range 5) 10) -1))
    (is (= (binary-search '(1 2) 3) -1))
    (is (= (binary-search '(1 2) 2) 1)))
  (testing "binary search"
    (is (= (binary-search (range 10) 2) 2))
    (is (= (binary-search (range 2 20 2) 2) 0))
    (is (= (binary-search (range 2 20 2) 12) 5))
    (is (= (binary-search (range 0 10 3) 9) 3))))
