(ns product-of-all-other-numbers.core
  (:gen-class))

;; O(n^2) solutions - using division
(defn product-of-others [nums]
  (map #(/ (apply * nums) %) nums))

(defn- products-before [nums]
  (reduce (fn [acc n]
            (conj acc (* n (last acc))))
          [1]
          (butlast nums)))

(defn- products-after [nums]
  (rseq (products-before (rseq (vec nums)))))

;; O(n) solution - without using division
(defn product-of-others-fast [nums]
  (if (empty? nums)
    '()
    (map * (products-before nums) (products-after nums))))
