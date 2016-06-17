(ns reverse-string-in-place.core-test
  (:require [clojure.test :refer :all]
            [reverse-string-in-place.core :refer :all]))

(deftest reverse-string-test
  (testing "edge cases"
    (is (= (reverse-string "") ""))
    (is (= (reverse-string "a") "a"))
    (is (= (reverse-string "ab") "ba")))
  (testing "returns string reversed"
    (is (= (reverse-string "abc") "cba"))
    (is (= (reverse-string "hello") "olleh"))
    (is (= (reverse-string "Hello World!") "!dlroW olleH"))
    (is (= (reverse-string "eeeffffggg") "gggffffeee"))))
