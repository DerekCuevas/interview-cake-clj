(ns merge-sorted-arrays.core-test
  (:require [clojure.test :refer :all]
            [merge-sorted-arrays.core :refer :all]))

(def vec-a [1 2 3])
(def vec-b [3 4 7 9 13])
(def vec-c [1 2 5 23 54 67 89 123 456 789])
(def vec-d (vec (filter even? (range 1000))))
(def vec-e (vec (filter odd? (range 1000))))
(def vec-f (vec (range 1000)))

(def edge-a [])
(def edge-b [5])
(def edge-c '(4))

(deftest merge-colls-test
  (testing "edge cases"
    (is (= (merge-colls edge-a edge-a) edge-a))
    (is (= (merge-colls edge-a edge-b) edge-b))
    (is (= (merge-colls edge-b edge-c) (concat edge-c edge-b))))
  (testing "should merge sorted collections."
    (is (= (merge-colls vec-a edge-a) vec-a))
    (is (= (merge-colls vec-a vec-b) (concat vec-a vec-b)))
    (is (= (merge-colls (seq vec-a) (seq vec-b)) (concat vec-a vec-b)))
    (is (= (merge-colls vec-b vec-c) [1 2 3 4 5 7 9 13 23 54 67 89 123 456 789]))
    (is (= (merge-colls vec-d vec-e) vec-f))))
