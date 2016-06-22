(ns simulate-5-sided-die.core-test
  (:require [clojure.test :refer :all]
            [simulate-5-sided-die.core :refer :all]))

(def ^:const min-value 1)
(def ^:const max-value 5)
(def ^:const sample-size 10000)

(def ^:const expected-frequency (* sample-size (/ min-value max-value)))
(def ^:const limit_frequency (* sample-size (/ (inc min-value) max-value)))
(def ^:const margin_of_error (/ (- limit_frequency expected-frequency) 16))

(defn within-margin-of-error? [freq]
  (<= (- expected-frequency margin_of_error)
      freq
      (+ expected-frequency margin_of_error)))

(defn within-range? [value]
  (<= min-value value max-value))

(deftest rand5-test
  (let [sample (take sample-size (repeatedly rand5))
        sample-frequencies (frequencies sample)]
    (testing "probablity distribution"
      (is (= max-value (count (keys sample-frequencies))))
      (is (every? within-margin-of-error? (vals sample-frequencies))))
    (testing "range check"
      (is (every? within-range? (keys sample-frequencies))))))
