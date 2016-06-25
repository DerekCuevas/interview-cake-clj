(ns highest-product-of-three.core-test
  (:require [clojure.test :refer :all]
            [highest-product-of-three.core :refer :all]))

(def highest-product-of-1 (partial highest-product-of-k 1))
(def highest-product-of-2 (partial highest-product-of-k 2))
(def highest-product-of-3 (partial highest-product-of-k 3))
(def highest-product-of-4 (partial highest-product-of-k 4))
(def highest-product-of-5 (partial highest-product-of-k 5))
(def highest-product-of-8 (partial highest-product-of-k 8))

(deftest highest-product-of-k-test
  (testing "edge cases"
    (is (= (highest-product-of-1 [5]) 5))
    (is (= (highest-product-of-1 [-7]) -7))
    (is (= (highest-product-of-1 [-3 -5]) -3))
    (is (= (highest-product-of-2 [5]) 5))
    (is (= (highest-product-of-2 [1 -3 -5]) 15))
    (is (= (highest-product-of-2 [2 3 2 3 2 3 3 3 2 2]) 9))
    (is (= (highest-product-of-3 [0 2 3]) 0))
    (is (= (highest-product-of-3 [1 2 3]) 6))
    (is (= (highest-product-of-3 [2 3 2 3 2 3 3 3 2 2]) 27))
    (is (= (highest-product-of-4 [3 2 1]) 6)))
  (testing "returns highest product of k ints - handles negative numbers"
    (is (= (highest-product-of-3 [6 4 5 2]) 120))
    (is (= (highest-product-of-3 [5 8 7 2 3]) 280))
    (is (= (highest-product-of-3 [3 5 7 1 2 4]) 140))
    (is (= (highest-product-of-3 [5 8 -9]) -360))
    (is (= (highest-product-of-3 [5 8 -9 -3]) 216))
    (is (= (highest-product-of-3 [5 8 -9 -3 -5]) 360))
    (is (= (highest-product-of-4 [1 2 3 4 5]) 120))
    (is (= (highest-product-of-4 [1 2 -3 -4 -5]) 40))
    (is (= (highest-product-of-4 [1 -2 -3 -4 -5]) 120))
    (is (= (highest-product-of-5 (range 7)) 720))
    (is (= (highest-product-of-8 (range 10)) 362880))))
