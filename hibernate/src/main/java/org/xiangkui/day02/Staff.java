package org.xiangkui.day02;

import lombok.Data;

@Data
public class Staff {
    String id;
    String firstName;
    String lastName;

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
