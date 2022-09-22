package Arrays.d5;

import Arrays.ListNode;

public class MergeLinkList {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.add(3);
        list1.add(5);

        System.out.println(list1);

        ListNode list2 = new ListNode(2);
        list2.add(4);
        list2.add(6);
        list2.add(7);

        System.out.println(list2);
        list1 = mergeList(list1,list2);
        System.out.println(list1);
    }

    private static ListNode mergeList(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        if(list1.val <= list2.val){
            list1.next = mergeList(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeList(list1, list2.next);
            return list2;
        }
    }

}
