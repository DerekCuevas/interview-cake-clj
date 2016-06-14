(ns product-of-all-other-numbers.core-test
  (:require [clojure.test :refer :all]
            [product-of-all-other-numbers.core :refer :all]))

(deftest  product-of-others-test
  (testing "edge cases"
    (is (= (product-of-others []) '()))
    (is (= (product-of-others '()) '()))
    (is (= (product-of-others [1]) '(1)))
    (is (= (product-of-others '(1)) '(1)))
    (is (= (product-of-others '(5)) '(1)))
    (is (= (product-of-others '(1 1 1)) '(1 1 1))))
  (testing "should map coll to the product of every integer except the integer at that index"
    (is (= (product-of-others [1 2 3 4 5]) '(120 60 40 30 24)))
    (is (= (product-of-others [1 7 3 4]) '(84 12 28 21)))
    (is (= (product-of-others [7 2 3 5]) '(30 105 70 42)))
    (is (= (product-of-others [3 2]) '(2 3)))))

(deftest  product-of-others-fast-test
  (testing "edge cases"
    (is (= (product-of-others-fast []) '()))
    (is (= (product-of-others-fast '()) '()))
    (is (= (product-of-others-fast [1]) '(1)))
    (is (= (product-of-others-fast '(1)) '(1)))
    (is (= (product-of-others-fast '(5)) '(1)))
    (is (= (product-of-others-fast '(1 1 1)) '(1 1 1))))
  (testing "should map coll to the product of every integer except the integer at that index"
    (is (= (product-of-others-fast [1 2 3 4 5]) '(120 60 40 30 24)))
    (is (= (product-of-others-fast [1 7 3 4]) '(84 12 28 21)))
    (is (= (product-of-others-fast [1 0 7 3 4]) '(0 84 0 0 0)))
    (is (= (product-of-others-fast [7 2 3 5]) '(30 105 70 42)))
    (is (= (product-of-others-fast [3 2]) '(2 3)))))
