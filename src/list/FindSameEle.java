package list;

import common.ListNode;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class FindSameEle {
    /**
     * 某教练同时带教两位学员，分别以链表 l1、l2 记录了两套核心肌群训练计划，节点值为训练项目编号。两套计划仅有前半部分热身项目不同，后续正式训练项目相同。
     * 请设计一个程序找出并返回第一个正式训练项目编号。如果两个链表不存在相交节点，返回 null 。
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fvoq2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 关键点：1.前半部分热身项目不同，后续正式训练项目相同； 2.返回第一个正式训练项目编号
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0, lenB = 0;

        while (curA != null) {
            lenA ++;
            curA = curA.next;
        }

        while (curB != null) {
            lenB ++;
            curB = curB.next;
        }
        // 计算两个链表的元素差值
        int gap = lenA - lenB;

        // 较长的一方链表先行gap个节点，之后同时使用指针推进遍历元素
        curA = headA;
        curB = headB;
        if (gap > 0) {
            while((gap --) > 0){
                curA= curA.next;
            }
        }else{
            gap = lenB - lenA;
            while((gap --) > 0){
                curB= curB.next;
            }
        }

        // 第一个两链表共有的节点返回
        while(curA != curB ){
            // 如果没有共有节点，退出遍历
            if((null == curA || null == curB)){
                break;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }



}
