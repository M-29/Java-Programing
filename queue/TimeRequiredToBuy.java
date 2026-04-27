class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < tickets.length; i++){
            queue.offer(new int[]{i,tickets[i]});
        }
        int time = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            curr[1]--;
            time++;

            if(curr[0] == k && curr[1] == 0){
                return time;
            }

            if(curr[1] > 0){
                queue.offer(curr);
            }
        }
        return time;
    }
}
