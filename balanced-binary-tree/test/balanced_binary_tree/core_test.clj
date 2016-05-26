(ns balanced-binary-tree.core-test
  (:require [clojure.test :refer :all]
            [balanced-binary-tree.core :refer :all]
            [balanced-binary-tree.binary-tree :as tree]))

(def balanced-a (tree/coll->binary-search-tree [10 5 15 0 20]))
(def balanced-b (tree/coll->binary-search-tree [10 5 15 20]))
(def unbalanced-a (tree/coll->binary-search-tree (range 10)))
(def unbalanced-b (tree/coll->binary-search-tree [10 5 15 20 25]))

(def edge-a (tree/coll->binary-search-tree []))
(def edge-b (tree/coll->binary-search-tree [10]))
(def edge-c (tree/coll->binary-search-tree [10 5]))

(deftest balanced?-test
  (testing "edge cases"
    (is (= (balanced? edge-a) true))
    (is (= (balanced? edge-b) true))
    (is (= (balanced? edge-c) true)))
  (testing "should check if a binary tree is balanced"
    (is (= (balanced? balanced-a) true))
    (is (= (balanced? balanced-b) true))
    (is (= (balanced? unbalanced-a) false))
    (is (= (balanced? unbalanced-b) false))))
