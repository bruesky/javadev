package org.xkg.hellojava.collections;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable {
    private int id;
    private String  name;
    private Date dob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Student(int id,String name,String dob){
        this.id = id;
        this.name = name;
        try {
            this.dob = format.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
