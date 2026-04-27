## Time Needed to Buy Tickets

# Approach 1 using queue
Each person wants tickets[i] tickets
Queue behavior:
  Person at front buys 1 ticket
  If still needs more → goes to back
  Else → leaves queue
You need total time until person at index k finishes

# Approach 2 by compairing the min of element at ith value and the element at kth value 
