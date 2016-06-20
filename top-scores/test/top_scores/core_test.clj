(ns top-scores.core-test
  (:require [clojure.test :refer :all]
            [top-scores.core :refer :all]))

(defn ordered? [coll]
  (if (<= (count coll) 1)
    true
    (apply <= coll)))

(def coll-a (shuffle [5 3 4 8]))
(def coll-b (shuffle [45 78 2 4 9 99 100 23 17]))
(def coll-c (shuffle [4 49 15 2 2 3 15 17 9 13 23 45 4 13]))
(def coll-d (shuffle [678 812 13 100 245 346 45 98 99 956 100 13 812 812]))
(def coll-e (shuffle [1 1 1 3 3 3 3 4 4 5 6 6 6 6 6]))

(deftest counting-sort-test
  (testing "edge cases"
    (is (ordered? (counting-sort [] 0)))
    (is (ordered? (counting-sort [1] 1)))
    (is (ordered? (counting-sort [1 2] 2))))
  (testing "returns sorted collection"
    (is (ordered? (counting-sort coll-a 10)))
    (is (ordered? (counting-sort coll-b 100)))
    (is (ordered? (counting-sort coll-c 50)))
    (is (ordered? (counting-sort coll-d 1000)))
    (is (ordered? (counting-sort coll-e 6)))))
