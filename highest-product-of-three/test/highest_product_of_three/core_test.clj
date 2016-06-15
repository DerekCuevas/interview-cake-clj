(ns highest-product-of-three.core-test
  (:require [clojure.test :refer :all]
            [highest-product-of-three.core :refer :all]))

(deftest highest-product-of-three-positive-ints-test
  (testing "should return highest product of three positive ints"
    (is (= (highest-product-of-three-positive-ints [5 8 7 2 3 5]) 280))
    (is (= (highest-product-of-three-positive-ints [1 2 3]) 6))
    (is (= (highest-product-of-three-positive-ints [6 4 5 2]) 120))
    (is (= (highest-product-of-three-positive-ints [3 5 7 1 2 4]) 140))
    (is (= (highest-product-of-three-positive-ints [5 8]) 40))))

(deftest highest-product-of-three-test
  (testing "edge cases"
    (is (= (highest-product-of-three []) 1))
    (is (= (highest-product-of-three [2]) 2))
    (is (= (highest-product-of-three [5 8]) 40))
    (is (= (highest-product-of-three [1 2 3]) 6)))
  (testing "highest product of three"
    (is (= (highest-product-of-three [5 8 7 2 3 5]) 280))
    (is (= (highest-product-of-three [6 4 5 2]) 120))
    (is (= (highest-product-of-three [3 5 7 1 2 4]) 140))
    (is (= (highest-product-of-three [5 8 -9]) -360))
    (is (= (highest-product-of-three [5 8 -9 -3]) 216))
    (is (= (highest-product-of-three [1 10 -5 1 -100]) 5000))))
