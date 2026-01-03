class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        int i = str.length-1;
        String out = "";
        while(i>=0){
            out = out + " " + str[i];
            i--;
        }
        return out.trim();
    }
}
