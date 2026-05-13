package com.quanlybanhoa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // Kiểm tra xem khách đã đăng nhập chưa (có thông tin user trong session không)
        if(session.getAttribute("userLogin") == null) {
            // Nếu chưa, đuổi về trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/customer/login");
            return false;
        }
        return true;
    }
}