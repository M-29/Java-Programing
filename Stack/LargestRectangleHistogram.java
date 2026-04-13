class Solution {
    public int largestRectangleArea(int[] ht) {
        int n = ht.length;
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[n];
        int[] left = new int[n];
        //Calculating right boundary
        for(int i = n-1; i >= 0; i-- ){
            while(stack.size() > 0 && ht[stack.peek()] >= ht[i] ){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        while(!stack.isEmpty()){
            stack.pop();
        }
        //Calculating left boundary
        for(int i = 0; i < n; i++ ){
            while(stack.size() > 0 && ht[stack.peek()] >= ht[i] ){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] -1;
            int currArea = ht[i] * width;
            ans = Math.max(ans, currArea);
        }
        return ans;
    }
}
