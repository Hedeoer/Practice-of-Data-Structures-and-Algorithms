package base.stack_and_queue;


import java.util.Arrays;

public class DequeByArray {
    /**
     * 使用数组模拟双向队列，实现以下的方法：
     * pushFirst()： 队首添加元素
     * pushLast()： 队尾田间元素
     * popFirst(): 队首删除元素
     * popLast():队尾删除元素
     * isEmpty(): 判断双向队列是否为空
     * dequeSize() ： 获取双向队列的大小
     * toArray():双向队列转化为数组
     */
    // 存储双向队列的元素的数组
    private int[] arr;
    // 队首指针的位置索引
    private int first;
    // 当前双向队列的大小
    private int dequeSize;
    // 初始化双向队列的容量
    private int capacity;

    // 初始化的方法
    public DequeByArray(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        first = dequeSize = 0;
    }

    public DequeByArray() {}

    public int dequeSize(){
        return dequeSize;
    }

    public boolean isEmpty(){
        return dequeSize == 0;
    }

    /**
     * 通过传入索引计算出在环形数组中的位置索引
     * @param num
     * @return
     */
    public int findIndex(int num){

        return (num + capacity) % capacity;
    }

    /**
     * 队首添加元素
     * @param num
     */
    public void pushFirst(int num){
        if (dequeSize == arr.length) {
            System.out.println("双向队列已满");
            return ;
        }
        first = findIndex(first - 1);
        arr[first] = num;
        dequeSize ++;
    }

    public void pushLast(int num){
        if (dequeSize == arr.length) {
            System.out.println("双向队列已满");
            return ;
        }
        int last = findIndex(first + dequeSize);
        arr[last] = num;
        dequeSize ++;
    }

    /**
     * 删除队首的元素
     * @return
     */
    public int pollFirst(){
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        int willPop = peekFirst();
        first = findIndex(first + 1);
        dequeSize --;
        return willPop;
    }

    public int peekFirst() {
        return arr[first];
    }

    /**
     * 删除队尾的元素
     * @return
     */
    public int pollLast(){
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        int willPop = peekLast();
        dequeSize --;
        return willPop;
    }

    public int peekLast() {
        return arr[findIndex(first + dequeSize - 1)] ;
    }

    public int[] toArray(){
        int[] result = new int[dequeSize];
        // 遍历双向队列的有效元素，并填充到result数组中
        for(int i = 0, j = first; i < dequeSize; j++, i++){
            result[i] = arr[findIndex(j)];
        }
        return result;
    }




}

 class TestDequeByArray{
     public static void main(String[] args) {

             /* 初始化双向队列 */
             DequeByArray deque = new DequeByArray(10);
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
             int size = deque.dequeSize();
             System.out.println("双向队列长度 size = " + size);

             /* 判断双向队列是否为空 */
             boolean isEmpty = deque.isEmpty();
             System.out.println("双向队列是否为空 = " + isEmpty);

     }

}
