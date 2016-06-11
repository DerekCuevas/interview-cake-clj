(ns simulate-5-sided-die.core-test
  (:require [clojure.test :refer :all]
            [simulate-5-sided-die.core :refer :all]))

(def ^:private MIN 1)
(def ^:private MAX 5)

(def ^:private SAMPLE_SIZE 10000)
(def ^:private EXPECTED_DISTRIBUTION (/ SAMPLE_SIZE MAX))
(def ^:private MARGIN_OF_ERROR 100)

(defn- rand5-seq [n]
  (reduce
    (fn [rs _] (conj rs (rand5)))
    []
    (range n)))

(defn- within-margin-of-error? [freq]
  (and (>= freq (- EXPECTED_DISTRIBUTION MARGIN_OF_ERROR))
       (<= freq (+ EXPECTED_DISTRIBUTION MARGIN_OF_ERROR))))

(defn- within-range? [value]
  (and (>= value MIN) (<= value MAX)))

(deftest rand5-test
  (testing "probablity distribution"
    (is (every? within-margin-of-error?
                (vals (frequencies (rand5-seq SAMPLE_SIZE))))))
  (testing "range check"
    (is (every? within-range?
                (rand5-seq SAMPLE_SIZE)))))
