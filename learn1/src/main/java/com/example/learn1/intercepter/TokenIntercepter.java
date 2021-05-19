package com.example.learn1.intercepter;

import com.example.learn1.dao.TokenDao;
import com.example.learn1.dao.UserDao;
import com.example.learn1.modle.HostHolder;
import com.example.learn1.modle.Token;
import com.example.learn1.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 拦截器
 * @ 用来判断用户的
 *1. 当preHandle方法返回false时，从当前拦截器往回执行所有拦截器的afterCompletion方法，再退出拦截器链。也就是说，请求不继续往下传了，直接沿着来的链往回跑。
 2.当preHandle方法全为true时，执行下一个拦截器,直到所有拦截器执行完。再运行被拦截的Controller。然后进入拦截器链，运
 行所有拦截器的postHandle方法,完后从最后一个拦截器往回执行所有拦截器的afterCompletion方法.
 */

//@component （把普通pojo实例化到spring容器中，相当于配置文件中的
@Component
public class TokenIntercepter implements HandlerInterceptor{

    @Autowired
    TokenDao tokenDao;
    @Autowired
    UserDao userDao;

    @Autowired
    HostHolder hostHolder;

    //判断然后进行用户拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tickets = null;
        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                if(cookie.getName().equals("ticket")){
                    tickets = cookie.getValue();
                    break;
                }
            }
        }

        if(tickets != null ){
            Token token  = tokenDao.findTokenByToken(tickets);
            if(token == null || token.getDeadTime().before(new Date()) || token.getStatue() != 0){
                return true;
            }

            User user = userDao.findById(token.getUserId());
            hostHolder.setUser(user);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //就是为了能够在渲染之前所有的freemaker模板能够访问这个对象user，就是在所有的controller渲染之前将这个user加进去
        if(modelAndView != null){
            //这个其实就和model.addAttribute一样的功能，就是把这个变量与前端视图进行交互 //就是与header.html页面的user对应
            modelAndView.addObject("user",hostHolder.getUser());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();   //当执行完成之后呢需要将变量清空
    }
}