(ns largestvalue)

(defn comp-< 
  ;; Compare two numbers and return True/False as comparison.                                     
  [a b]                                
  (let [x (Integer/parseInt (str a b)) 
        y (Integer/parseInt (str b a))]
    (cond 
      (> x y) true   
      (= x y) (> a b)                                           
      :else false))) 

(defn create-largest-num    
  ;; It takes a list and returns possible biggest number. e.g.
  ;; [1 34 3 98 9 76 45 4] => 998764543431                           
  [x]
  (let [s (sort comp-< x)
        p (reduce #(str %1 %2) "" s)]
    (println p)))

(create-largest-num [54 546 548 60])
