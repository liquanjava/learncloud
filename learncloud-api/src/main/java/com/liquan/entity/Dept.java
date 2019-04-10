package com.liquan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptId;
    private String deptName;
    private String dbSource;


    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptId(11l).setDeptName("研发部").setDbSource("一库");
        System.out.println(dept);
    }
}
