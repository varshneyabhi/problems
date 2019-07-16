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


## largestvalue.clj
  Given an array of numbers, arrange them in a way that yields the largest value. For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
  
  ### Running
  Execute using `clj largestvalue.clj`.
  
  #### Output
  On input [54 546 548 60], output will be 6054854654.
  
  ## channels
   This implements golang like channels for c++ threads. This was implemented for my one small utility and made my communication part very easy. Some properties are:
   * Generic channels.
   * Block if queue is empty.
   * push and get to send and receive from channels.
   * Threadsafe.
   
   This implementation might have few bugs and less functionalities, but it solved my purpose :).
    
   ### Running
   `make`
      
   
