package org.xkg.hellojava.collections;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class CollectionsClassExample {

    public static void main(String[]args){
        List<Integer> list = new ArrayList<Integer>();
        list.add(46);
        list.add(67);
        list.add(24);
        list.add(16);
        list.add(8);
        list.add(12);

        Integer[] intArr = {0, 100};
        Collections.addAll(list, intArr);
        System.out.println("After adding array collection value:"+list);
        System.out.println("Value of maximum element from the collection: "+Collections.max(list));
        System.out.println("Value of minimum element from the collection: "+Collections.min(list));
        Collections.sort(list,Collections.reverseOrder());
        System.out.println("After sort array collection value:"+list);



        //Properties
        Properties p=new Properties();
        p.setProperty("name","Sonoo Jaiswal");
        p.setProperty("email","sonoojaiswal");

        try {
            p.store(new FileWriter("info.properties"),"Javatpoint Properties Example");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
