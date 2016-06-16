(ns top-scores.core-test
  (:require [clojure.test :refer :all]
            [top-scores.core :refer :all]))

(defn ordered? [coll]
  (apply <= coll))

(def coll-a (shuffle [5 3 4 8]))
(def coll-b (shuffle [45 78 2 4 9 99 100 23 17]))
(def coll-c (shuffle [4 49 15 2 2 3 15 17 9 13 23 45]))
(def coll-d (shuffle [678 812 13 100 245 346 45 98 99 956 100]))

(deftest counting-sort-test
  (testing "edge cases"
    (is (counting-sort [] 0) [])
    (is (ordered? (counting-sort [1] 1)))
    (is (ordered? (counting-sort [5] 5)))
    (is (ordered? (counting-sort [2 3] 3))))
  (testing "returns sorted collection"
    (is (ordered? (counting-sort coll-a 10)))
    (is (ordered? (counting-sort coll-b 100)))
    (is (ordered? (counting-sort coll-c 50)))
    (is (ordered? (counting-sort coll-d 1000)))))
