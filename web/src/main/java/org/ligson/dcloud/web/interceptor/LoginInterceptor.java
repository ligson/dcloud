package org.ligson.dcloud.web.interceptor;

import org.ligson.dcloud.web.controller.UserController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by ligson on 2015/7/16.
 * 登陆检查
 */
class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            String methodName = method.getName();
            Object bean = handlerMethod.getBean();
            if (bean instanceof UserController) {
                Object object = request.getSession().getAttribute("user");
                if (object == null) {
                    request.setAttribute("success", false);
                    request.setAttribute("msg", "请登录!");
                    request.getRequestDispatcher("/index/index").forward(request, response);
                    return false;
                }
            }
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
