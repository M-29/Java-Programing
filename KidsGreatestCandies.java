class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        int max = 0;
        for(int candy: candies){
            max = Math.max(max,candy);
        }
        List<Boolean> arr = new ArrayList(len);
        for(int i = 0; i < len; i++){
                int candy = candies[i] + extraCandies;
                if(max <= candy){
                     arr.add(true);
                }else{
                     arr.add(false);
                }
        }
        return arr;
    }
}
