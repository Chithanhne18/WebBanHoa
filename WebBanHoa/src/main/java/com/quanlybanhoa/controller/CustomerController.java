package com.quanlybanhoa.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.quanlybanhoa.dao.UsersDAO;
import com.quanlybanhoa.entity.Users;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    UsersDAO usersDAO; // Nhúng DAO vào để gọi hàm checkLogin

    // 1. Hiển thị trang đăng nhập
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "customer/login"; // Trỏ đến /WEB-INF/views/customer/login.jsp
    }

    // 2. Xử lý khi người dùng nhấn nút Đăng nhập
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(ModelMap model, HttpSession session,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password) {
        
        // Gọi hàm kiểm tra từ DAO
        Users user = usersDAO.checkLogin(email, password);
        
        if (user != null) {
            // Đăng nhập thành công: Lưu thông tin vào Session để Interceptor cho phép đi tiếp
            session.setAttribute("userLogin", user);
            return "redirect:/index"; // Chuyển về trang chủ (Bạn cần tạo thêm trang này sau)
        } else {
            // Đăng nhập thất bại
            model.addAttribute("message", "Email hoặc mật khẩu không chính xác!");
            return "customer/login";
        }
    }
}