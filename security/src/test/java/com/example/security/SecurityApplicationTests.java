package com.example.security;

import com.example.security.entity.User;
import com.example.security.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testString() {
        String bundletype = null;
        boolean b = StringUtils.equalsAny(bundletype, "10", "30", "130");
        System.out.println(b);
    }

    @Test
    public void testSelect() {
        System.out.println("=============================================================");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        System.out.println("=============================================================");
        User user = userMapper.selectById(2);
        System.out.println(user);
        System.out.println("=============================================================");
    }

    @Test
    void contextLoads() {
    String s = "952047001011\n" +
            "952047001502\n" +
            "941836000076\n" +
            "952045002776\n" +
            "952045002827\n" +
            "452041000009\n" +
            "452041000010\n" +
            "452039000007\n" +
            "452039000008\n" +
            "452037000203\n" +
            "452037000204\n" +
            "452037000189\n" +
            "452037000190\n" +
            "452037000121\n" +
            "452037000122\n" +
            "452037000123\n" +
            "452037000124\n" +
            "452035000029\n" +
            "452035000030\n" +
            "452033000035\n" +
            "452033000036\n" +
            "452028000009\n" +
            "452028000010\n" +
            "452023000015\n" +
            "452023000016\n" +
            "452024000115\n" +
            "452024000116\n" +
            "452017000061\n" +
            "452017000062\n";
        String[] split = s.split("\n");
        for (String s1 : split) {
            System.out.println(String.format("'%s',", s1));
        }
    }

}
