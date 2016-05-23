(ns highest-product-of-three.core
  (:gen-class))

(defn- select-k [k coll compf]
  (reduce (fn [selected n]
            (let [min-selected (and (not-empty selected) (apply min selected))]
              (cond
                (< (count selected) k)
                  (conj selected n)
                (compf n min-selected)
                  (conj (disj selected min-selected) n)
                :else
                  selected)))
          #{}
          coll))

(defn highest-product-of-k-positive-ints [k nums]
  (apply * (select-k k nums >)))

(defn highest-product-of-three-positive-ints
  "O(n) solution - without negative numbers"
  [nums]
  (highest-product-of-k-positive-ints 3 nums))

;; maxs < k
;; mins < k => if count of min < k - 1 is even? comp product of maxs to product of mins - 1 and largest max
;; TODO: implement this
(defn highest-product-of-k [k nums]
  (let [mins (select-k k nums <)
        maxs (select-k k nums >)]))

(defn highest-product-of-three
  "O(n) solution - with negative numbers"
  [nums]
  (highest-product-of-k 3 nums))
