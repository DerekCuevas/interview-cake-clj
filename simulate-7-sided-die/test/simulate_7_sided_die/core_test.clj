(ns simulate-7-sided-die.core-test
  (:require [clojure.test :refer :all]
            [simulate-7-sided-die.core :refer :all]))

(def ^:private MIN 1)
(def ^:private MAX 7)
(def ^:private SAMPLE_SIZE 10000)

(def ^:private EXPECTED_FREQUENCY (* SAMPLE_SIZE (/ MIN MAX)))
(def ^:private LIMIT_FREQUENCY (* SAMPLE_SIZE (/ (inc MIN) MAX)))
(def ^:private MARGIN_OF_ERROR (/ (- LIMIT_FREQUENCY EXPECTED_FREQUENCY) 8))

(defn- within-margin-of-error? [freq]
  (<= (- EXPECTED_FREQUENCY MARGIN_OF_ERROR)
      freq
      (+ EXPECTED_FREQUENCY MARGIN_OF_ERROR)))

(defn- within-range? [value]
  (<= MIN value MAX))

(deftest rand7-test
  (let [sample (take SAMPLE_SIZE (repeatedly rand7))
        sample-frequencies (frequencies sample)]
    (testing "probablity distribution"
      (is (= MAX (count (keys sample-frequencies))))
      (is (every? within-margin-of-error? (vals sample-frequencies))))
    (testing "range check"
      (is (every? within-range? sample)))))
