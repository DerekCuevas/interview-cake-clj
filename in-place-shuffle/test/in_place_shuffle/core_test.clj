(ns in-place-shuffle.core-test
  (:require [clojure.test :refer :all]
            [in-place-shuffle.core :refer :all]))

(def vector-a [1 2])
(def vector-b [1 2 3])
(def vector-c [6 7 2 9 8 1 3])
(def vector-d [23 88 6 54 23 40 91 66 78 20 12 102])

(deftest a-test
  (testing "FIXME, I fail."
    (is (= (count (fisher-yates-shuffle vector-a)) (count vector-a)))
    (is (= (sort (fisher-yates-shuffle vector-a)) (sort vector-a)))

    (is (= (count (fisher-yates-shuffle vector-b)) (count vector-b)))
    (is (= (sort (fisher-yates-shuffle vector-b)) (sort vector-b)))

    (is (= (count (fisher-yates-shuffle vector-c)) (count vector-c)))
    (is (= (sort (fisher-yates-shuffle vector-c)) (sort vector-c)))

    (is (= (count (fisher-yates-shuffle vector-d)) (count vector-d)))
    (is (= (sort (fisher-yates-shuffle vector-d)) (sort vector-d)))))
