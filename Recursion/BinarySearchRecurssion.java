class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int[] arr ={ 2,5,7,9,10,11};
        int target  = 9;
        System.out.println(search(arr,target,0,arr.length-1));
    }
    public static int search(int[] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }
        int m = s + (e - s) / 2;
        if(arr[m] == target){
            return m;
        }
        if(arr[m] < target){
            return search(arr, target, m+1, e);
        }
        return search(arr,target, s, m-1);
    }
}
