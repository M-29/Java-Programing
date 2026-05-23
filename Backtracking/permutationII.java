class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
     void backTracking(List<List<Integer>> resultList, ArrayList<Integer> temp,int[] nums, boolean[] used){
        if(temp.size() == nums.length){
            resultList.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            used[i] = true;
            temp.add(nums[i]);
            backTracking(resultList,temp,nums,used);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
