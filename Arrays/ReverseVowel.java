class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] chArray = s.toCharArray();
        while(i<j){
             if(i<j && !isVowel(chArray[i])){
                i++;
            }
            else if(i<j && !isVowel(chArray[j])){
                j--;
            }
            else{
                char temp = chArray[i];
                chArray[i] = chArray[j];
                chArray[j] = temp; 
                i++;
                j--;
            }
        }
        return new String(chArray);
    }
    public boolean isVowel(char c){
        return c == 'a' ||  c == 'e' ||  c == 'i' ||  c == 'o' ||  c == 'u'
        ||  c == 'A' ||  c == 'E' ||  c == 'I' ||  c == 'O' ||  c == 'U';
    }
}
