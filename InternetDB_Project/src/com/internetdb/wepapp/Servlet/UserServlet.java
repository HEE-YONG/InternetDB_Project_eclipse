package com.internetdb.wepapp.Servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.internetdb.wepapp.Dao.UserDao;
import com.internetdb.wepapp.Dto.User;

@WebServlet("/user-servlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	addNewUser(request, response);

    }
    
    private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    	
    	String user_email = request.getParameter("user_email");
        String user_pw = request.getParameter("user_password");
        String profile_image = request.getParameter("post_picture");
        String member_introduce = request.getParameter("user_introduce");
        String user_nickname = request.getParameter("user_nickname");
        String user_location = request.getParameter("user_location");

        User user = new User(user_email, user_pw, profile_image, member_introduce, user_nickname, user_location);

        UserDao userDao = new UserDao();
        if (userDao.addNewUser(user)) {
            System.out.println("Insert User succeed");
        } else {
            System.out.println("Insert User failed");
        }

        response.sendRedirect("index.jsp");
    } 
}

