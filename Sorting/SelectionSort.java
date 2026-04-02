import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int[] arr ){
        for(int i = 0; i < arr.length; i++){
            int max = 0; 
            int last = arr.length - i-1;
            for(int j = 1; j <= last; j++){
                if(arr[max] < arr[j]){
                    max = j; //Finding the max element position
                }
            }
            int temp = arr[last];
            arr[last] = arr[max];
            arr[max] = temp;
        }
    }
}

BestCase Time Complexity:- O(n^2)
WorstCase Time Complexity:- O(n^2)
