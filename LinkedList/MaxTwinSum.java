class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow;
        ListNode next = slow.next != null ? slow.next : null;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        int max = 0;
        while(prev != null){
            max = Math.max(max,head.val+prev.val);
            prev = prev.next;
            head = head.next;
        }
        return max;
    }
}
