package Arrays.d6;

import Arrays.Node;

import java.util.HashMap;

public class CopyRandomList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        node.next = node2;
        node.random = node2;
        node2.random = node2;

        copyRandomList(node);
    }

    public static Node copyRandomList(Node head) {

        Node dummy = new Node(0);
        dummy.next = head;
        Node start = dummy.next;

        Node copyNode = new Node(0);
        Node copyNodeIterate = copyNode;
        HashMap<Node, Integer> parentNodeIndexes = new HashMap<>();
        HashMap<Integer, Node> copyNodeIndexes = new HashMap<>();

        int count =1;
        while ( start != null){

            copyNodeIterate.next = new Node(start.val);
            parentNodeIndexes.put(start, count);
            copyNodeIndexes.put(count, copyNodeIterate.next);
            copyNodeIterate = copyNodeIterate.next;
            start = start.next;
            count++;
        }

        copyNodeIterate = copyNode;
        start = dummy.next;
        while ( start != null){

            copyNodeIterate.next.random = copyNodeIndexes.get(parentNodeIndexes.get(start.random));
            copyNodeIterate = copyNodeIterate.next;
            start = start.next;
        }

        return copyNode.next;
    }
}
