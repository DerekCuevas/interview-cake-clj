(ns single-riffle-shuffle.core
  (:gen-class))

(defn single-riffle-shuffle?
  "O(n) time solution - assuming counts of half-a + half-b = count of shuffled."
  [shuffled half-a half-b]
  (loop [idx-a 0
         idx-b 0
         idx-shuffled 0]
    (cond
      (= idx-shuffled (count shuffled))
        true
      (= (get half-a idx-a) (get shuffled idx-shuffled))
        (recur (inc idx-a) idx-b (inc idx-shuffled))
      (= (get half-b idx-b) (get shuffled idx-shuffled))
        (recur idx-a (inc idx-b) (inc idx-shuffled))
      :else
        false)))
