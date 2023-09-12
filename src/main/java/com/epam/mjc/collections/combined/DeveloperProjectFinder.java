package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> result = new LinkedList<>();

        //Filling the list of projects with given developer
        for (Map.Entry<String, Set<String>> e : projects.entrySet()) {
            if (e.getValue().contains(developer)) {
                result.add(e.getKey());
            }
        }

        //sorting elements using comparator
        Comparator c = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        Collections.sort(result, c);
        Collections.reverse(result);

        //System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
        String developer = "Ivan";
        Map<String, Set<String>> projects = Map.of("CSO", Set.of("Ivan", "Anna", "Lidia", "Antony"),
                "VVaS", Set.of("Mary", "Ben", "Max"), "LJA", Set.of("Oleg", "Ivan", "Alex"));

        DeveloperProjectFinder dpf = new DeveloperProjectFinder();
        dpf.findDeveloperProject(projects, developer);

        //Input
        //Projects:
        //CSO - Ivan, Anna, Lidia, Antony
        //VVaS - Mary, Ben, Max,
        //LJA - Oleg, Ivan, Alex
        //
        // Developer: Ivan

        //Output
        //CSO, LJA
    }
}
