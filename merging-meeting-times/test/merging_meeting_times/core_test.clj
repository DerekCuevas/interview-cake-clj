(ns merging-meeting-times.core-test
  (:require [clojure.test :refer :all]
            [merging-meeting-times.core :refer :all]))

(def meeting-times-a
  [{:start 0 :end 1}
   {:start 3 :end 5}
   {:start 4 :end 8}
   {:start 10 :end 12}
   {:start 9 :end 10}])

(def merged-meetings-a
  [{:start 0 :end 1}
   {:start 3 :end 8}
   {:start 9 :end 12}])

(def meeting-times-b
  [{:start 0 :end 10}
   {:start 3 :end 5}
   {:start 4 :end 8}
   {:start 10 :end 12}
   {:start 9 :end 10}])

(def merged-meetings-b
  [{:start 0 :end 12}])

(def meeting-times-c
  [{:start 8 :end 9}
   {:start 3 :end 5}
   {:start 0 :end 2}
   {:start 4 :end 8}
   {:start 6 :end 10}])

(def merged-meetings-c
  [{:start 0 :end 2}
   {:start 3 :end 10}])

(def meeting-times-d
  [{:start 4 :end 9}
   {:start 3 :end 5}])

(def merged-meetings-d
  [{:start 3 :end 9}])

(deftest merge-meeting-times-test
  (testing "edge cases"
    (is (= (merge-meeting-times [{}]) [{}]))
    (is (= (merge-meeting-times [{:start 4 :end 9}]) [{:start 4 :end 9}])))
  (testing "should merge overlapping meetings"
    (is (= (merge-meeting-times meeting-times-a) merged-meetings-a))
    (is (= (merge-meeting-times meeting-times-b) merged-meetings-b))
    (is (= (merge-meeting-times meeting-times-c) merged-meetings-c))
    (is (= (merge-meeting-times meeting-times-d) merged-meetings-d))))
