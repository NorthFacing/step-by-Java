package com.bob.jdk.test;


import com.bob.jdk.java.util.MyHashMap6;

import java.util.HashMap;
import java.util.Map;

public class MyHashMapTest {

  public static void main(String[] args) {

    Map<String, String> map = new MyHashMap6<>();

    map.put("K1", "V1");
    map.put("K2", "V2");
    map.put("K3", "V3");
    map.put("K4", "V4");
    map.put("K5", "V5");
    map.put("K6", "V6");
    map.put("K7", "V7");
    map.put("K8", "V8");
    map.put("K9", "V9");
    map.put("K10", "V10");
    map.put("K11", "V11");
    map.put("K12", "V12");
    map.put("K13", "V13");
    map.put("K14", "V14");
    map.put("K15", "V15");
    map.put("K16", "V16");
    map.put("K17", "V17");
    map.put("K18", "V18");
    map.put(null, "nullVal");

    System.out.println(map);


    HashMap<Object, Object> hashMap = new HashMap<>();

  }
}
