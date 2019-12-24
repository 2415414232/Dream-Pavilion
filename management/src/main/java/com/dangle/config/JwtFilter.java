package com.dangle.config;

import com.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * @author by 党桢乐 on 2019/12/22
 * 继承拦截器
 */
@Component
public class JwtFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("name")!=null) {
                return  true;
        }else {
            String authHeader = request.getHeader("Authorization");

            if (authHeader != null) {
                try {
                    Claims claims = Jwts.parser().setSigningKey("dang").parseClaimsJws(authHeader).getBody();
                    if (claims != null) {
                        if ("admin".equals(claims.get("roles"))) {
                            request.getSession().setAttribute("admin", claims);
                        } else {
                            request.getSession().setAttribute("user", claims);
                        }
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            } else {
                response.sendRedirect("http://localhost:8889/admin/login.html");
                return false;
            }

        }
    }

}
