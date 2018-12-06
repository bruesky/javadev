package org.xkg.hellojava.collections;

import java.util.*;

enum Days {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class MapExample {

    public static void main(String[]args){
        Map map1 = new HashMap();
        Map<Integer,String> map = new HashMap<>();
        map.put(100,"Amit");
        map.put(102,"Rahul");
        map.put(101,"Vijay");
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.println(me.getKey()+" "+ me.getValue());
        }

        for (Map.Entry me : map.entrySet()){
            System.out.println(me.getKey()+" "+ me.getValue());
        }

        //Returns a Set view of the mappings contained in this map
        map.entrySet()
                //Returns a sequential Stream with this collection as its source
                .stream()
                //Sorted according to the provided Comparator
                .sorted(Map.Entry.comparingByKey())
                //Performs an action for each element of this stream
                .forEach(System.out::println);
        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<Integer, String>();
        map2.put(101,"Vijay");
        map2.put(100,"Amit");
        map2.put(102,"Rahul");

        for (Map.Entry me : map2.entrySet()){
            System.out.println(me.getKey()+" "+ me.getValue());
        }

        Set<Days> set1 = EnumSet.allOf(Days.class);
        System.out.println("Week Days:"+set1);

        EnumMap<Days, String> enumMap = new EnumMap<Days, String>(Days.class);
        enumMap.put(Days.MONDAY, "1");
        enumMap.put(Days.TUESDAY, "2");
        enumMap.put(Days.WEDNESDAY, "3");
        enumMap.put(Days.THURSDAY, "4");
        // print the map
        for(Map.Entry m:enumMap.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }


    }


}
