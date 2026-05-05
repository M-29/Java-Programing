class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int n = 4567;
        System.out.println(reverse(n));
    }
    static int reverse(int n){
        int numOfDigits = (int) (Math.log10(n) + 1);
        return reverseHelper(n, numOfDigits);
    }
    static int reverseHelper(int n, int numOfDigits){
        if(n%10 == n){
            return n;
        }
        int rem = n % 10;
        return rem * (int) Math.pow(10, numOfDigits - 1) + reverseHelper(n/10 , numOfDigits - 1);
    }
}
