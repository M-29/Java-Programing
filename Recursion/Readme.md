# Recursion
Function call itself to solve smaller version of problem is called recursion.
#### Base condition
* The condition where recursion will stop making new calls.<br>
* Recursion store every call in stack data structure.<br>
* Every call of function is taking some memory and store in stack.<br>
#### Tail Recursion
The tail recursion is the recursive function where the function calls itself at the end of the function in which no computation is done after the return of the recursive call.<br>
**Eg.**
  static void print(int n)
  {
      if (n < 0)
          return;
      System.out.print(" " + n);
      // The last executed statement
      // is recursive call
      print(n - 1);
  }
