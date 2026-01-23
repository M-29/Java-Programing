class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        Set<Character> charSet = new HashSet<>();
        for(int end = 0; end < s.length(); end++){
            while(charSet.contains(s.charAt(end))){
                charSet.remove(s.charAt(start));
                start++;
            }
            charSet.add(s.charAt(end));
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}
