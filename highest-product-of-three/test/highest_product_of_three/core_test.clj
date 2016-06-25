(ns highest-product-of-three.core-test
  (:require [clojure.test :refer :all]
            [highest-product-of-three.core :refer :all]))

(deftest highest-product-of-k-test
  (testing "edge cases"
    (is (= (highest-product-of-k [5] 1) 5))
    (is (= (highest-product-of-k [5] 2) 5))
    (is (= (highest-product-of-k [-7] 1) -7))
    (is (= (highest-product-of-k [-3 -5] 1) -3))
    (is (= (highest-product-of-k [-3 -5] 2) 15))
    (is (= (highest-product-of-k [1 2 3] 3) 6))
    (is (= (highest-product-of-k [3 2 1] 4) 6))
    (is (= (highest-product-of-k [2 3 2 3 2 3 3 3 2 2] 2) 9))
    (is (= (highest-product-of-k [2 3 2 3 2 3 3 3 2 2] 3) 27)))
  (testing "returns highest product of k ints - handles negative numbers"
    (is (= (highest-product-of-k [6 4 5 2] 3) 120))
    (is (= (highest-product-of-k [5 8 7 2 3] 3) 280))
    (is (= (highest-product-of-k [3 5 7 1 2 4] 3) 140))
    (is (= (highest-product-of-k [5 8 -9] 3) -360))
    (is (= (highest-product-of-k [5 8 -9 -3] 3) 216))
    (is (= (highest-product-of-k [5 8 -9 -3 -5] 3) 360))
    (is (= (highest-product-of-k [1 2 3 4 5] 4) 120))
    (is (= (highest-product-of-k [1 2 -3 -4 -5] 4) 40))
    (is (= (highest-product-of-k [1 -2 -3 -4 -5] 4) 120))
    (is (= (highest-product-of-k (range 7) 5) 720))
    (is (= (highest-product-of-k (range 10) 8) 362880))))
