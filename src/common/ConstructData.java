package common;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConstructData {


    public static ListNode getLinkedList(){

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(12);
        ListNode node5 = new ListNode(19);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        return node1;
    }

    /**
     * 生成长度为length的单向链表，每个节点为ListNode
     * @param length 链表长度
     * @param dataStyle 链表节点值的关系，RANDOM：随机生成1--100的随机整数；STEP：生成起始值为start，步长为step的length组数
     * @param args 可变参数，dataStyle为STEP时必填
     * @return
     */
    public static ListNode getLinkedList(Integer length,DataStyle dataStyle, Integer... args){

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = new ListNode();

        Integer start = null;
        Integer step = null;

        if(length == 0)
            return null;



        Integer tmp = 0;
        for (Integer i = length; i > 0; i--) {
            switch(dataStyle) {
                case RANDOM:
                    node = new ListNode(new Random().nextInt(1, 101));
                    break;

                case STEP:
                    if(args.length == 2 && dataStyle == DataStyle.STEP){
                        start= args[0];
                        step= args[1];
                    } else{
                        throw new RuntimeException("参数数量不对,当dataStyle为STEP时,args[0]为起始值,args[1]为步长");
                    }
                     tmp = (i == length) ? (start + tmp) : (tmp + step);
                     node = new ListNode(tmp);
                    break;

                default:
                    break;

            }
            list.add(node);
        }

        for (int index = 0; index < list.size() - 1; index++) {
            list.get(index).next = list.get(index + 1);
        }
        return  list.get(0);
    }

    /**
     * 传入单向链表的起始值，输出遍历后的节点值
     * @param node 单向链表起始节点
     */
    public static void forElement(ListNode node){
        ListNode tmp =null;
        StringBuffer stringBuffer = new StringBuffer();
        if(node != null){
            tmp = node;
            while (tmp != null){
                stringBuffer.append(tmp.next == null ? tmp.val :tmp.val + ",");
                tmp = tmp.next;

            }
        }
        System.out.println(stringBuffer);

    }

}
