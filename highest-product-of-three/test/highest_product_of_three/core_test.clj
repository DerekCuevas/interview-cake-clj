(ns highest-product-of-three.core-test
  (:require [clojure.test :refer :all]
            [highest-product-of-three.core :refer :all]))

(deftest highest-product-of-three-test
  (testing "highest product of three"
    (is (= (highest-product-of-three-positive-ints [5 8 7 2 3 5]) 280))
    (is (= (highest-product-of-three-positive-ints [1 2 3]) 6))
    (is (= (highest-product-of-three-positive-ints [6 4 5 2]) 120))
    (is (= (highest-product-of-three-positive-ints [3 5 7 1 2 4]) 140))
    (is (= (highest-product-of-three-positive-ints [5 8]) 40))))
