(ns recursive-string-permutations.core-test
  (:require [clojure.test :refer :all]
            [recursive-string-permutations.core :refer :all]))

(def permutations-a
  #{"a"})

(def permutations-b
  #{"ab" "ba"})

(def permutations-c
  #{"abc" "acb"
    "bac" "bca"
    "cab" "cba"})

(def permutations-d
  #{"abcd" "abdc" "acbd" "acdb" "adbc" "adcb"
    "badc" "bacd" "bcda" "bcad" "bdca" "bdac"
    "cabd" "cadb" "cbad" "cbda" "cdab" "cdba"
    "dacb" "dabc" "dbca" "dbac" "dcba" "dcab"})

(deftest permutations-test
  (testing "should return a set of all permutations of an input string"
    (is (= (permutations "") #{""}))
    (is (= (permutations "a") permutations-a))
    (is (= (permutations "ab") permutations-b))
    (is (= (permutations "abc") permutations-c))
    (is (= (permutations "abcd") permutations-d))))
