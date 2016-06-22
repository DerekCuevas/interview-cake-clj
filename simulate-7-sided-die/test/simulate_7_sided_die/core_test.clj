(ns simulate-7-sided-die.core-test
  (:require [clojure.test :refer :all]
            [simulate-7-sided-die.core :refer :all]))

(def ^:const min-value 1)
(def ^:const max-value 7)
(def ^:const sample_size 10000)

(def ^:const expected_frequency (* sample_size (/ min-value max-value)))
(def ^:const limit_frequency (* sample_size (/ (inc min-value) max-value)))
(def ^:const margin_of_error (/ (- limit_frequency expected_frequency) 8))

(defn within-margin-of-error? [freq]
  (<= (- expected_frequency margin_of_error)
      freq
      (+ expected_frequency margin_of_error)))

(defn within-range? [value]
  (<= min-value value max-value))

(deftest rand7-test
  (let [sample (take sample_size (repeatedly rand7))
        sample-frequencies (frequencies sample)]
    (testing "probablity distribution"
      (is (= max-value (count (keys sample-frequencies))))
      (is (every? within-margin-of-error? (vals sample-frequencies))))
    (testing "range check"
      (is (every? within-range? (keys sample-frequencies))))))
