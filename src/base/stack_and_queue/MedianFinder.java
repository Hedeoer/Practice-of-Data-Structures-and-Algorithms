package base.stack_and_queue;

import java.util.*;

class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }


    class MedianFinder2 {
        /*
        *
        * 创建一个treeMap，key为添加的元素的值， value为元素出现的次数
        * 维护一个totalNums表示已经加入的元素个数； 每添加一个元素，totalNum + 1
        * 遍历treeMap，并将key转化为数组，出现几次数组中就出现几次，创建数组 int[] arr = new int[totalNums]
        * 得到中位数 (arr【i】 + arr[j] ) / 2
        * 偶数或者偶数： index = (arr[floor((totalNum + 1) / 2)] + arr[ceil((totalNum + 1) / 2)] ) / 2  ========== floor((4 + 1) / 2) = 2, ceil((4 + 1) / 2) = 3 =====> 转化为索引
        * */

        TreeMap<Integer,Integer> tree;
        Integer totalNums;
        Integer[] arr ;
        public MedianFinder2() {
            tree = new TreeMap<Integer,Integer>();
            totalNums = 0;
        }
        public void addNum(int num) {
            ++ totalNums;
            tree.put(num, tree.getOrDefault(num, 0) + 1);
        }
        public double findMedian() {
            arr = new Integer[totalNums];
            if(totalNums == 0){
                throw new RuntimeException("No element");
            } else if (totalNums == 1) {
                return tree.firstKey();
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                Set<Map.Entry<Integer, Integer>> entries = tree.entrySet();
                // 按照元素的出现次数添加到list中，比如<2,3>到list变为{2，2，2}
                for (Map.Entry<Integer, Integer> entry : entries) {
                    for (Integer i = 0; i < entry.getValue(); i++) {
                        list.add(entry.getKey());
                    }
                }
                // list转化为array
                arr = list.toArray(new Integer[0]);
            }

            // 计算求取中位数的索引位置
            Integer before = (int) (Math.floor( (totalNums + 1) / 2.0 ) - 1);
            Integer after = (int) (Math.ceil( (totalNums + 1) / 2.0 ) - 1);



            return (arr[before] + arr[after]) / 2.0;
        }


    }
}
