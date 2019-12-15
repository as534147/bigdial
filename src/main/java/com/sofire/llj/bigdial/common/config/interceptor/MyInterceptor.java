package com.sofire.llj.bigdial.common.config.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor  implements HandlerInterceptor {

    /**
     * 登录的过滤器
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            return true;
        }
        //未登录, 转发到登录页面
        request.setAttribute("msg", "无权限，请登录后访问！");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }
}