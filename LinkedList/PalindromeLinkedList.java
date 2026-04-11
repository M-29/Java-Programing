class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = MiddleNode(head);
        ListNode headSecond = ReverseList(mid);
        while(head != null && headSecond != null){
            if(head.val == headSecond.val){
                head = head.next;
                headSecond = headSecond.next;
            }else{
                break;
            }
        }
        return head == null || headSecond == null;
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
