import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {1,2,3,4,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr ){
        boolean isSwapped = false;
        // Run the steps till n-1
        for(int i = 0; i < arr.length; i++){
            isSwapped = false;
            // For each step max item will come at last respective index
            for(int j = 1; j < arr.length - i; j++){
                // swap if current element is samller than previous element
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    isSwapped = true;
                }
            }
            //if you do not swap for particular value of i it means array is sorted and no need for comaparision
            if(!isSwapped){
                System.out.println("Loop get break");
                break;
            }
        }
    }
}
