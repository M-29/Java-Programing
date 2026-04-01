class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int max = 0;
        int zeroLeft = 0;
        for(int end = 0; end < nums.length; end++){
            if(nums[end] == 0){
                zeroLeft++;
            }
            while(zeroLeft > 1){
                if(nums[start] == 0){
                    zeroLeft--;
                }
                start++;
            }
            max = Math.max(max,end-start);
        }
        return max;
    }
}
