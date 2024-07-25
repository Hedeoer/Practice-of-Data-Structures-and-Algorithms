package list;

import common.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/*
*
* 书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放回到书架上。请倒序返回这个书单链表。
输入：head = [3,6,4,1]

输出：[1,4,6,3]
* */

//Definition for singly-linked list.

public class BookRestore01 {

     // 方式一
    public static int[] reverseBookList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        // 构造临时节点
        ListNode tmp = new ListNode();
        tmp = head;
        // 遍历ListNode存储于list中
        while(tmp.next != null) {
            list.add(tmp.getVal());
            tmp = tmp.next;
        }
        list.add(tmp.getVal());

        // 将list的数据转存数组
        int[] result = new int[list.size()];
        // pos:数组索引 ++
        // size：列表索引 --
        for (int size = list.size() - 1, pos = 0; size >= 0 ; size--, pos ++) {
            result[pos] = list.get(size);
        }
        System.out.println(result[0]);
        return result;
    }

    // 方式二，使用递归倒叙
    public static int[] reverseBookList2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        // 递归存放元素于list
        resur(head,list);
        // 倒序遍历list，并倒置存放元素于数组
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void resur(ListNode head, ArrayList<Integer> list) {
        // 递归终止条件
        if (head == null) {
            return;
        }
        // 循环调用
        resur(head.next, list);
        // 无返回值，将节点值存放list
        list.add(head.getVal());


    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        int[] ints = reverseBookList2(node1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
