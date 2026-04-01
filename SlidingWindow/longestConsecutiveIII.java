class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroFlipped = 0;
        int start = 0;
        int maxEle = 0;
        for(int end = 0; end < nums.length; end++){
            if(nums[end] == 0){
                zeroFlipped++;
            }
            while(zeroFlipped > k){
                if(nums[start] == 0){
                    zeroFlipped--;
                }
                start++;
            }
            maxEle = Math.max(maxEle,end-start+1);
        }
        return maxEle;
    }
}
