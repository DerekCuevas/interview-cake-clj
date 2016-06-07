(ns which-appears-twice.core-test
  (:require [clojure.test :refer :all]
            [which-appears-twice.core :refer :all]))

(def range-a '(1 2 3 3))
(def range-b '(1 2 2 3 4))
(def range-c '(1 2 3 4 4 5 6 7 8 9))
(def range-d '(1 2 3 4 5 6 7 8 9 10 11 12 12 13))
(def range-e (concat (range 10) (range 9 20 1)))

(deftest find-dup-in-range-test
  (testing "should return duplicate value in range of 1...n"
    (is (= (find-dup-in-range range-a 3) 3))
    (is (= (find-dup-in-range range-b 4) 2))
    (is (= (find-dup-in-range range-c 4) 9))
    (is (= (find-dup-in-range range-d 13) 12))
    (is (= (find-dup-in-range range-e 19) 9))))
