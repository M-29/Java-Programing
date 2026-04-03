class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int missingNumbers = 0;
        while(i < nums.length){
            int index = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }else{
                i++;
            }
        }
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index){
                return index;
            }
        }
        return nums.length;
    }
}
