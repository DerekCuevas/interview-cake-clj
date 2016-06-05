(ns permutation-palindrome.core-test
  (:require [clojure.test :refer :all]
            [clojure.string :as str]
            [permutation-palindrome.core :refer :all]))

(def str-a "civic")
(def str-b "ivicc")
(def str-c "civil")
(def str-d "livci")

(def str-e (str/join (shuffle (vec "racecar"))))
(def str-f (str/join (shuffle (vec "civic"))))
(def str-g (str/join (shuffle (vec "abcba"))))
(def str-h (str/join (shuffle (vec "palindrome"))))

(def edge-a "")
(def edge-b "a")
(def edge-c "ab")
(def edge-d "aba")
(def edge-e "abc")

(deftest permutation-palindrome?-test
  (testing "edge cases"
    (is (= (permutation-palindrome? edge-a) true))
    (is (= (permutation-palindrome? edge-b) true))
    (is (= (permutation-palindrome? edge-c) false))
    (is (= (permutation-palindrome? edge-d) true))
    (is (= (permutation-palindrome? edge-e) false)))
  (testing "Returns true if any permutaion of a string is a palindrome."
    (is (= (permutation-palindrome? str-a) true))
    (is (= (permutation-palindrome? str-b) true))
    (is (= (permutation-palindrome? str-c) false))
    (is (= (permutation-palindrome? str-d) false))
    (is (= (permutation-palindrome? str-e) true))
    (is (= (permutation-palindrome? str-f) true))
    (is (= (permutation-palindrome? str-g) true))
    (is (= (permutation-palindrome? str-h) false))))
