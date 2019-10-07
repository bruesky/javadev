package edu.mum.domain;

import edu.mum.customvalidation.Password;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {
    @Pattern(regexp="^[a-zA-Z0-9]{5}",message="length must be 5")
    private String name;
//    @Size(min=1,message="required")
    @Password
    private String pass;
    @Min(value=18, message="must be equal or greater than 18")
    @Max(value=45, message="must be equal or less than 45")
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
