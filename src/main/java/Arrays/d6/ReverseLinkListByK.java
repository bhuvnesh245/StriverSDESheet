package Arrays.d6;

import Arrays.ListNode;

public class ReverseLinkListByK {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        ListNode list = ListNode.convert(arr);

        ListNode reverseList = reverseLL(list,list.next);

    }

    private static ListNode reverseLL(ListNode head, ListNode newHead) {

        if(newHead.next == null){
            return newHead;
        }

        ListNode tempHead = head.next;
        newHead.next = head;

        return  newHead = reverseLL(tempHead, newHead);
    }
}
