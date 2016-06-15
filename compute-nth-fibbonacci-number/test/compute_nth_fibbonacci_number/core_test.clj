(ns compute-nth-fibbonacci-number.core-test
  (:require [clojure.test :refer :all]
            [compute-nth-fibbonacci-number.core :refer :all]))

(deftest fib-test
  (testing "fibonacci seq - very basic testing"
    (is (= (fib 0) 0))
    (is (= (fib 1) 1))
    (is (= (fib 2) 1))
    (is (= (fib 3) 2))
    (is (= (fib 4) 3))
    (is (= (fib 5) 5))
    (is (= (fib 6) 8))
    (is (= (fib 7) 13))
    (is (= (fib 8) 21))))
