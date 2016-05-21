(ns apple-stocks.core
  (:gen-class))

;; FIXME: is there a built in equivalent to this?
(def ^:private infinity 1000000000)

(defn- update-min-max [{:keys [min-price max-profit]} price]
  {:min-price (min price min-price)
   :max-profit (max (- price min-price) max-profit)})

(defn get-max-profit [stock-prices]
  (:max-profit (reduce update-min-max
                       {:max-profit 0 :min-price infinity}
                       stock-prices)))
