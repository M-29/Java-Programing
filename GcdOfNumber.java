class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int n1 = 20;
        int n2 = 12;
        System.out.println("GCD : " + gcd(n1,n2));
    }
    public static int gcd(int n1, int n2){
        System.out.println("N1 : " + n1);
        System.out.println("N2 : " + n2);
        if(!((n1 + n2) == (n2 + n1)))
            return 0;
        else if(n2 == 0)
            return n1;
        return gcd(n2,n1%n2);
    }
}
