package org.xkg.hellojava.collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListExample {
    public static void main(String[]args){
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");

        //Traversing list through Iterator
        System.out.println("Traversing list through Iterator");
        Iterator iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println("Traversing list through for-each loop");

        for (String obj:list)
            System.out.println(obj);

        System.out.println("Traversing list through ListIterator");
        ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious())
            System.out.println(listIterator.previous());

        System.out.println("Traversing list through for loop:");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Traversing list through forEach() method:");
        list.forEach(obj->{
            System.out.println(obj);
        });

        System.out.println("Traversing list through forEachRemaining() method:");
        iterator.forEachRemaining(obj->{
            System.out.println(obj);
        });

        //Creating user-defined class objects
        Student s1=new Student(101,"Sonoo","12/04/1990");
        Student s2=new Student(102,"Ravi","13/05/1991");
        Student s3=new Student(103,"Hanumat","16/09/1988");

        //creating arraylist
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(s1);//adding Student class object
        al.add(s2);
        al.add(s3);
        //Getting Iterator
        Iterator itr=al.iterator();
        //traversing elements of ArrayList object
        while(itr.hasNext()){
            Student st=(Student)itr.next();
            System.out.println(st.getId()+" "+st.getName()+" "+st.getDob());
        }


        try
        {
            //Serialization
            FileOutputStream fos=new FileOutputStream("file");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(al);
            fos.close();
            oos.close();
            //Deserialization
            FileInputStream fis=new FileInputStream("file");
            ObjectInputStream ois=new ObjectInputStream(fis);
            ArrayList tempList = (ArrayList)ois.readObject();
            System.out.println(tempList);
        }catch(Exception e)
        {
            System.out.println(e);
        }


    }


}
