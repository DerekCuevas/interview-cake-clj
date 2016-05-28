(ns second-largest-in-binary-search-tree.core-test
  (:require [clojure.test :refer :all]
            [second-largest-in-binary-search-tree.core :refer :all]
            [second-largest-in-binary-search-tree.binary-tree :as tree]))

(def bst-a (tree/coll->binary-search-tree [10 9]))
(def bst-b (tree/coll->binary-search-tree [10 5 15 20]))
(def bst-c (tree/coll->binary-search-tree (range 100)))
(def bst-d (tree/coll->binary-search-tree [10 5 15 20 45 32 2 90 100 22]))
(def bst-e (tree/coll->binary-search-tree [10 5 15 20 17 2]))
(def bst-f (tree/coll->binary-search-tree [10 5 8 15 20 18 17 19]))

(def edge-a (tree/coll->binary-search-tree []))
(def edge-b (tree/coll->binary-search-tree [10]))

(deftest second-largest-test
  (testing "edge cases"
    (is (= (second-largest edge-a) nil))
    (is (= (second-largest edge-b) nil)))
  (testing "should return second largest item in bst"
    (is (= (second-largest bst-a) 9))
    (is (= (second-largest bst-b) 15))
    (is (= (second-largest bst-c) 98))
    (is (= (second-largest bst-d) 90))
    (is (= (second-largest bst-e) 17))
    (is (= (second-largest bst-f) 19))))
