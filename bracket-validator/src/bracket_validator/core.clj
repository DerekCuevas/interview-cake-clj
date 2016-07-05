(ns bracket-validator.core
  (:gen-class))

(def ^:private openers #{\( \{ \[})
(def ^:private closers #{\) \} \]})
(def ^:private closer->opener {\) \( \} \{ \] \[})

(defn- update-stack [stack char]
  (cond
    (contains? openers char)
      (conj stack char)
    (contains? closers char)
      (if (= (peek stack) (closer->opener char))
        (pop stack)
        (reduced nil))
    :else
      stack))

(defn valid-brackets?
  "O(n) time & O(k) space solution, where k = number of brackets - using a stack."
  [s]
  (let [remaining-stack (reduce update-stack [] s)]
    (and (some? remaining-stack)
         (empty? remaining-stack))))
