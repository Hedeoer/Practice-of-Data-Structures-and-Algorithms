package list;



import common.ConstructData;
import common.DataStyle;
import common.ListNode;
import org.junit.Test;

import java.util.ArrayList;




public class TrainningPlan03  {
    private ArrayList<ListNode> result;

    /**
     * 方法一
     * @param head
     * @return
     */
    public ListNode trainningPlan(ListNode head){
        result = new ArrayList<>();

        // 1. 递归构建存储node的list，并使用反转的node值初始化每个节点
        resur(head);
        // 2.遍历result并构建每个node的指向关系
        if(result.isEmpty()){
            return null;
        }
        for (int index = 0; index < result.size() - 1; index++) {
            result.get(index).next = result.get(index + 1);
        }
        // 返回首节点
        return  result.get(0);
    }
    private void resur(ListNode head){
        // 终止条件
        if(head == null){
            return;
        }
        // 递归调用
        resur(head.next);
        // 返回值
        result.add(new ListNode(head.getVal()));
    }

    /**
     * 方式二，双指针
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){

        ListNode tmp = null;
        ListNode pre = null;
        ListNode cur = head;

        if(head.next == null)
            return head;

        while(null != cur){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return  pre;
    }

    @Test
    public void test() {
        // 之前的单向链表
        ListNode node = ConstructData.getLinkedList(10, DataStyle.STEP,100);
        ConstructData.forElement(node);

        // 反转后的单向链表
        ListNode newNode = trainningPlan(node);
        ConstructData.forElement(newNode);

        ListNode node1 = reverseList(node);
        ConstructData.forElement(node1);
    }
}
