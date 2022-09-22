package Arrays.d6;

import Arrays.ListNode;

public class FlatLinkList {

    public static void main(String[] args) {

        int arr[] = {5,10,19,28};
        int node1Bottom[] = {7,8,30};
        int node2Bottom[] = {20};
        int node3Bottom[] = {22,50};
        int node4Bottom[] = {35,40,45};

        ListNode head = ListNode.convert(arr);
        ListNode dummy = new ListNode(0,head);
        ListNode setBottom = dummy.next;
        Integer count =1;
        while (setBottom !=null){

            switch (count){
                case  1 : setBottom.bottom = ListNode.convert(node1Bottom);break;
                case  2 : setBottom.bottom = ListNode.convert(node2Bottom);break;
                case  3 : setBottom.bottom = ListNode.convert(node3Bottom);break;
                case  4 : setBottom.bottom = ListNode.convert(node4Bottom);break;
            }

            count++;
            setBottom = setBottom.next;
        }

        ListNode flatList = flatList(head);
        System.out.println(head);
    }

    private static ListNode flatList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode node = dummy.next;

        while (node.next != null){

            if(node.bottom == null){
                node = node.next;
            }else if(node.bottom.val < node.next.val){
                ListNode tempNext = node.next;
                node.next = node.bottom;
                node.bottom.bottom = node.bottom.next;
                node.bottom = null;
                node.next.next = tempNext;
                node = node.next;
            }else{
                ListNode bottom = node.bottom;
                node.bottom = null;
                moveBottomToCorrectLocation(node, bottom);
                node= node.next;
            }


        }

        node.next = node.bottom;
        node.bottom=null;

        ListNode printNode = dummy.next;
        while(printNode !=null){
            System.out.print(printNode.val+" ");
            printNode=printNode.next;
        }
        return dummy.next;
    }

    private static void moveBottomToCorrectLocation(ListNode node, ListNode bottom) {

        while (node.next != null && node.val < bottom.val && node.next.val < bottom.val){

            node = node.next;
        }

        ListNode tempNode = node.next;
        node.next = bottom;
        bottom.bottom = bottom.next;
        bottom.next = tempNode;
    }
}
