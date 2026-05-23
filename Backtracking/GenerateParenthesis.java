class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int oc =0;
        int cc =0;
        String str = "";
        backTrack(res,oc,cc,n,str);
        return res;
    }
    public void backTrack(List<String> res, int oc, int cc, int n, String str){
        if(oc == n && cc == n){
            res.add(str);
            return;
        }
        if(oc < n){
            backTrack(res,oc+1,cc,n,str + '(');
        }
        if(cc < oc){
            backTrack(res,oc,cc+1,n,str + ')');
        }
    }
}
