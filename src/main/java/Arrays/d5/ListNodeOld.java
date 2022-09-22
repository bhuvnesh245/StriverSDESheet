package Arrays.d5;

public class ListNodeOld {
        Node node;

        public void addNode(int value){

            Node currentNode = node;

            while (currentNode !=null){

                if(currentNode.getNext() == null){
                    break;
                }

                currentNode = currentNode.getNext();
            }

            if(node == null){
                node = new Node(value, null);
            }else{
                currentNode.next = new Node(value, null);
            }

        }

        public Node getNode(){
            return node;
        }


        class Node{
            int value;
            Node next;

            Node(int value, Node next){
                this.value = value;
                this.next = next;
            }

            Node getNext(){
                return this.next;
            }
        }
}
