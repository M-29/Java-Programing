# Delete Middle Node Of Linked List
  ## First Approach 
  Find the size of linked list and then find the mid by finding the half of linked list move the pointer  till one  node before the middle node and then change the next of node. 
  ## Second Approach
  Using Fast and Slow Pointer in which slow pointer move one step where as fast ponter moves 2 steps in one time.
  
# Merge two sorted list
## 🧠 Step 1: Dummy Node Creation
ListNode dummyNode = new ListNode();
ListNode tail = dummyNode;
👉 This creates a temporary node
dummyNode → null
   ↑
 tail
dummyNode = starting point (helper)
tail = used to build the new list
## 🧠 Why dummy node?
👉 So we don’t worry about:
first node
empty list
special cases
📦 Example
list1 = 1 → 3 → 5
list2 = 2 → 4 → 6
🔁 Step 2: Loop starts
while(list1 != null && list2 != null)
We compare values and attach smaller one.
👉 Iteration 1
1 < 2 → pick 1
tail.next = list1;
list1 = list1.next;
tail = tail.next;
👉 Now:
dummy → 1 → null
          ↑
         tail
👉 Iteration 2
3 vs 2 → pick 2
👉 Now:
dummy → 1 → 2 → null
               ↑
              tail
👉 Iteration 3
3 < 4 → pick 3
dummy → 1 → 2 → 3
                    ↑
                   tail
👉 Continue...
Final:
dummy → 1 → 2 → 3 → 4 → 5 → 6
## 🧠 Step 3: Attach remaining
tail.next = (list1 != null) ? list1 : list2;
👉 If one list still has elements → attach directly
## 🧠 Step 4: Return result
return dummyNode.next;
👉 IMPORTANT:
dummy → 1 → 2 → 3 → 4 → 5 → 6
          ↑
       return this
👉 We skip dummy node because:
it was just helper

# Linked List Cycle
In this question we are using fast and slow pointer concept. In which fast pointer moves two steps and slow pointer moves only one step. And if fast and slow pointer meet at same position then it is a cyclic list else it is not cyclic. 
# Length of a cycle 
In this question we are using fast and slow pointer concept. And if fast and slow pointer meet at same position then it is a cyclic list else it is not cyclic. Then take the temp node starting from slow and move till again it euals to slow and increment the loop by 1 for this I have used do-while loop because it will move once.

# Find the node from where cycle starts
## Aproach 1 :
1. Find the length of the cycle
2. Move the second pointer till the length of the cycle.
3. Move the first and second pointer till first and second will be equal.

## Aproach 2 :
1. Find the cycle whether the list is cyclic or not using fast and slow pointer.
2. Take the third pointer temp start from head and move till temp ans slow is not pointing to the same pointer
3. And return slow because if they meet then that node is a starting node of the cycle.

# Happy Number
## Aproach 1
In approach 1 we are using SET. For every sum value we are checking whether sum is in present in set if sum present then returning false and if sum == 1 returning true.
## Aproach 2
In this approach we are using fast and slow pointer concept.

# Find elements after middle
In this approach we are using fast and slow pointer concept.

# Sort Linked List
In this approach we will sort the list using merge sort.

# Maximum Twin Sum of a Linked List
In this question we will first find the :-
1. Middle Node
2. Reverse the second half of the linked list from middle of the list
3. Find the max twin sum 

# Reverse Sub Linked list
In this question we will first :-
1. Move till left limit
2. And secure the last element before sub array head
3. then we will reverse the list till the right limit

# Palindrome Linked List
In this question we fill first find: -
1. Middle node
2. Then we will reverse the linked list from middle element
3. Then we will compare the head value and reverse linked list head till null
4. If the values are equal and reach till null then it is a palindrome linked list
5. Else not a palindrome linked list. 

# Reorder List
In this question :-
1. Find middle element
2. reverse the half of linked list
3. Then reorder the elements
