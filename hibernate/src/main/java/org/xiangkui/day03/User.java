package org.xiangkui.day03;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private Integer id;
    private String name;
    private Set<Role> roles = new HashSet<>();
}
