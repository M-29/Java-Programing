class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else{
                i++;
            }
        }
        List<Integer> arr = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index+1 ){
                arr.add(index+1);
            }
        }
        return arr;
    }
}
