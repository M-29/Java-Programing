class Solution {
    public int maxVowels(String s, int k) {
       int currMax = 0;
       for(int i = 0;i<k;i++){
        if(isVowel(s.charAt(i))){
                currMax++;
            }
       }
        int max = currMax;
       for(int i = k; i < s.length(); i++){
        if(isVowel(s.charAt(i-k))){
            currMax--;
        }
        if(isVowel(s.charAt(i))){
                currMax++;
            }
        
        if(currMax > max){
            max = currMax;
        }
       } 
       return max;
    }
    public boolean isVowel(char c){
        return c == 'a' ||  c == 'e' ||  c == 'i' ||  c == 'o' ||  c == 'u'
        ||  c == 'A' ||  c == 'E' ||  c == 'I' ||  c == 'O' ||  c == 'U';
    }
}
