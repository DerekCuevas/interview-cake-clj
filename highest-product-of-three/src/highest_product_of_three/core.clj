(ns highest-product-of-three.core
  (:gen-class))

(defn- largest-k [k]
  (fn [largest n]
    (let [min-largest (and (not-empty largest) (apply min largest))]
      (cond
        (< (count largest) k) (conj largest n)
        (> n min-largest) (conj (disj largest min-largest) n)
        :else largest))))

(defn highest-product-of-k-positive-ints [k nums]
  (apply * (reduce (largest-k k) #{} nums)))

(defn highest-product-of-three-positive-ints
  "O(n) solution - without negative numbers"
  [nums]
  (highest-product-of-k-positive-ints 3 nums))

;; maxs < k
;; mins < k => if count of min < k - 1 is even? comp product of maxs to product of mins - 1 and largest max
(defn highest-product-of-k [k nums]
  nil)

(defn highest-product-of-three
  "O(n) solution - with negative numbers"
  [nums]
  (highest-product-of-k 3 nums))
