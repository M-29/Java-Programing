import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {5,4,3,1,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSort(int[] arr ){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }
}
//BestCase Complexity: O(n^2)
//WorstCase Complexity: O(n)
