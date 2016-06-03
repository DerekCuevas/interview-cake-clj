(ns reverse-words.core-test
  (:require [clojure.test :refer :all]
            [reverse-words.core :refer :all]))

(def message-a "world hello")
(def message-b "you meet to nice")
(def message-c "find you will pain only go you recordings security the into if")

(def edge-a "")
(def edge-b "hello")

(deftest reverse-words-test
  (testing "edge cases"
    (is (= (reverse-words edge-a) ""))
    (is (= (reverse-words edge-b) "hello")))
  (testing "should reverse the words in string"
    (is (= (reverse-words message-a) "hello world"))
    (is (= (reverse-words message-b) "nice to meet you"))
    (is (= (reverse-words message-c) "if into the security recordings you go only pain will you find"))))
