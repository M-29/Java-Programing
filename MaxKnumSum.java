// For this question we have two approach one is using hashmap another is two pointer first one is hashmap approach in which we are checking the frequency of the compliment
// of num[i] and compare the frequency of the target

class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap();
        for(int i =0; i < nums.length; i++){
            int target = k - nums[i];
            if(map.containsKey(target)){
                count++;
                if(map.get(target) == 1){
                    map.remove(target);
                }else{
                    map.put(target,map.get(target)-1);
                }                
            }else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return count;//Time complexity is O(n) and space complexity O(N)
    }
}


//Second Approach
class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums); // Array must be sorted in this approach
        while(left < right){
            int target = nums[left] + nums[right];
            if(target == k){
                count++;
                left++;
                right--;
            }
            if(target < k){
                left++;
            }else if(target > k){
                right--;
            }
        }
        return count; //Hence time complexity is O(nlogn) space complexity is O(1)
    }
}
