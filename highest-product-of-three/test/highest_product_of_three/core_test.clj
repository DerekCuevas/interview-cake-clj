(ns highest-product-of-three.core-test
  (:require [clojure.test :refer :all]
            [highest-product-of-three.core :refer :all]))

(deftest highest-product-of-k-test
  (testing "edge cases"
    ;;(is (= (highest-product-of-k [] 3) 1))
    ;;(is (= (highest-product-of-k [2] 3) 2))
    ;;(is (= (highest-product-of-k [5 8] 3) 40))
    (is (= (highest-product-of-k [1 2 3] 3) 6)))
  (testing "highest product of three"
    (is (= (highest-product-of-k [5 8 7 2 3 5] 3) 280))
    (is (= (highest-product-of-k [6 4 5 2] 3) 120))
    (is (= (highest-product-of-k [3 5 7 1 2 4] 3) 140))
    (is (= (highest-product-of-k [5 8 -9] 3) -360))
    (is (= (highest-product-of-k [5 8 -9 -3] 3) 216))
    (is (= (highest-product-of-k [1 10 -5 1 -100] 3) 5000))))
