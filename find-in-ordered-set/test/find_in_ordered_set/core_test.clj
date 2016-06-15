(ns find-in-ordered-set.core-test
  (:require [clojure.test :refer :all]
            [find-in-ordered-set.core :refer :all]))

(deftest binary-search-test
  (testing "edge cases"
    (is (= (binary-search [] 1) -1))
    (is (= (binary-search (vec (range 5)) 10) -1))
    (is (= (binary-search [1 2] 3) -1))
    (is (= (binary-search [1 2] 2) 1)))
  (testing "should return index of item in vector, -1 if not found"
    (is (= (binary-search (vec (range 10)) 2) 2))
    (is (= (binary-search (vec (range 2 20 2)) 2) 0))
    (is (= (binary-search (vec (range 2 20 2)) 12) 5))
    (is (= (binary-search (vec (range 0 10 3)) 9) 3))
    (is (= (binary-search (vec (range 0 10 3)) 3) 1))
    (is (= (binary-search (vec (range 0 10 3)) 0) 0))
    (is (= (binary-search (vec (range 0 100 3)) 45) 15))
    (is (= (binary-search (vec (range 0 100 3)) 500) -1))))
