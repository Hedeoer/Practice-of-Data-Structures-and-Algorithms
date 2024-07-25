package list;


import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList {
    /**
     * 随机链表的复制
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {


        HashMap<Node, Node> map = new HashMap<>();
        Node tmp = null;


        tmp = head;


        while (null != tmp) {
            Node node = new Node(tmp.val);
            map.put(tmp, node);
            tmp = tmp.next;
        }
        tmp = head;

        while (null != tmp) {
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }


        return map.get(head);
    }




}
