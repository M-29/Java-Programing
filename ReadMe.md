## Length Of Longest Substring
In this question we have taken a two pointer approach in which we have taken a character set and we are adding elements until we found duplicate once we found duplicate we will start removing elements from left until we are able to remove element present at right position. once it got deleted we will add element at right and calculate the max.

## Longest SubArray Of 1's After Deleting One Element
In this question we have used sliding window concept in which we are running the loop till length of the array in which we are incrementing the zeroleft pointer if zero found and running the loop if zeroleft is greater than 1 we are decremnting the zero left pointer if start pointer value is zero and increasing the start pointer and calculating the maximum lenght of subarray.

## Two Sum
In this question we have used hashmap approach in which we have taken a difference of target element with every element in the array 
**Case1** if we did not found the complement in hashmap we are storing the element at that position as key and its index as a value in the hashmap. 
**Case2** if we found the complement in hashmap we are returning the value of complement from the hashmap and index of current element.

## Pivot Index
In this question we find the sum of array and traverse loop again and chaeck by substracting every element ans left most elements sum is equal to the right most elements sum else return -1.

## Highest Altitude
In this question we will take array of size n+1 and at 0th position will store zero and traverse the loop and add every element of given array to the new array and calculate the max and return the highest altitude.

## Majority Element
In this question we will solve using Moore's algorithm in which we count the vote and increment only compare with previous element is equal to current element.

## Greatest Common Divisor
To find GCD of number we use **Euclidean Algorithm** where GCD of two numbers doesn’t change if we replace the bigger number with the remainder of both numbers.
gcd(a, b) = gcd(b, a % b)
👉 Repeat until b = 0
👉 Final answer = a

## Kids With The Greatest Number Of Candies
In this question we will find the maximum candy and then compare max candy with each candy and return the array.

## Product Of Array And Self 
In this question we will find the prefix and suffix of each array element and then multiply with each other.
