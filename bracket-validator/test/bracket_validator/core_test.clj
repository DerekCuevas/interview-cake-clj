(ns bracket-validator.core-test
  (:require [clojure.test :refer :all]
            [bracket-validator.core :refer :all]))

(def str-a "{[]()}")
(def str-b "{[(])}")
(def str-c "{[}")
(def str-d "{[()()[[()]{{}}]]}")
(def str-e "{[()([[(){{}]]}")

(def edge-a "[]")
(def edge-b ")")
(def edge-c "{")

(deftest valid-brackets?-test
  (testing "edge cases"
    (is (= (valid-brackets? edge-a) true))
    (is (= (valid-brackets? edge-b) false))
    (is (= (valid-brackets? edge-c) false)))
  (testing "checks validity of brackets"
    (is (= (valid-brackets? str-a) true))
    (is (= (valid-brackets? str-b) false))
    (is (= (valid-brackets? str-c) false))
    (is (= (valid-brackets? str-d) true))
    (is (= (valid-brackets? str-e) false))))
