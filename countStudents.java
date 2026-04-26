class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] arr = {0,0};
        for(int std : students){
            arr[std]++;
        }
        for(int i = 0;i<students.length;i++){
            int sand = sandwiches[i];
            if(arr[sand] == 0){
                return students.length-i;
            }
            arr[sand]--;
        }
        return 0;
    }
}
