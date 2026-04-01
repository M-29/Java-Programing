class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currMax = 0;
        double max = 0;
        for(int j =0; j < k; j++){
            currMax = currMax  + nums[j];
        }
        max = currMax/k;
        for(int i = 1; i <= nums.length - k; i++){
            currMax = currMax - nums[i-1] + nums[i+k-1];
            if(currMax/k > max){
                max = currMax/k;
            }
        }
        return max;
    }
}
