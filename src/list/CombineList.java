package list;

import common.ConstructData;
import common.DataStyle;
import common.ListNode;
import org.junit.Test;

import java.util.ArrayList;

public class CombineList {

    /**
     * 给定两个以 有序链表 形式记录的训练计划 l1、l2，分别记录了两套核心肌群训练项目编号，请合并这两个训练计划，按训练项目编号 升序 记录于链表并返回。
     *
     * 注意：新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fnm66/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 示例 1：
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     *
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * @param l1
     * @param l2
     * @return
     */
    public ListNode trainningPlan(ListNode l1, ListNode l2) {

        if(l1==null && l2==null) return null;

        // 合并两个链表
        ListNode dummy = new ListNode(0); // 哨兵节点
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.getVal() <= l2.getVal()) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 将剩余的节点连接到末尾
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // 冒泡排序
        ListNode head = dummy.next;

        for (ListNode i = head; i != null; i = i.next) {
            for (ListNode j = head; j.next != null; j = j.next) {
                if (j.getVal() > j.next.getVal()) {
                    // 交换节点的值
                    int temp = j.getVal();
                    j.setVal(j.next.getVal());
                    j.next.setVal(temp);
                }
            }
        }

        return head;

    }

    /**
     * 方法二
     * @param l1
     * @param l2
     * @return
     */
    public ListNode trainningPlan2(ListNode l1, ListNode l2) {
        // 定义两个变量 dump：指向一个伪节点， tmp :循环使用
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
//        tmp.next = l1;
//        tmp = tmp.next;
        // 选取l1和l2中较小的值接在tmp后，并不断的移动l1或者l2的头节点位置
        // 当l1或者l2其中任意一链轮空没有元素，说明l1和l2的元素已经比较完成，并且题目前提是l1和l2都是有序链表
        while (l1 != null && l2 != null) {
            if(l1.getVal() <= l2.getVal()){
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }else {
                tmp.next = l2;
                l2= l2.next;
                tmp = tmp.next;
            }
        }
        // 题目前提是l1和l2都是有序链表，只需将剩余的节点连接在最后，即可完成链表的合并
        if(l1 != null){
            tmp.next = l1;
        }
        if(l2 != null){
            tmp.next = l2;
        }

        return dummy.next;
    }

    @Test
    public void test(){
        ListNode l1 = ConstructData.getLinkedList(3, DataStyle.STEP, 1, 2);
        ListNode l2 = ConstructData.getLinkedList(2, DataStyle.STEP, 1, 3);
        ConstructData.forElement(l1);
        ConstructData.forElement(l2);

        ListNode node = trainningPlan2(l1, l2);
        ConstructData.forElement(node);
    }
}
