(ns find-rotation-point.core
  (:gen-class))

(defn find-rotation-point
  "O(n) time solution."
  [words]
  (loop [idx 1]
    (if (pos? (compare (words (dec idx)) (words idx)))
      idx
      (recur (inc idx)))))

(defn find-rotation-point-fast [words]
  -1)
