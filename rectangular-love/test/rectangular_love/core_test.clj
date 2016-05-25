(ns rectangular-love.core-test
  (:require [clojure.test :refer :all]
            [rectangular-love.core :refer :all]))

(def rect-a {:x 1 :y 5 :width 10 :height 4})
(def rect-b {:x 3 :y 7 :width 5 :height 8})

(def overlapping {:x 1 :y 5 :width 10 :height 10})

(deftest a-test
  (testing "should return overlapping rectangle, nil if no overlap"
    (is (= (rectangular-overlap rect-a rect-b) overlapping))))
