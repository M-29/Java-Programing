class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return MergeTwoNodes(left,right);
    }
    ListNode getMid(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }
    ListNode MergeTwoNodes(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode();
        ListNode tail = dummyNode;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next; 
            }
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummyNode.next;
    }
}
