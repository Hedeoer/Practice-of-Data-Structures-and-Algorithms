package list;


import common.ConstructData;
import common.ListNode;

public class DeleteElementLinkdedList02 {

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     *
     * 返回删除后的链表的头节点。
     *
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fmls1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 方式一
     */

    public static ListNode deleteElement(ListNode head, Integer delValue){


        ListNode tmp = head;
        ListNode beforeNode = head;
        if(null != head){
            // 如果删除的在尾节点且为单节点链表
            if(null == head.next && head.getVal() == delValue)
                head = null;

            // 如果删除的在头节点且为单节点链表
            if(null != head.next && head.getVal() == delValue)
                head = head.next;

            while(null != tmp ){
                if(tmp.getVal() == delValue){
                    // 寻找到直接跳过并返回头节点
                beforeNode.next = tmp.next;
                return head;
                }
                beforeNode = tmp;
                tmp = tmp.next;
            }
        }
        // 空链表直接返回
        return head;

    }

    /**
     * 方式二
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if(head.getVal() == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.getVal() != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }

    public static void main(String[] args) {
        // 构造单向链表
        ListNode head = ConstructData.getLinkedList();
        // 测试删除元素方法
        ListNode newNode = DeleteElementLinkdedList02.deleteElement(head, 3);
        // 遍历删除元素后的链表
        ConstructData.forElement(newNode);
    }

}
