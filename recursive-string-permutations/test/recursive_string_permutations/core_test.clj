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

(def long-permutations-a (permutations "abcdef"))
(def long-permutations-b (permutations "abcdefgh"))

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(deftest permutations-test
  (testing "edge cases"
    (is (= (permutations "") #{""}))
    (is (= (permutations "a") permutations-a)))
  (testing "returns set of all permutations of an input string"
    (is (= (permutations "ab") permutations-b))
    (is (= (permutations "abc") permutations-c))
    (is (= (permutations "abcd") permutations-d)))
  (testing "longer permutations"
    (is (set? long-permutations-a))
    (is (set? long-permutations-b))
    (is (= (count long-permutations-a) (factorial 6)))
    (is (= (count long-permutations-b) (factorial 8)))))
