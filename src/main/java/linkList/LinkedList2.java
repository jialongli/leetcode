package linkList;

/**
 * Description Of The Class
 *
 * @author jialong2.li
 * @version 1.0.0, 2020/12/26-11:13 PM.
 * @since 2020/12/26-11:13 PM
 */
public class LinkedList2 {

    Node head;
    Node tail;

    public void createLinkList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node1.pre = null;
        node2.next = node3;
        node3.next = node4;
        head = node1;
    }

    public void deleteData(int data) {
        Node tmp = this.head;
        while (tmp.next.data != data) {
            tmp = tmp.next;
            if (tmp == null) {
                break;
            }
        }
        tmp.next = tmp.next.next;
        tmp.next.next = null;
    }

    public static void main(String[] args) {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.createLinkList();
        linkedList2.deleteData(3);
        System.out.println(linkedList2);
    }
}

class Node {
    int data;
    Node next;
    Node pre;


    public Node(int data) {
        this.data = data;
    }
}