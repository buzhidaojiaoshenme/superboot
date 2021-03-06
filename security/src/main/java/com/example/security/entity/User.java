package com.example.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_user", schema = "public")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}