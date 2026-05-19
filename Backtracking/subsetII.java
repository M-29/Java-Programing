class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), nums, start);
        return res;
    }
    void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start){
        // if(res.contains(temp))   //First way to do 
        //     return;
        res.add(new ArrayList<>(temp));
        for(int i = start; i< nums.length; i++){
             if (i > start && nums[i] == nums[i - 1]) { // optimise way to do
                continue;
            }
            temp.add(nums[i]);
            backTrack(res, temp, nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
