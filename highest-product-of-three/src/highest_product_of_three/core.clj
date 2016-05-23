(ns highest-product-of-three.core
  (:gen-class))

;; assumptions made:
;; - colls are unique
;; - count of coll is always greater than k

(defn- select-k
  "Selects k items from a collection where (select selected) is not nil
  and (replace? n) is true. Will select blindly if k is greater than
  the length of selected."
  [k coll replace? select]
  (reduce (fn [selected n]
            (let [to-replace (select selected)]
              (cond
                (< (count selected) k)
                  (conj selected n)
                (and (some? to-replace) (replace? n to-replace))
                  (conj (disj selected to-replace) n)
                :else
                  selected)))
          #{}
          coll))

(defn- select-k-maxs [k coll]
  (select-k k coll > #(when (not-empty %) (apply min %))))

(defn- select-k-mins [k coll]
  (select-k k coll < #(when (not-empty %) (apply max %))))

(defn- highest-product-of-k-positive-ints [k nums]
  (apply * (select-k-maxs k nums)))

(defn highest-product-of-three-positive-ints
  "O(n) solution - without negative numbers"
  [nums]
  (highest-product-of-k-positive-ints 3 nums))

(defn highest-product-of-three
  "O(n) solution - with negative numbers"
  [nums]
  (let [min-negatives (filter neg? (select-k-mins 2 nums))
        maxs (select-k-maxs 3 nums)
        product-of-maxs (apply * maxs)]
    (if (= (count min-negatives) 2)
      (max product-of-maxs
           (* (reduce max maxs) (apply * min-negatives)))
      product-of-maxs)))

;; TODO: implement this
#_((defn highest-product-of-k [k nums]
  (let [negative-mins (filter neg? (select-k-mins k nums))
        maxs (filter pos? (select-k-maxs k nums))]
    (if (even? k)
      (max (apply * mins) (apply * maxs))))))
