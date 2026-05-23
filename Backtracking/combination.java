class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(k, res, new ArrayList<>(), 1,n);
        return res;
    }
    void backTrack(int k, List<List<Integer>> res, List<Integer> temp, int start, int n){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i <= n; i++){
            temp.add(i);
            backTrack(k, res, temp, i+1, n);
            temp.remove(temp.size()-1);
        }
    }
}
