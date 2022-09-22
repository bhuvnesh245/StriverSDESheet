package Arrays.d6;

import Arrays.ListNode;

public class FindStartOfLoop {

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(6);
        ListNode listNode5 = new ListNode(5,listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode = new ListNode(1,listNode2);
        listNode2.next = listNode;

        ListNode loopNode = findLoopNode(listNode);

        System.out.println(loopNode.val);
    }

    private static ListNode findLoopNode(ListNode listNode) {
        ListNode dummyNode = new ListNode(0, listNode);
        ListNode slow = listNode;
        ListNode fast = listNode;
        ListNode entry = listNode;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return null;
        }else{

            while ( entry != slow){
                slow =slow.next;
                entry = entry.next;
            }

            return slow;
        }
    }
}
