class Solution {
    public boolean isHappy(int n) {
      // Approach 1
        Set<Integer> set = new HashSet<>();
        while (true){
            int sum = 0;
            while(n != 0){
                sum += Math.pow(n%10,2);
                n = n /10;
            }
            if(sum == 1){
                return true;
            }
            n = sum;
            if(set.contains(sum)){
                return false;
            }else{
                set.add(n);
            }
        }
      // Approach 2
        int fast = n;
        int slow = n;
        do{
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }while(slow != fast);
        if(slow == 1){
            return true;
        }
        return false;
    }
    public int getSum(int n){
        int sum = 0;
        while(n != 0){
            int rem = n%10;
            sum += rem * rem;
            n = n/10;
        }
        return sum;
    }
}
