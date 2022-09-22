package Arrays.d6;

import Arrays.ListNode;

public class PalindromeList {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,2,1};
        ListNode listNode = ListNode.convert(arr);

        ListNode middleOfNode = findMiddleOfNode(listNode);

        System.out.println(middleOfNode.val);

        ListNode reverseHead = reverseNode(middleOfNode.next, null);

        System.out.println(reverseHead);

        System.out.println(findPalindrome(listNode , reverseHead));
    }

    private static boolean findPalindrome(ListNode listNode, ListNode reverseHead) {
        boolean palindrome = true;
        while (reverseHead != null){

            if(reverseHead.val !=  listNode.val){
                palindrome = false;
                break;
            }
            reverseHead = reverseHead.next;
            listNode = listNode.next;
        }

        return palindrome;
    }

    private static ListNode reverseNode(ListNode head, ListNode newHead) {

        if (head == null){
            return newHead;
        }
        ListNode tempHead = head.next;
        head.next = newHead;
        return reverseNode(tempHead, head);
    }

    private static ListNode findMiddleOfNode(ListNode listNode) {
        ListNode dummNode = listNode;
        ListNode slow = dummNode;
        ListNode fast = dummNode;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode palindromeMyFirsSolution(ListNode head, ListNode tail) {

        if(tail == null){
            return head;
        }

        head = palindromeMyFirsSolution(head, tail.next);

        if(head == null || head == head.next){
            return head;
        }else if(head.val == tail.val){
            return head.next;
        }else if(head == tail){
            head = new ListNode(0);
            head.next = head;
            return head;
        }else{
            return null;
        }
    }
}
