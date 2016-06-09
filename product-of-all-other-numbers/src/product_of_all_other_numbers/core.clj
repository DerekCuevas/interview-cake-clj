(ns product-of-all-other-numbers.core
  (:gen-class))

(defn product-of-others
  "O(n^2) solutions - using division (not checking for zeros)"
  [nums]
  (map #(/ (apply * nums) %) nums))

(defn- products-before [nums]
  (reduce
    (fn [acc n]
      (conj acc (* n (last acc))))
    [1]
    (butlast nums)))

(defn- products-after [nums]
  (rseq (products-before (rseq (vec nums)))))

(defn product-of-others-fast
  "O(n) solution - without using division"
  [nums]
  (if (empty? nums)
    '()
    (map * (products-before nums) (products-after nums))))
