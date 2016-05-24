(ns merging-meeting-times.core-test
  (:require [clojure.test :refer :all]
            [merging-meeting-times.core :refer :all]))

(def meeting-times [[{:start 0 :end 1}
                     {:start 3 :end 5}
                     {:start 4 :end 8}
                     {:start 10 :end 12}
                     {:start 9 :end 10}]
                    [{:start 0 :end 10}
                     {:start 3 :end 5}
                     {:start 4 :end 8}
                     {:start 10 :end 12}
                     {:start 9 :end 10}]
                    [{:start 8 :end 9}
                     {:start 3 :end 5}
                     {:start 0 :end 2}
                     {:start 4 :end 8}
                     {:start 6 :end 10}]])

(deftest merge-meeting-times-test
  (testing "should merge overlapping meetings"
    (is (= (merge-meeting-times (nth meeting-times 0)) [{:start 0 :end 1}
                                                        {:start 3 :end 8}
                                                        {:start 9 :end 12}]))
    (is (= (merge-meeting-times (nth meeting-times 1)) [{:start 0 :end 12}]))))
    (is (= (merge-meeting-times (nth meeting-times 2)) [{:start 0 :end 2}
                                                        {:start 3 :end 10}]))
