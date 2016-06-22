(ns compute-nth-fibbonacci-number.core
  (:gen-class))

(defn fib-seq
  ([]
    (fib-seq 0 1))
  ([a b]
    (cons a (lazy-seq (fib-seq b (+ a b))))))

(defn fib
  "O(n) time solution - lazy and bottom up"
  [n]
  (last (take (inc n) (fib-seq))))
