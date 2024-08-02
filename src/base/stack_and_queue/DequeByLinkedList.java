package base.stack_and_queue;


import java.util.Arrays;

/**
 * 单个节点
 */
class ListNode{
    int val;
    ListNode pre;
    ListNode next;

    public ListNode(Integer val){
        this.val = val;
        pre  = next = null;
    }
}

/**
 * 使用java中的双向链表实现双端队列 deque
 * 需要拥有的方法：
 * 1. 队首入队 pushFist(val)
 * 2. 队首出队 pollFirst()
 * 3. 队尾入队 pushLast(val)
 * 4. 队尾出队 pollLast()
 * 5. 获取队首元素 peekFirst()
 * 6. 获取队尾元素 peekLast()
 * 7. 获取队列的大小 Size()
 * 8. 判断队列是否为空 isEmpty()
 */
public class DequeByLinkedList {
    // 队首,队尾
    private ListNode head, tail;
    // 队列的长度
    private int queSize;
    //初始化队列
    public DequeByLinkedList(){
        queSize = 0;
        head = tail = null;
    }

    /**
     * 获取队列的大小
     * @return
     */
    public int Size(){
        return queSize;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return queSize == 0;
    }

    public void push(int val, boolean ifFront){

        ListNode newNode = new ListNode(val);
        // 添加元素时队列是否为空, 注意条件判断的完备性
        if (isEmpty()) {
            head = tail = newNode;
        }else {

            // 判断元素添加的位置是否再队首
            if (ifFront) {
                head.pre = newNode;
                newNode.next = head;
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                tail = newNode;
            }
        }

        // 队列大小增加1
        ++ queSize;
    }

    public void pushFirst(int val){
        push(val, true);
    }

    public void pushLast(int val){
        push(val, false);
    }

    public Integer poll(boolean isFront){
        // 队列为空， 返回null
        if (isEmpty()) {
            return null;
        }

        // 获取移除节点的值
        Integer pollValue = isFront ? head.val : tail.val;

        // 判断是否要移除队首的元素
        if(isFront){
            ListNode tmp = head.next;
            head.next = null;
            tmp.pre = null;
            head = tmp;
        }else{
            ListNode tmp = tail.pre;
            tmp.next = null;
            tail.pre = null;
            tail = tmp;
        }

        queSize--;
        return pollValue;
    }

    public Integer pollFirst(){
        return poll(true);
    }

    public Integer pollLast(){
        return poll(false);
    }

    public Integer peekFirst(){
        return head.val;
    }

    public  Integer peekLast(){
        return tail.val;
    }

    // 将双向队列转换为数组
    public Integer[] toArray(){
        Integer[] array = new Integer[queSize];
        ListNode cur = head;
        for (int i = 0; i < array.length; i++) {
            array[i] = cur.val;
            cur = cur.next;
        }
        return  array;
    }

}

 class linkedlist_deque {
    public static void main(String[] args) {
        /* 初始化双向队列 */
        DequeByLinkedList deque = new DequeByLinkedList();
        deque.pushLast(3);
        deque.pushLast(2);
        deque.pushLast(5);
        System.out.println("双向队列 deque = " + Arrays.toString(deque.toArray())); //[3,2,5]

        /* 访问元素 */
        int peekFirst = deque.peekFirst();
        System.out.println("队首元素 peekFirst = " + peekFirst);
        int peekLast = deque.peekLast();
        System.out.println("队尾元素 peekLast = " + peekLast);

        /* 元素入队 */
        deque.pushLast(4);
        System.out.println("元素 4 队尾入队后 deque = " + Arrays.toString(deque.toArray()));
        deque.pushFirst(1);
        System.out.println("元素 1 队首入队后 deque = " + Arrays.toString(deque.toArray()));

        /* 元素出队 */
        int popLast = deque.pollLast();
        System.out.println("队尾出队元素 = " + popLast + "，队尾出队后 deque = " + Arrays.toString(deque.toArray()));
        int popFirst = deque.pollFirst();
        System.out.println("队首出队元素 = " + popFirst + "，队首出队后 deque = " + Arrays.toString(deque.toArray()));

        /* 获取双向队列的长度 */
        int size = deque.Size();
        System.out.println("双向队列长度 size = " + size);

        /* 判断双向队列是否为空 */
        boolean isEmpty = deque.isEmpty();
        System.out.println("双向队列是否为空 = " + isEmpty);
    }
}
