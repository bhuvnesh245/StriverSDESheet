package Arrays.d5;

public class ReverseLinkList {

    public static void main(String[] args) {
        ListNodeOld linkList = new ListNodeOld();
        linkList.addNode(1);
        linkList.addNode(2);
        linkList.addNode(3);
        linkList.addNode(4);
        linkList.addNode(5);
        linkList.addNode(6);

        System.out.println(findMiddleNode(linkList));
    }

    private static ListNodeOld findMiddleNode(ListNodeOld linkList) {

        ListNodeOld.Node node = linkList.getNode();
        ListNodeOld.Node next = node.getNext();

        while (next != null && next.getNext() != null){
            node = node.getNext();
            next = next.getNext().getNext();
        }

        return linkList;
    }

    private static ListNodeOld.Node recurseReverse(ListNodeOld.Node node, ListNodeOld.Node next, ListNodeOld linkList) {

        if(next == null){
            linkList.node = node;
            return node;
        }

        ListNodeOld.Node root = recurseReverse(next, next.next, linkList);
        root.next = node;
        return node;
    }

    private static ListNodeOld.Node reverseNode(ListNodeOld linkList) {
        ListNodeOld.Node currentNode = linkList.getNode();
        ListNodeOld.Node newNextNode = null;
        while (currentNode != null){

            if(currentNode.getNext() != null){
                ListNodeOld.Node nextNode = currentNode.getNext();
                currentNode.next = newNextNode;
                newNextNode = currentNode;
                currentNode = nextNode;
            }
        }
        return currentNode;
    }
}
