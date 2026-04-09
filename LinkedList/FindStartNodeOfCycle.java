// Approach 1
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        
        int len = LengthOfCycle(s);
        
        if(len == 0){
            return null;
        }
        while(len > 0){
            s = s.next; // Moving the second pointer till the length of the cycle
            len--;
        }
        while(f != s){ // Keep moving the first and second pointer till they meet.
            f = f.next;
            s = s.next;
        }
        return s;
    }
    public int LengthOfCycle(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        int length = 0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                break;
            }
        }
        return length;
    }
}
//Approach 2
 public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                while(start != slow){
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }
