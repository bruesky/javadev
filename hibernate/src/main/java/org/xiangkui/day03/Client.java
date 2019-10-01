package org.xiangkui.day03;

import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
public class Client {
    private Integer id;
    private String name;
    private Set<Relative> relatives = new HashSet<>();
}
