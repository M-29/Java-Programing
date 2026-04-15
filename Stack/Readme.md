# Implement Queue using stack
In this the remove operation is the main part for that we have to take two stack and perform the pop operation

# Largest Rectangle in Histogram
In this question :- 
1. First find the Left nearest element
2. Second find the right nearest element
3. Then calculate the area for each width and find the maximum one

# Decode String 
We use two stacks:
🔹 1. countStack → stores numbers (k)
🔹 2. stringStack → stores previous strings
✅ Algorithm Flow

For each character:

🔸 If digit → build number
🔸 If [ → push current string + number
🔸 If ] → pop and build result
🔸 Else → append character
