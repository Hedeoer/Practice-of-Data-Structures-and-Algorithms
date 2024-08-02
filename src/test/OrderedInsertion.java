package test;

import java.util.ArrayList;
import java.util.Collections;

public class OrderedInsertion {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(1); // 初始列表，可以省略这一步，直接从插入开始
        list.add(3);
        list.add(5);
        
        // 要插入的元素
        int elementToInsert = 4;
        
        // 使用 binarySearch 查找插入点
        int index = Collections.binarySearch(list, elementToInsert);
        System.out.println(index + "======");
        
        // 检查元素是否存在于列表中
        if (index < 0) {
            // 如果元素不存在，得到插入点
            index = -(index + 1);
            
            // 在找到的插入点处插入元素
            list.add(index, elementToInsert);
        }
        
        // 输出更新后的列表
        System.out.println(list); // 应输出: [1, 3, 4, 5]
    }
}
