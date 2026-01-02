public class reverseNumber{
  public static void main(String args[]){
    int i = 12345;
    int res = 0;
    while(i>0){
      res = res * 10 + i % 10;
      i = i / 10;
    }
    System.out.println("Reverse no: " + res);
  }
}
