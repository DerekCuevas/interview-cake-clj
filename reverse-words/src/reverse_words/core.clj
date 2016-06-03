(ns reverse-words.core
  (:require [clojure.string :as str])
  (:gen-class))

;; This problem gets much more challenging in-place with mutable strings
(defn reverse-words
  "O(n) time solution - using built in functions"
  [s]
  (str/join #" " (reverse (str/split s #" "))))
