(ns apple-stocks.core
  (:gen-class))

(defn update-min-max [{:keys [min-price max-profit]} price]
  {:min-price (min price min-price)
   :max-profit (max (- price min-price) max-profit)})

(defn get-max-profit [stock-prices]
  (reduce update-min-max {:max-profit 0 :min-price 1000000} stock-prices))
