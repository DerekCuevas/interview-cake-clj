(ns find-in-ordered-set.core
  (:gen-class))

(defn binary-search
  "O(lgn) - returns index of item in vector (arr), -1 if not found."
  ([arr item]
    (binary-search arr item 0))
  ([arr item base-idx]
    (let [mid (int (/ (count arr) 2))]
      (cond
        (empty? arr) -1
        (= (count arr) 1) (if (= (arr 0) item) 0 -1)
        (= (arr mid) item) (+ base-idx mid)
        (> (arr mid) item) (recur (subvec arr 0 mid) item base-idx)
        (< (arr mid) item) (recur (subvec arr mid) item (+ base-idx mid))))))
