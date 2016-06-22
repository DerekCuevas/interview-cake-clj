(ns word-cloud.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn- normalize [s]
  (map (comp str/lower-case #(str/replace % #"(?i)[^\w']+" ""))
       (str/split s #" ")))

(defn word-cloud
  "O(n) time & space solution - manually counting frequencies w/reduce."
  [s]
  (reduce
   (fn [counts word]
     (assoc counts word (inc (get counts word 0))))
   {}
   (normalize s)))

(defn word-cloud-with-freq
  "O(n) time & space solution - using built-in frequencies function."
  [s]
  (frequencies (normalize s)))
