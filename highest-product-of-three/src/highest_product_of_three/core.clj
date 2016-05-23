(ns highest-product-of-three.core
  (:gen-class))

;; TODO: doc this
(defn- select-k [k coll select-fn replace-fn]
  (reduce (fn [selected-k n]
            (let [selected (and (not-empty selected-k) (apply replace-fn selected-k))]
              (cond
                (< (count selected-k) k) (conj selected-k n)
                (select-fn n selected) (conj (disj selected-k selected) n)
                :else selected-k)))
          #{}
          coll))

(defn- select-k-maxs [k coll]
  (select-k k coll > min))

(defn- select-k-mins [k coll]
  (select-k k coll < max))

(defn- highest-product-of-k-positive-ints [k nums]
  (apply * (select-k-maxs k nums)))

(defn highest-product-of-three-positive-ints
  "O(n) solution - without negative numbers"
  [nums]
  (highest-product-of-k-positive-ints 3 nums))

;; maxs < k
;; mins < k => if count of min < k - 1 is even?
;;             comp product of maxs to product of mins - 1 and largest max
;; TODO: implement this
(defn highest-product-of-k [k nums]
  (let [mins (select-k-mins k nums)
        maxs (select-k-maxs k nums)]))

(defn highest-product-of-three
  "O(n) solution - with negative numbers"
  [nums]
  (highest-product-of-k 3 nums))
