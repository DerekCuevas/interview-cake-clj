(ns word-cloud.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn- normalize [s]
  (map #(str/lower-case (str/replace % #"(?i)[^\w']+" ""))
       (str/split s #" ")))

(defn word-cloud
  "O(n) time & space solution - manually counting frequencies."
  [s]
  (reduce
    (fn [counts word]
      (if (contains? counts word)
        (assoc counts word (inc (counts word)))
        (assoc counts word 1)))
    {}
    (normalize s)))

(defn word-cloud-with-freq
  "O(n) time & space solution - using built-in frequencies function."
  [s]
  (frequencies (normalize s)))
