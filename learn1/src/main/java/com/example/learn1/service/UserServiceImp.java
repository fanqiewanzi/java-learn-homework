package com.example.learn1.service;

import com.example.learn1.Response;
import com.example.learn1.dao.TokenDao;
import com.example.learn1.dao.UserDao;
import com.example.learn1.modle.Token;
import com.example.learn1.modle.User;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.annotation.Resource;
import java.util.*;

@Service("UserServiceImp")
public class UserServiceImp implements UserService{

    @Resource
    UserDao userDao;
    TokenDao tokenDao;
    @Override
    public Response Rigist() {
        return Response.SUCCESS;
    }

    @Override
    public Map<String,Object> Login(User user) {
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isEmpty(user.getPhoneNumber())){
            map.put("msg","用户名不能为空");
            return map;
        }

        if(StringUtils.isEmpty(user.getPassword())){
            map.put("msg","密码不能为空");
            return map;
        }

        User user1 = userDao.getUser(user.getPhoneNumber());
        if (user1 == null){
            map.put("msg","用户名不存在");
            return map;
        }

        if (!(user.getPassword().equals(user1.getPassword()))) {
            map.put("msg", "密码错误");
            return map;
        }

        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);
        return map;

    }
    private String  SECRET = "DyoonSecret_0581";
    private void getJwtToken(){
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        //有10天有效期
        nowTime.add(Calendar.DATE, 10);
        Date expiresDate = nowTime.getTime();
        Claims claims = Jwts.claims();
        claims.put("name","cy");
        claims.put("userId", "222");
        claims.setAudience("cy");
        claims.setIssuer("cy");
        String token = Jwts.builder().setClaims(claims).setExpiration(expiresDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

    }
}
