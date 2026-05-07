# Bubble Sort
In this sorting algorithm we are repeatedly comparing adjacent elements and swapping them if they are in the wrong order.
## How it works
1. Start from the first element.
2. Compare it with the next element.
3. Swap if the first is greater than the second.
4. Move one step forward and repeat.
5. After each pass, the largest element “bubbles up” to its correct position.
6. Repeat until the list is sorted.

# Selection Sort
In this sorting algorithm we are repeatedly selects the largest element from the unsorted part and puts it at the end position.
## How it works
1. Start from index 0
2. Find the maximum element in the remaining array
3. Swap it with the current index
4. Move to next index
5. Repeat until sorted

# Insertion Sort
Insertion Sort works like sorting playing cards in your hand 🃏 You pick one element and insert it into its correct position in the sorted part of the array.
## How it works
1. Assume the first element is already sorted
2. Take the next element
3. Compare it with previous elements
4. Shift larger elements to the right
5. Insert the element at the correct position
6. Repeat for all elements
#### Key Points
  - Efficient for small or nearly sorted arrays
  - Stable sorting algorithm
# Cyclic Sort
Cyclic Sort is a special sorting algorithm used when:
- Array contains numbers in a given range
- Typically from 1 to n (or 0 to n)
- No duplicates (in basic version)

### 🔹 Idea
Place each element at its correct index.
👉 For numbers 1 to n, correct index = value - 1

### 🔹 How it works
1. Start from index 0
2. Check if the current element is at correct position
3. If not → swap it with the correct index
4. If yes → move to next index
5. Repeat until array is sorted

# Quick Sort
This is actually a Hoare partition style Quick Sort, and your code is almost perfect. Place all elements smaller than pivot on left side and larger on right side.
Array:

[5, 3, 2, 4, 1, 19, 28]
 pivot = 4
Iteration 1:
s=0 → 5 (wrong, should be right side)
e=6 → 28 (correct, move left)
e=5 → 19 (correct, move left)
e=4 → 1 (wrong)

👉 Swap (5,1)

[1, 3, 2, 4, 5, 19, 28]
Iteration 2:
s=1 → 3 (correct, move)
s=2 → 2 (correct, move)
s=3 → 4 (stop)
e=3 → 4 (stop)

👉 Swap (4,4) (self swap)

Now:

s=4, e=2 → STOP (s > e)
🔄 Recursive Calls
quickSort(arr, s, high); // right side
quickSort(arr, low, e);  // left side

👉 Now array is divided into:

Left: smaller elements
Right: larger elements
