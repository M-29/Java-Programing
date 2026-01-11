class Solution {
    public int[] productExceptSelf(int[] nums) { 
        int[] res = new int[nums.length];
        int suf = 1;
        res[0] = 1;
        for(int i = 1; i < nums.length;i++){
            res[i] = res[i-1] * nums[i-1];//Finding Prefix
        }
        for(int i = nums.length -2; i>=0; i--){
            suf = suf * nums[i+1];//Finding suffix
            res[i] = res[i] * suf;
        }
        return res;
    }
}
