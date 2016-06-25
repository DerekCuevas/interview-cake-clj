(ns highest-product-of-three.core
  (:gen-class))

(defn- rotation
  "Rotates bucket of k length around the bottom and top of arr by idx."
  [arr k idx]
  (let [top (- (count arr) (- k idx))]
    (vec (concat (subvec arr 0 idx)
                 (subvec arr top)))))

(defn highest-product-of-k
  "O(nlgn) time + O(n + (k + k^2)) space solution."
  [k arr]
  (if (>= k (count arr))
    (reduce * arr)
    (->> (range (inc k))
         (map (partial rotation (vec (sort arr)) k))
         (map (partial reduce *))
         (apply max))))
