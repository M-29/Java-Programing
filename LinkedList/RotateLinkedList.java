class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k <= 0 || head == null){
            return head;
        }
        ListNode last = head;
        int l = 1;
        while(last.next != null){
            last = last.next;
            l++;
        }
        last.next = head;
        int rotation = k % l;
        int steps = l - rotation;
        ListNode newLast = head; 
        for(int i = 0; i < steps-1 ; i++){
            newLast = newLast.next;
        }
        ListNode newHead = newLast.next;
        newLast.next = null;
        head = newHead;
        return head;     
    }
}
