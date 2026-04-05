import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {5,3,2,4,1,19,28};
        mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int s, int e){
        if((e - s) == 1){
            return ;
        }
        int mid  = (s + e) /2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid, e);
        mergeArray(arr,s,mid,e);
    }
    static void mergeArray(int[] arr, int s, int m, int e){
        int[] mergedArray = new int[e -s];
        int i = s;
        int j = m;
        int k = 0;
        while(i < m && j < e){
            if(arr[i] < arr[j]){
                mergedArray[k] = arr[i];
                i++;
            }else{
                mergedArray[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i < m){
            mergedArray[k] = arr[i];
                i++;
                k++;
        }
        while(j < e){
            mergedArray[k] = arr[j];
                j++;
                k++;
        }
        for(int l = 0; l < mergedArray.length; l++){
            arr[s+l] = mergedArray[l];
        }
    }
}
