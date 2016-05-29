(ns find-rotation-point.core-test
  (:require [clojure.test :refer :all]
            [find-rotation-point.core :refer :all]))

(def words-a ["ptolemaic"
              "retrograde"
              "supplant"
              "undulate"
              "xenoepist"
              "asymptote"
              "babka"
              "banoffee"
              "engender"
              "karpatka"
              "othellolagkage"])

(def words-b ["ptolemaic"
              "retrograde"
              "asymptote"
              "babka"
              "banoffee"
              "engender"
              "karpatka"
              "othellolagkage"])

(def words-c ["ptolemaic"
              "supplant"
              "undulate"
              "xenoepist"
              "banoffee"
              "engender"
              "othellolagkage"])

(deftest find-rotation-point-test
  (testing "should return index of rotation"
    (is (= (find-rotation-point words-a) 5))
    (is (= (find-rotation-point words-b) 2))
    (is (= (find-rotation-point words-c) 4))))

(deftest find-rotation-point-fast-test
  (testing "should return index of rotation"
    (is (= (find-rotation-point-fast words-a) 5))
    (is (= (find-rotation-point-fast words-b) 2))
    (is (= (find-rotation-point-fast words-c) 4))))
