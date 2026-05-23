class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), nums);
        return res;
    }
    void backTracking(List<List<Integer>> resultList, ArrayList<Integer> temp,int[] nums){
        if(temp.size() == nums.length){
            resultList.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            backTracking(resultList,temp,nums);
            temp.remove(temp.size()-1);
        }
    }
}
