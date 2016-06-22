(ns reverse-linked-list.core-test
  (:require [clojure.test :refer :all]
            [reverse-linked-list.core :refer :all]
            [reverse-linked-list.list :as list]))

(def list-a (list/coll->list [4 2]))
(def list-b (list/coll->list [6 7 8]))
(def list-c (list/coll->list [5 8 3 4]))

(def reversed-a (list/coll->list [2 4]))
(def reversed-b (list/coll->list [8 7 6]))
(def reversed-c (list/coll->list [4 3 8 5]))

(deftest reverse-list-test
  (testing "edge cases"
    (is (= (reverse-list (list/coll->list [7])) (list/coll->list [7]))))
  (testing "returns reversed list, not in-place"
    (is (= (reverse-list list-a) reversed-a))
    (is (= (reverse-list list-b) reversed-b))
    (is (= (reverse-list list-c) reversed-c))))
