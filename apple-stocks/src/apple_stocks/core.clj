(ns apple-stocks.core
  (:gen-class))

(defn get-max-profit [stock-prices]
  (reduce (fn [{:keys [min-price max-profit]} price]
            {:min-price (min min-price price)
             :max-profit (max max-profit (- price min-price))})
          {:min-price 1000000 :max-profit 0}
          stock-prices))
