class Solution {
    public ListNode deleteMiddle(ListNode head) {
      //First Approach Brute force approach 
        // int n = size(head);
        // int index = n/2;
        // ListNode node = head;
        // if(head == null || head.next == null) return null;
        // for(int i = 0; i < index; i++){
        //     if(index == i + 1){
        //         node.next = node.next.next;
        //     }
        //     node = node.next;
        // }
        // return head;

        // Second approach is slow and fast pointer
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
    // public int size(ListNode node){
    //     if(node == null) return 0;
    //     return 1 + size(node.next);
    // }
}
