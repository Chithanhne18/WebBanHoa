package com.quanlybanhoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users") // Ánh xạ vào bảng Users trong SQL
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID; // Khóa chính

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "PasswordHash")
    private String password;

    @Column(name = "Role")
    private String role; // Admin, Staff, Customer

    @Column(name = "IsActive")
    private boolean isActive;

    // Các hàm Getter và Setter (Bắt buộc phải có để Hibernate hoạt động)
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }
}