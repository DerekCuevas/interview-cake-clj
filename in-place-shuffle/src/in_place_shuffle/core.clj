(ns in-place-shuffle.core
  (:gen-class))

(defn random [floor ceiling]
  (+ (int (* (rand) (inc (- ceiling floor)))) floor))

(defn fisher-yates-shuffle
  "O(n) time solution - can't do this in-place ~ but can use similar algorithm."
  [arr]
  (loop [idx 0
         shuffled arr]
    (if (= idx (count arr))
      shuffled
      (let [rand-idx (random idx (dec (count arr)))]
        (recur (inc idx)
               (-> shuffled
                   (assoc rand-idx (shuffled idx))
                   (assoc idx (shuffled rand-idx))))))))
