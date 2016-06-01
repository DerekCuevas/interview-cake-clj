(ns delete-node.core-test
  (:require [clojure.test :refer :all]
            [delete-node.core :refer :all]
            [delete-node.list :as list]))

(def list-a (list/coll->list [5 3 9 6 1]))
(def list-b (list/coll->list [2 4 6]))

(def removed-a {:value 3, :next {:value 9, :next {:value 6, :next {:value 1, :next nil}}}})
(def removed-b {:value 4, :next {:value 6, :next nil}})

(deftest delete-node-test
  (testing "should delete node from list - hard to test without mutation..."
    (is (= (delete list-a) removed-a))
    (is (= (delete list-b) removed-b))))
