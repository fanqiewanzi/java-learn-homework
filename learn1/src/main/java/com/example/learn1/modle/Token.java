package com.example.learn1.modle;

import lombok.Data;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Data
public class Token {
    private long id;
    private long userId;
    private Date buildTime;
    private String token;
    private int statue;
    private Date deadTime;

    public static  String generateToken(String username) {
        StringBuilder token = new StringBuilder();
        //加token:
        token.append("token:");
        //加加密的用户名
        token.append(username+ "-");
        //加时间
        token.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "-");
        //加六位随机数111111-999999
        token.append(new Random().nextInt((999999 - 111111 + 1)) + 111111);
        System.out.println("token=>" + token.toString());
        return token.toString();
    }

}
