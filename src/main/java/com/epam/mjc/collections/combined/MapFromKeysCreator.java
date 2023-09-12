package com.epam.mjc.collections.combined;

import java.util.*;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> result = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> sourceStringEntry : sourceMap.entrySet()) {
            result.put(sourceStringEntry.getKey().length(), null);
        }

        for (Map.Entry<Integer, Set<String>> e : result.entrySet()) {
            Set<String>  resultSet = new HashSet<>();

            for (Map.Entry<String, Integer> entry : sourceMap.entrySet()) {
                if (entry.getKey().length() == e.getKey()) {
                    resultSet.add(entry.getKey());
                    e.setValue(resultSet);
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {

        Map<String, Integer> sourceMap = Map.of("one", 1, "two", 2, "three", 3, "five", 4, "ten", 10);
        MapFromKeysCreator map = new MapFromKeysCreator();
        map.createMap(sourceMap);

        //Input
        //one - 1
        //two - 2
        //three - 3
        //five - 4
        //ten - 10

        //Output
        //3 - one, two, ten
        //4 - five
        //5 - three
    }
}
