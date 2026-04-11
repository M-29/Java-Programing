class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode startHead = dummyNode;
        ListNode currentNode = head;
        for(int i = 0; i < left - 1; i++){
            startHead = startHead.next;
            currentNode = currentNode.next;
        }
        ListNode prev = null;
        ListNode reversedHead = currentNode;
        ListNode next = currentNode != null ? currentNode.next : null;
        for(int i = 0; i < (right - left + 1); i++){
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
            if(next != null){
                next = next.next;
            }
        }
        startHead.next = prev;
        reversedHead.next = currentNode;
        return dummyNode.next;
    }
}
