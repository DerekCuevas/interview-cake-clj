(ns binary-search-tree-checker.core-test
  (:require [clojure.test :refer :all]
            [binary-search-tree-checker.core :refer :all]
            [binary-search-tree-checker.binary-tree :as tree]))

(def valid-a (tree/coll->binary-search-tree [10]))
(def valid-b (tree/coll->binary-search-tree [10 5 15 20]))
(def valid-c (tree/coll->binary-search-tree (range 100)))
(def valid-d (tree/coll->binary-search-tree [10 5 15 20 45 32 2 90 100 22]))
(def valid-e (tree/coll->binary-search-tree [10 5 15 20]))

(def invalid-a (assoc (tree/node 10) :left (tree/node 20)))
(def invalid-b (assoc (tree/node 10) :right (tree/node 5)))
(def invalid-c (assoc-in valid-b [:left :right] (tree/node 25)))
(def invalid-d (assoc-in valid-d [:left :left :left] (tree/node 125)))

(deftest bst?-test
  (testing "egde cases"
    (is (= (bst? {}) true))
    (is (= (bst? (tree/node 4)) true)))
  (testing "should test weather a binary tree is a valid binary search tree"
    (is (= (bst? valid-a) true))
    (is (= (bst? valid-b) true))
    (is (= (bst? valid-c) true))
    (is (= (bst? valid-d) true))
    (is (= (bst? valid-e) true))
    (is (= (bst? invalid-a) false))
    (is (= (bst? invalid-b) false))
    (is (= (bst? invalid-c) false))
    (is (= (bst? invalid-d) false))))
