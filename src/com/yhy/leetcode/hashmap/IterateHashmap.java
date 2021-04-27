package com.yhy.leetcode.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IterateHashmap {


    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");

//        Iterator<Map.Entry<Integer, String>> it = hashMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<Integer, String> item = it.next();
//            if (item.getKey().equals(1)) {
//                it.remove();
//            }
//            System.out.println("");
//        }
        hashMap.entrySet().removeIf(entry -> entry.getKey() == 2);
        for (Map.Entry<Integer, String> map : hashMap.entrySet()) {
            System.out.println("Key is :" + map.getKey());
            System.out.println("Value is :" + map.getValue());
        }

//        hashMap.forEach((k, v) -> System.out.println(k + " " + v));

        for (Integer nums : hashMap.keySet()) {
            System.out.println(nums);
        }
    }
}
