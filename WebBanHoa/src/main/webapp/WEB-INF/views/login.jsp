<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập - Tiệm Hoa Nhóm 19</title>
    <style>
        /* CSS trang trí cho form đẹp hơn */
        body { background-color: #f4f7f6; font-family: Arial, sans-serif; }
        .login-container {
            width: 350px;
            margin: 100px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        h2 { text-align: center; color: #333; margin-top: 0; }
        .form-group { margin-bottom: 15px; }
        .form-group label { font-weight: bold; color: #555; }
        .form-group input { 
            width: 100%; padding: 10px; margin-top: 5px; 
            border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; 
        }
        .btn-login { 
            width: 100%; padding: 10px; background-color: #e83e8c; 
            color: white; border: none; border-radius: 5px; cursor: pointer;
            font-size: 16px; font-weight: bold; margin-top: 10px;
        }
        .btn-login:hover { background-color: #d63384; }
        .error-msg { color: red; font-style: italic; text-align: center; display: block; margin-bottom: 15px; }
        .hint { font-size: 13px; color: #666; background: #eee; padding: 10px; border-radius: 5px; }
    </style>
</head>
<body>

    <div class="login-container">
        <h2>ĐĂNG NHẬP</h2>
        
        <span class="error-msg">${message}</span>
        
        <form action="${pageContext.request.contextPath}/customer/login" method="POST">
            
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" required value="huy@gmail.com"> 
            </div>
            
            <div class="form-group">
                <label>Mật khẩu:</label>
                <input type="password" name="password" required value="hashed_password_1">
            </div>
            
            <button type="submit" class="btn-login">Đăng nhập</button>
            
        </form>
        
        <hr style="margin: 20px 0; border: 0; border-top: 1px solid #eee;">
        
        <div class="hint">
            <b>Gợi ý Test (Dữ liệu từ Database):</b><br>
            Tài khoản: huy@gmail.com<br>
            Mật khẩu: hashed_password_1
        </div>
    </div>

</body>
</html>