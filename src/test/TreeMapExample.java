package test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {

    class myTreeMap<K,V> extends TreeMap<K,V>{

    }
    public static void main(String[] args) {
        Integer totalNums = 2;
        Integer before = (int) (Math.floor( (totalNums + 1) / 2.0 ) - 1);
        Integer after = (int) (Math.ceil( (totalNums + 1) / 2.0 ) - 1);

        System.out.println(before);
        System.out.println(after);

    }
}
