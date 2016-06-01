(ns reverse-linked-list.core-test
  (:require [clojure.test :refer :all]
            [reverse-linked-list.core :refer :all]
            [reverse-linked-list.list :as list]))

(def list-a (list/coll->list [4 2]))
(def list-b (list/coll->list [6 7 8]))
(def list-c (list/coll->list [5 8 3 4]))

(def reversed-a {:value 2 :next {:value 4 :next nil}})
(def reversed-b {:value 8 :next {:value 7 :next {:value 6 :next nil}}})
(def reversed-c {:value 4 :next {:value 3 :next {:value 8 :next {:value 5 :next nil}}}})

(deftest reverse-list-test
  (testing "Should reverse list, not in-place."
    (is (= (reverse-list list-a) reversed-a))
    (is (= (reverse-list list-b) reversed-b))
    (is (= (reverse-list list-c) reversed-c))))
