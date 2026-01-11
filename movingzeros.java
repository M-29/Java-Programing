// My solution taking O(n^2) time complexity
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = nums.length;
        if(nums.length>1){
            while(j != i){
                if(nums[i] == 0){
                    int temp = nums[i];
                    for(int k = i; k<j-1;k++){
                        nums[k] = nums[k+1];
                    }
                    nums[j-1] = temp;
                    j--;
                }else{
                    i++;
                }
            }
        }    
    }
}
//Optimize solution taking o(n) time complexity
class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[count++] = nums[i];
            }
        }
        while(count < nums.length){
            nums[count++] = 0;
        }
    }
}
