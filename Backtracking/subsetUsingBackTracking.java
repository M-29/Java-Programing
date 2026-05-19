// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.List;
import java.util.ArrayList;
class Main {
    public static void main(String[] args) {
           
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = {1,2};
        int start = 0;
        backtracking(result,new ArrayList<>(),nums,start);
        System.out.println("Result :- "+ result);
    }
    static void backtracking(List<List<Integer>> res, List<Integer> temp, int[] nums, int start){
        res.add(new ArrayList<> (temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            System.out.println("Item added"+ nums[i]);
            backtracking(res, temp, nums, i+1);
            int removed = temp.remove(temp.size() -1);
            System.out.println("Item removed"+ removed);
        }
    }
}
