package Arrays.d5;

import Arrays.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        int[] arr1 ={1,2,3,4,5};
        int[] arr2 ={5,6,7,8,9};

        ListNode list1 = ListNode.convert(arr1);
        ListNode list2 = ListNode.convert(arr2);

        ListNode list3 = addTwoNumber(list1,list2);
    }

    private static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode mainNode = new ListNode(0);
        ListNode start = mainNode;

        int carry = 0;

        while (l1 !=null || l2 != null || carry == 1 ){
            int sum = 0;
            if(l1 != null){
                sum+=l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum+=l2.val;
                l2 = l2.next;
            }

            sum+=carry;

            start.next = new ListNode(sum % 10);
            start = start.next;
            carry = sum/10;

        }

        return mainNode.next;
    }
}
