package org.xiangkui.day03;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Relative {
    private Integer id;
    private String name;
    //外键
    @EqualsAndHashCode.Exclude
    private Client client;
}
