package com.epam.mjc.collections.combined;

import java.util.*;

public class LessonsGetter {

    public Set<String> getLessons(Map<String, List<String>> timetable) {
        Set<String> timetableSet = new LinkedHashSet<>();

        for (Map.Entry<String, List<String>> e : timetable.entrySet()) {
            timetableSet.addAll(e.getValue());
        }

        //timetable.values().forEach(list -> list.forEach(timetableSet::add));

        System.out.println(timetableSet);
        return timetableSet;
    }

    public static void main(String[] args) {
        Map<String, List<String>> timetable = new LinkedHashMap<>();

        timetable.put("Monday", List.of("English"));
        timetable.put("Tuesday", List.of("Mathematics"));
        timetable.put("Wednesday", List.of("English", "Chemistry"));
        timetable.put("Thursday", List.of("Literature", "Mathematics"));
        timetable.put("Wednesday", List.of("Physics"));

        LessonsGetter lg = new LessonsGetter();
        lg.getLessons(timetable);

    }
}
