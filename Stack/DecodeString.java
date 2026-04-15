class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num *10 + (c - '0');
            }
            else if(c == '['){
                stringStack.push(curr);
                numStack.push(num);
                num = 0;
                curr = new StringBuilder();
            }
            else if( c == ']' ){
                int repeat = numStack.pop();
                StringBuilder prev = stringStack.pop();
                for(int i = 0; i < repeat; i++){
                    prev.append(curr);
                }
                curr = prev;
            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
