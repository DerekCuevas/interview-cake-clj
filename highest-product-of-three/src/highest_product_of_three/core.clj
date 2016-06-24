(ns highest-product-of-three.core
  (:gen-class))

(def ^:private sortv (comp vec sort))

(defn- rotation [arr k idx]
  (let [top (- (count arr) (- k idx))
        bottom idx]
    (vec (concat (subvec arr 0 bottom)
                 (subvec arr top)))))

(defn highest-product-of-k
  "O(nlgn) time + O(n + k) space solution."
  [arr k]
  (->> (map (partial rotation (sortv arr) k) (range (inc k)))
       (map (partial reduce *))
       (apply max)))
