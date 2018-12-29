package org.xkg.hellojava.java8;

import java.time.LocalDateTime;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/29
 */
public class DateTimeExample {

    public static void main(String[]args){
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);
    }


}
