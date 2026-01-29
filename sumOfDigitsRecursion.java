class Main {
    public static void main(String[] args) {
        System.out.println(sumOfNumber(1345));
    }
    static int sumOfNumber(int n){
        if(n == 0)
            return 0;
        return n%10 + sumOfNumber(n/10);       
    } 
}
