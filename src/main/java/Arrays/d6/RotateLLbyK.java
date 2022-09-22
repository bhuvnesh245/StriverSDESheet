package Arrays.d6;

import Arrays.ListNode;

/**
 * This was asked in air bnb
 */
public class RotateLLbyK {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.convert(arr);
        int k = 2;
        ListNode p = head;

        int length = 1;
        for (;p.next != null; length++)
            p = p.next;

        p.next = head;

        k %=length;

        for (int i = 0; i < length-k; i++){
            p=p.next;
        }

        head = p.next;
        p.next=null;

        System.out.println(head);

    }

    public ListNode rotateBy2Pointer(ListNode head, int k ){
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        int length;
        for (length=0; fast.next!= null; length++)
            fast=fast.next;

        for (int i = k-length%length; i >0; i-- ){
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        System.out.println(dummy.next);
        return dummy.next;
    }
}
