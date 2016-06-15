(ns inflight-entertainment.core
  (:gen-class))

(defn can-two-movies-fill-flight?
  "O(n) time solution - using a set."
  [movie-lengths flight-length]
  (true? (reduce
           (fn [seen-lengths movie-length]
             (if (contains? seen-lengths (- flight-length movie-length))
               (reduced true)
               (conj seen-lengths movie-length)))
           #{}
           movie-lengths)))
