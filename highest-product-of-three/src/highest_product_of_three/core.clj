(ns highest-product-of-three.core
  (:gen-class))

(def ^:private sortv (comp vec sort))

(defn- rotation [arr k idx]
  (let [top (- (count arr) (- k idx))]
    (vec (concat (subvec arr 0 idx)
                 (subvec arr top)))))

(defn highest-product-of-k
  "O(nlgn) time + O(n + (k + k^2)) space solution."
  [arr k]
  (if (>= k (count arr))
    (reduce * arr)
    (->> (range (inc k))
         (map (partial rotation (sortv arr) k))
         (map (partial reduce *))
         (apply max))))
