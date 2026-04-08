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
