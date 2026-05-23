class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        Map<Character, String> map = new HashMap<>(); 
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backTrack(0,res,digits,temp, map);
        return res;
    }
    void backTrack(int idx, List<String> res, String digits, StringBuilder temp,  Map<Character, String> map){
        if(temp.length() == digits.length()){
            res.add(temp.toString());
            return;
        }
        char ch = digits.charAt(idx);
        String mappedStr = map.get(ch);
        for(int i = 0; i < mappedStr.length(); i++){
            temp.append(mappedStr.charAt(i));
            backTrack(idx+1, res,digits,temp,map);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
