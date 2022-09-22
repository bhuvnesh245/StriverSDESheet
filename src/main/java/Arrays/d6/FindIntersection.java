package Arrays.d6;

import Arrays.ListNode;

public class FindIntersection {

    public static void main(String[] args) {
        int arr1[] = {1,3,1};
        int arr2[] = {3};
        int intersectionArr[] = {2,4};
        ListNode l1 = ListNode.convert(arr1);
        ListNode l2 = ListNode.convert(arr2);
        ListNode i1 = ListNode.convert(intersectionArr);

        ListNode dn1 = l1;
        while (dn1.next != null){
            dn1 = dn1.next;
        }

        //dn1.next = i1;

        ListNode dn2 = l2;
        while (dn2.next != null){
            dn2 = dn2.next;
        }

        //dn2.next = i1;

        ListNode found = findIntersection(l1,l2);

        System.out.println(found.val);
    }

    private static ListNode findIntersection(ListNode head1, ListNode head2) {
        ListNode d1 = head1;
        ListNode d2 = head2;

        while(d1 != d2) {
            d1 = d1 == null? head2:d1.next;
            d2 = d2 == null? head1:d2.next;
        }

        return d1;
    }
}
