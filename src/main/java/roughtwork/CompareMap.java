package roughtwork;

import java.util.*;
import java.util.stream.Collectors;

public class CompareMap {

    public static void main(String[] args) {

        List<LinkedHashMap<String ,String>> list1=new ArrayList<>();
        List<LinkedHashMap<String ,String>> list2=new ArrayList<>();
        LinkedHashMap<String,String> data1=new LinkedHashMap<>();
        LinkedHashMap<String,String> data2=new LinkedHashMap<>();


        data1.put("A","aval");
        data1.put("AA","aval");
        data1.put("B","aval");

        list1.add(data1);
        data2.put("B","aval");
        list2.add(data2);

        System.out.println("x");
        list1.forEach(l1-> System.out.println(l1));

        if (list1.size() - list2.size() < 1) {
            System.out.println( list2.stream().distinct().filter(l2 -> !list1.contains(l2)).collect(Collectors.toList()));
        } else {
            System.out.println( list1.stream().distinct().filter(l1 -> !list2.contains(l1)).collect(Collectors.toList()));
        }


    }
}
