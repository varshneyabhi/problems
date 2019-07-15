;;;; Write a program that outputs all possibilities to put + or - or nothing between the numbers 1,2,…,9 (in this order) 
;;;; such that the result is 100. For example 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100.
;;;; This may not be best or optimized way, but it works. :)
;;;; Next step, process each set of recursion parallelly to speed up.

(ns solution100)

(def final-val    100)  ; Expected value
(def max-iter-val 10)   ; Iteration should run from 1 to 9
(def min-iter-val 1)

(defmacro cal-infix 
  ;; Process data in infix notation.
  [x]
  `((second ~x) (first ~x) (last ~x)))

(defn print-eq 
  ;; Convert + and - symbols to String form.
  [x]
  (let [p (map (fn[a] (cond 
                        (= a +) "+"
                        (= a -) "-"
                        :else a)) x)]
    (println p)))

(defn eval-and-print 
  ;; Evalute a equation. Take first 3 arguments and process it and update equation.
  ;; Once only one element is left in list, check if it is desired value.
  ;; Equation will be in form of (0 + 1 - 23 + 4.....) => (1 + 23 + 4....) => (24 + 4.....) and so on.
  [x]
  (loop [a x]
    (if (= (count a) 1) 
      (if (= final-val (nth a 0))
        (print-eq (drop 1 x)))
      (let [p (cal-infix (take 3 a))
            q (drop 3 a)]
        (recur (cons p q))))))

(defn process-100 
  ;; Each iteration will spread into three branches e.g. 2 + 3, 2 - 3, 23, only exception is 
  ;; 0 and 1 because 01 should not create different result.
  ;; One more example:  1 + 23 + 4, 1 + 23 - 4, 1 + 234 and so on. 
  [x y]
  (if (not= y max-iter-val)
    (do
      (process-100 (conj x + y) (+ y 1))
      (process-100 (conj x - y) (+ y 1))
      (when (not= y min-iter-val)
        (let [a (drop-last x)
              b (last x)]
          (process-100 (conj (into [] a) (+ (* 10 b) y)) (+ y 1)))))
    (eval-and-print x)))

(defn find-100 
  ;; Enabler/Main function.
  []
  (process-100 [0] 1))
