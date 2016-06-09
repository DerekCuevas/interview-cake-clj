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
        (reduced :invalid))
    :else
      stack))

(defn valid-brackets?
  "O(n + k) time solution, where k = number of brackets - using a stack."
  [s]
  (let [stack (reduce update-stack [] s)]
    (if (= stack :invalid)
      false
      (empty? stack))))
