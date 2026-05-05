# Recursion
Function call itself to solve smaller version of problem is called recursion.
#### Base condition
* The condition where recursion will stop making new calls.<br>
* Recursion store every call in stack data structure.<br>
* Every call of function is taking some memory and store in stack.<br>
#### Tail Recursion
The tail recursion is the recursive function where the function calls itself at the end of the function in which no computation is done after the return of the recursive call.<br>
**Eg.**
```Java
  static void print(int n)
  {
      if (n < 0)
          return;
      System.out.print(" " + n);
      // The last executed statement
      // is recursive call
      print(n - 1);
  }
```
##### How to solve a problem using recursion
- Identify if you breakdown problem into smaller problems
- Write the recurrence relation if needed
- Draw the recursive tree
- About the tree
    - See the flow of function how they are gettin into the stack
    - Identify the flow of left tree calls and right tree calls
- See how values are returned at each step
- See where the function call will come out

### Recurrence relation
It is way to define a sequence where each term depends on one or more previous terms.
##### Types of recurrence relation
  - Linear Recurrence Relation eg: Fibonnaci number F(n) = F(n-1) + F(n-2)
  - Divide And Conquer Recurrence Relation eg: Binary Search F(n) = O(1) + F(n/2)
##### Points to remember
  - If you want to pass the variable in future function calls then put it in arguments
  - If you want don't want to pass the variable in future function calls and it is only used in that function then put it inside the body of the function
