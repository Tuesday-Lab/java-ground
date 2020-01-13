package com.circlee.todo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

public class StringUtil {

    public static Character getFirstUpperCaseChar(String value) {
        return Character.toUpperCase(value.charAt(0));
    }

    public static Character getLastUpperCaseChar(String value) {
        return Character.toUpperCase(value.charAt(value.length() -1));
    }

    public static Map<Character, List<String>> groupByFirstChar(String... values) {

        return groupByKey(new Function<String, Character>() {
            @Override
            public Character apply(String s) {
                return Character.toUpperCase(s.charAt(0));
            }
        }, values);
    }



    public static Map<Character, List<String>> groupByKey(Function<String, Character> keyMapper, String... values) {

        Map<Character, List<String>> group = new TreeMap<>();

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            Character key = keyMapper.apply(value);

            if(group.containsKey(key)) {
                List<String> list = group.get(key);
                list.add(value);
                continue;
            }

            List<String> list = new ArrayList<>();
            list.add(value);
            group.put(key, list);

//            List<String> list = group.computeIfAbsent(key, (k) -> new ArrayList<>());
//            list.add(value);

        }

        return group;
    }

}
