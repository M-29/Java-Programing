class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = MiddleNode(head);
        ListNode hs = ReverseList(mid);
        ListNode hf = head;
        while(hf != null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if(hf != null){
            hf.next = null;
        }
    }
     private ListNode MiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode ReverseList(ListNode mid){
        ListNode prev = null;
        ListNode curr =  mid;
        ListNode next = curr != null ? curr.next : null;
        while(curr !=  null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
}
