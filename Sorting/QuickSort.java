import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {5,3,2,4,1,19,28};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr, int low, int high){
        if( low >= high ){
            return ;
        }
        int s = low;
        int e = high;
        int mid  = s + ( e - s ) /2;
        int pivot = arr[mid];
        while(s <= e){
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }
            if(s<= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(arr, s, high);
        quickSort(arr, low, e);
    }
}
//Best Case : O(NlogN)
//Worst Case : O(N^2)
