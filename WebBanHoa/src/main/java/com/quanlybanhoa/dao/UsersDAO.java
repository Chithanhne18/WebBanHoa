package com.quanlybanhoa.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.quanlybanhoa.entity.Users;

@Transactional
@Repository
public class UsersDAO {
    @Autowired
    SessionFactory factory;

    // Hàm kiểm tra đăng nhập dành cho Thanh
    public Users checkLogin(String email, String password) {
        Session session = factory.getCurrentSession();
        String hql = "FROM Users WHERE email = :email AND password = :password AND isActive = true";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        
        List<Users> list = (List<Users>) query.list();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    // Hàm lấy thông tin người dùng theo ID
    public Users findById(int id) {
        Session session = factory.getCurrentSession();
        return (Users) session.get(Users.class, id);
    }
}