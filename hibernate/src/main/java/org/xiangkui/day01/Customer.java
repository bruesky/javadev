package org.xiangkui.day01;

import lombok.Data;

@Data
public class Customer {
    private long  id;
    private String name;
    private String phone;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
