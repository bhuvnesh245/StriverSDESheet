package Arrays;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode bottom;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(int val) {

        ListNode newNode = new ListNode(val);
        ListNode currentNode = next;

        while (currentNode != null) {

            if (currentNode.next == null) {
                break;
            }
            currentNode = currentNode.next;
        }


        if (currentNode == null) {
            next = newNode;
        } else {
            currentNode.next = newNode;
        }
    }


    public static ListNode convert(int[] arr){
        ListNode mainNode = new ListNode(0);
        ListNode start = mainNode;


        for (int i : arr){
            start.next = new ListNode(i);
            start = start.next;
        }

        return mainNode.next;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        ListNode printNode = next;
//        while (printNode!=null){
//            builder.append(printNode.val+ (printNode.next != null ? "->" : ""));
//            printNode = printNode.next;
//        }
//
//        return builder.toString();
//    }
}