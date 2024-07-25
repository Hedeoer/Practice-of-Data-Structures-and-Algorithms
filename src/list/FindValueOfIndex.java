package list;

import common.ConstructData;
import common.DataStyle;
import common.ListNode;
import org.junit.Test;

public class FindValueOfIndex {
    /**
     *
     *方式1
     * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
     * 输入：head = [2,4,7,8], cnt = 1
     * 输出：8
     */
    public ListNode findValueOfIndex(ListNode head, Integer cnt) {
        // 先将链表反转
        // 遍历链表即可
        TrainningPlan03 tp = new TrainningPlan03();
        ListNode node = tp.reverseList(head);
        ListNode result = node;
        Integer times = 0;
        while(null != result) {
            ++times;

            if(cnt.equals(times) ){
                return result;
            }
            result = result.next;
        }

        return result;
    }

    /**
     *方式二
     * @param head
     * @param cnt
     * @return
     */
    public ListNode findValueOfIndex2(ListNode head, int cnt) {
        // 双指针都指向头节点
        ListNode slow  = head;
        ListNode fast = head;

        // fast指针先往前cnt步
        for (int step = 0; step < cnt; step++) {
            fast = fast.next;
        }

        // 如果cnt大于链表长度，直接返回null
        if(null == fast.next)
            return null;

        // 当fast指针移出链表，fast所指就是链表倒数第cnt个元素
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return  slow;
    }




    @Test
    public void test(){
        ListNode node = ConstructData.getLinkedList(19, DataStyle.STEP,10,2);
        ConstructData.forElement(node);
//        System.out.println(findValueOfIndex(node, 3).getVal());


        System.out.println("=========================");
        System.out.println(findValueOfIndex2(node, 1).getVal());

    }
    
    
}
