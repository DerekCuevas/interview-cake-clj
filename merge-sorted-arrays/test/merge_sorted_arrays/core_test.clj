(ns merge-sorted-arrays.core-test
  (:require [clojure.test :refer :all]
            [merge-sorted-arrays.core :refer :all]))

(def coll-a '(1 2 3))
(def coll-b '(3 4 7 9 13))
(def coll-c '(1 2 5 23 54 67 89 123 456 789))
(def coll-d (filter even? (range 1000)))
(def coll-e (filter odd? (range 1000)))
(def coll-f (range 1000))

(def edge-a '())
(def edge-b '(5))

(deftest merge-colls-test
  (testing "edge cases"
    (is (= (merge-colls edge-a edge-a) edge-a))
    (is (= (merge-colls edge-a edge-b) edge-b)))
  (testing "should merge sorted collections."
    (is (= (merge-colls coll-a edge-a) coll-a))
    (is (= (merge-colls coll-a coll-b) (concat coll-a coll-b)))
    (is (= (merge-colls coll-b coll-c) '(1 2 3 4 5 7 9 13 23 54 67 89 123 456 789)))
    (is (= (merge-colls coll-d coll-e) coll-f))))
