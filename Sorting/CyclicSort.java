import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {5,4,3,1,2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cyclicSort(int[] arr ){
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }else{
                i++;
            }
        }
    }
}

//BestCase Complexity : O(N)
//WorstCase Complexity : O(N)
