package com.gzu.servletjdbcdemo.entity;
import lombok.Data;

import java.util.Date;

@Data
public class Teacher {
    public int id;
    public String name;
    public String course;
    public Date birthday;
}
