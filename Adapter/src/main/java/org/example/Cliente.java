package org.example;

import java.util.*;

public class Cliente {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("A", "B", "C"));
        ListToMapAdapter<String> mapAdapter = new ListToMapAdapter<>(list);

        System.out.println("ListToMapAdapter:");
        mapAdapter.put(3, "D");
        System.out.println("Chave 2: " + mapAdapter.get(2));
        System.out.println("Contém chave 1? " + mapAdapter.containsKey(1));
        System.out.println("Valores: " + mapAdapter);

        MapToListAdapter<String> listAdapter = new MapToListAdapter<>();
        listAdapter.add("X");
        listAdapter.add("Y");
        listAdapter.add("Z");

        System.out.println("\nMapToListAdapter:");
        System.out.println("Índice 1: " + listAdapter.get(1));
        System.out.println("Contém 'X'? " + listAdapter.contains("X"));
        System.out.println("Valores: " + listAdapter);
    }
}
