(ns word-cloud.core-test
  (:require [clojure.test :refer :all]
            [word-cloud.core :refer :all]))

(def sentence-a "After beating the eggs, Dana read the next step:")
(def sentence-b "Add milk and eggs, then add flour and sugar.")
(def sentence-c "Hi how are you?")
(def sentence-d "What when where why when why what? Where when. I don't know.")
(def sentence-e "Hello bye hi hi hello hi bye hi bye.")

(def map-a {"after" 1 "beating" 1 "the" 2 "eggs" 1 "dana" 1 "read" 1 "next" 1 "step" 1})
(def map-b {"add" 2 "milk" 1 "and" 2 "eggs" 1 "then" 1 "flour" 1 "sugar" 1})
(def map-c {"hi" 1 "how" 1 "are" 1 "you" 1})
(def map-d {"what" 2 "when" 3 "where" 2 "why" 2 "i" 1 "don't" 1 "know" 1})
(def map-e {"hello" 2 "bye" 3 "hi" 4})

(deftest word-cloud-test
  (testing "edge cases"
    (is (= (word-cloud "hi") {"hi" 1}))
    (is (= (word-cloud "hi HI Hi hI hi. hi? hi!") {"hi" 7})))
  (testing "returns frequencies of words in sentence, ignores case and punctuation."
    (is (= (word-cloud sentence-a) map-a))
    (is (= (word-cloud sentence-b) map-b))
    (is (= (word-cloud sentence-c) map-c))
    (is (= (word-cloud sentence-d) map-d))
    (is (= (word-cloud sentence-e) map-e))))
