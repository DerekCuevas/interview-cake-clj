(ns parenthesis-matching.core-test
  (:require [clojure.test :refer :all]
            [parenthesis-matching.core :refer :all]))

(def str-a "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.")
(def str-b "(lispy (lisp))")
(def str-c "(lispy (lisp) (lisp))")
(def str-d "(filter even? (map inc '(1 2 3 4)))")

(def edge-a "()")
(def edge-b "()()")
(def edge-c "(())")

(deftest find-closing-parenthesis-test
  (testing "edge cases"
    (is (= (find-closing-parenthesis edge-a 0) 1))
    (is (= (find-closing-parenthesis edge-b 2) 3))
    (is (= (find-closing-parenthesis edge-c 1) 2)))
  (testing "should return index of closing parenthesis"
    (is (= (find-closing-parenthesis str-a 10) 79))
    (is (= (find-closing-parenthesis str-a 28) 46))
    (is (= (find-closing-parenthesis str-b 0) (dec (count str-b))))
    (is (= (find-closing-parenthesis str-c 0) (dec (count str-c))))
    (is (= (find-closing-parenthesis str-d 0) (dec (count str-d))))
    (is (= (find-closing-parenthesis str-b 7) 12))
    (is (= (find-closing-parenthesis str-d 14) 33))
    (is (= (find-closing-parenthesis str-d 24) 32))))
