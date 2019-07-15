# Problems and Solutions.
Some problems and solutions which I solve just for fun.

## solution100.clj
  Write a program that outputs all possibilities to put + or - or nothing between the numbers 1,2,…,9 (in this order) such that the result is 100. For example *1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100.*
  
  ### Running
  Execute using `clj solution100.clj`.
  
  #### Output: 
 * (+ 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9)                                                                                                                                                                                                    
 * (+ 1 + 2 + 34 - 5 + 67 - 8 + 9)
 * (+ 1 + 23 - 4 + 5 + 6 + 78 - 9)
 * (+ 1 + 23 - 4 + 56 + 7 + 8 + 9)
 * (+ 12 + 3 + 4 + 5 - 6 - 7 + 89)
 * (+ 12 + 3 - 4 + 5 + 67 + 8 + 9)
 * (+ 12 - 3 - 4 + 5 - 6 + 7 + 89)
 * (+ 123 + 4 - 5 + 67 - 89)
 * (+ 123 + 45 - 67 + 8 - 9)
 * (+ 123 - 4 - 5 - 6 - 7 + 8 - 9)
 * (+ 123 - 45 - 67 + 89)
 * (- 1 + 2 - 3 + 4 + 5 + 6 + 78 + 9)
