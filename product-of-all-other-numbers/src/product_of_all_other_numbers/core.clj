(ns product-of-all-other-numbers.core
  (:gen-class))

;; O(n^2) solutions
(defn product-of-others [nums]
  (map #(/ (reduce * nums) %) nums))
