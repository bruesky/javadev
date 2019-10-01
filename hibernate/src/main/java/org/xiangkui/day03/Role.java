package org.xiangkui.day03;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
public class Role {
    private Integer id;
    private String name;
    @EqualsAndHashCode.Exclude
    private Set<User> users = new HashSet<>();
}
