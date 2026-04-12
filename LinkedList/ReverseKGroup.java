class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <=1 || head == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;  
        while (true){
            ListNode temp = curr;
            int count = 0;
            while (temp != null && count < k) {
                    temp = temp.next;
                    count++;
            }
            if(count < k){
                if(prev != null){
                    prev.next = curr;
                }
                break;
            }
            ListNode last = prev;
            ListNode newEnd = curr;
            for(int i = 0; i < k; i++){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;                       
            }
            if(last != null){
                last.next = prev;
            }else{
                head = prev;
            }
            newEnd.next = curr;
            prev = newEnd;
            if(curr == null){
                break;
            }            
        }      
        return head;
    }
}
