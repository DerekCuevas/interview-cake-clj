(ns recursive-string-permutations.core-test
  (:require [clojure.test :refer :all]
            [recursive-string-permutations.core :refer :all]))

(def str-a "a")
(def permutations-a #{"a"})

(def str-b "ab")
(def permutations-b #{"ab" "ba"})

(def str-c "abc")
(def permutations-c #{"abc" "acb"
                      "bac" "bca"
                      "cab" "cba"})

(def str-d "abcd")
(def permutations-d #{"abcd" "abdc" "acbd" "acdb" "adbc" "adcb"
                      "badc" "bacd" "bcda" "bcad" "bdca" "bdac"
                      "cabd" "cadb" "cbad" "cbda" "cdab" "cdba"
                      "dacb" "dabc" "dbca" "dbac" "dcba" "dcab"})

(deftest permutations-test
  (testing "should return a set of all permutations of an input string"
    (is (= (permutations str-a) permutations-a))
    (is (= (permutations str-b) permutations-b))
    (is (= (permutations str-c) permutations-c))
    (is (= (permutations str-d) permutations-d))))
