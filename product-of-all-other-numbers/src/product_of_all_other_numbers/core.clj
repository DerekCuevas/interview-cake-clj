(ns product-of-all-other-numbers.core
  (:gen-class))

;; O(n^2) solutions - using division
(defn product-of-others [nums]
  (map #(/ (reduce * nums) %) nums))

(defn- products-before [nums]
  (reduce (fn [acc n]
            (conj acc (* n (last acc))))
          [1]
          (butlast nums)))

;; O(5n) ~ O(n) solution - without using division
(defn product-of-others-fast [nums]
  (if (empty? nums)
    '()
    (map * (products-before nums)
           (reverse (products-before (reverse nums))))))
