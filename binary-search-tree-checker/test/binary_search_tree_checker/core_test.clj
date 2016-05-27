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

(deftest valid-binary-search-tree?-test
  (testing "egde cases"
    (is (= (valid-binary-search-tree? {}) true))
    (is (= (valid-binary-search-tree? (tree/node 4)) true)))
  (testing "should test weather a binary tree is a valid binary search tree"
    (is (= (valid-binary-search-tree? valid-a) true))
    (is (= (valid-binary-search-tree? valid-b) true))
    (is (= (valid-binary-search-tree? valid-c) true))
    (is (= (valid-binary-search-tree? valid-d) true))
    (is (= (valid-binary-search-tree? valid-e) true))
    (is (= (valid-binary-search-tree? invalid-a) false))
    (is (= (valid-binary-search-tree? invalid-b) false))
    (is (= (valid-binary-search-tree? invalid-c) false))
    (is (= (valid-binary-search-tree? invalid-d) false))))

(deftest valid-binary-search-tree-rec?-test
  (testing "egde cases"
    (is (= (valid-binary-search-tree-rec? {}) true))
    (is (= (valid-binary-search-tree-rec? (tree/node 4)) true)))
  (testing "should test weather a binary tree is a valid binary search tree"
    (is (= (valid-binary-search-tree-rec? valid-a) true))
    (is (= (valid-binary-search-tree-rec? valid-b) true))
    (is (= (valid-binary-search-tree-rec? valid-c) true))
    (is (= (valid-binary-search-tree-rec? valid-d) true))
    (is (= (valid-binary-search-tree-rec? valid-e) true))
    (is (= (valid-binary-search-tree-rec? invalid-a) false))
    (is (= (valid-binary-search-tree-rec? invalid-b) false))
    (is (= (valid-binary-search-tree-rec? invalid-c) false))
    (is (= (valid-binary-search-tree-rec? invalid-d) false))))
