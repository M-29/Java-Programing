public class palindromNumber{
  public static void main(String args[]){
    int i = 4554;
    int res = 0;
    int temp = i;
    while(i>0){
      res = res * 10 + i % 10;
      i = i / 10;
    }
    if(res == temp)
      System.out.println("Palindrone number");
    else
      System.out.println("Not a palindone number");
  }
}
