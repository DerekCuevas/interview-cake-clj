(ns the-stolen-breakfast-drone.core-test
  (:require [clojure.test :refer :all]
            [the-stolen-breakfast-drone.core :refer :all]))

(def delivery-ids-a '(2 4 5 7 8 4 5 2 8))
(def delivery-ids-b '(23 77 12 34 9 76 23 13 67 12 77 76 9 13 67))
(def delivery-ids-c (shuffle (concat (range 100) (range 99))))
(def delivery-ids-d (shuffle (concat (range 1 50 3) (range 1 49 3))))

(deftest find-unique-test
  (testing "Should find unique integer in collection of ids."
    (is (= (find-unique delivery-ids-a) 7))
    (is (= (find-unique delivery-ids-b) 34))
    (is (= (find-unique delivery-ids-c) 99))
    (is (= (find-unique delivery-ids-d) 49))))

(deftest find-unique-bitwise-test
  (testing "Should find unique integer in collection of ids."
    (is (= (find-unique-bitwise delivery-ids-a) 7))
    (is (= (find-unique-bitwise delivery-ids-b) 34))
    (is (= (find-unique-bitwise delivery-ids-c) 99))
    (is (= (find-unique-bitwise delivery-ids-d) 49))))
