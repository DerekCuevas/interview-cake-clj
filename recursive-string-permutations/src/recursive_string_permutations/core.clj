(ns recursive-string-permutations.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn- cat-join [char]
  (fn [coll]
    (str/join (concat coll (str char)))))

(defn- other-chars [s idx]
  (str/join (concat (subs s 0 idx)
                    (subs s (inc idx) (count s)))))

(defn permutations [s]
  (if (= (count s) 1)
    #{s}
    (reduce-kv (fn [permutations-so-far idx char]
                 (into permutations-so-far
                       (map (cat-join char)
                            (permutations (other-chars s idx)))))
               #{}
               (vec s))))
