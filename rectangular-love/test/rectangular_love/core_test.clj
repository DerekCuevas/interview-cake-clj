(ns rectangular-love.core-test
  (:require [clojure.test :refer :all]
            [rectangular-love.core :refer :all]))

(def rect-a {:x 1 :y 5 :width 10 :height 4})
(def rect-b {:x 3 :y 7 :width 5 :height 8})
(def rect-c {:x -5 :y 3 :width 7 :height 10})
(def rect-d {:x 0 :y 0 :width 8 :height 12})

(def overlapping-ab {:x 3 :y 7 :width 5 :height 2})
(def overlapping-bc nil)
(def overlapping-cd {:x 0 :y 3 :width 2 :height 9})
(def overlapping-ad {:x 1 :y 5 :width 7 :height 4})

(deftest a-test
  (testing "should return overlapping rectangle, nil if no overlap"
    (is (= (rectangular-overlap rect-a rect-b) overlapping-ab))
    (is (= (rectangular-overlap rect-b rect-c) overlapping-bc))
    (is (= (rectangular-overlap rect-c rect-d) overlapping-cd))
    (is (= (rectangular-overlap rect-a rect-d) overlapping-ad))))
