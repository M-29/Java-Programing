class Solution {
    public int compress(char[] chars) {
        int count = 1;
        int write = 0;
        int i=1;
        while(i<=chars.length){
            if(i<chars.length && chars[i] == chars[i-1]){
                count++;
            }else{
                chars[write++] = chars[i-1];
                if(count>1){
                   for(char c : String.valueOf(count).toCharArray()){
                        chars[write++] = c;
                   }
                }
                count = 1;
            }
            i++;
        }
        return write;
    }
}
