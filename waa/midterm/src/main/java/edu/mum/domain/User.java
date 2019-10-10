package edu.mum.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

public class User {

    @Size(min = 2,max = 30,message = "{Size.user.name.validation}")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Min(18)
    @Max(55)
    private Integer age;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    @Past
    private Date birthday;

    @NotEmpty
    private String role;

    @Valid
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
