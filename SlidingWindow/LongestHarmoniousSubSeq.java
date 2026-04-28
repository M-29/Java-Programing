class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }
        for(int i : map.keySet()){
            if(map.containsKey(i+1)){
                res = Math.max(res, map.get(i) + map.get(i+1));
            }            
        }
        return res;
    }
}
//TimeComplexity : O(n)
//SpaceComplexity : O(n)
