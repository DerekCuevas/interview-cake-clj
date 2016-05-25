(ns apple-stocks.core
  (:gen-class))

(defn- update-min-max [{:keys [min-price max-profit]} price]
  {:min-price (min price min-price)
   :max-profit (max (- price min-price) max-profit)})

(defn get-max-profit
  "O(n) time solution - returns max potential profit from set of stock prices."
  [stock-prices]
  ((reduce update-min-max
           {:max-profit 0 :min-price (first stock-prices)}
           (rest stock-prices)) :max-profit))
