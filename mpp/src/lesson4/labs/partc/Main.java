package lesson4.labs.partc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[]args){
        List<Order> list = new ArrayList<>();
        list.add(new Order("100", LocalDate.of(2018,1,1),200));
        list.add(new Order("101", LocalDate.of(2018,1,10),100));
        Commissioned cm = new Commissioned("123",0.8,500,list);
        Employee[] emp = {new Salaried("121",4000),new Hourly("122",15.67,20),cm};
        for (Employee e:
             emp) {
            e.print(2,2018);
        }

    }

}
