package org.xkg.hellojava.datastructures;

import java.text.SimpleDateFormat;

public class JavaDateExample {
    public static void main(String[] args){
        java.util.Date date=new java.util.Date();
        System.out.println(date);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= formatter.format(date);

        System.out.println(strDate);
    }
}
