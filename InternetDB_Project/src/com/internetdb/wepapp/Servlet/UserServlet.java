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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");

        switch (action) {
            case "addNewUser":
                addNewUser(request, response);
                break;
            default:
                break;
        }
    }
    
    private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int user_idx = Integer.parseInt(request.getParameter("user_idx"));
        String user_email = request.getParameter("user_email");
        String user_pw = request.getParameter("user_pw");
        String profile_image = request.getParameter("profile_image");
        String member_introduce = request.getParameter("member_introduce");
        String user_nickname = request.getParameter("user_nickname");

        User user = new User(user_idx, user_email, user_pw, profile_image, member_introduce, user_nickname);

        UserDao userDao = new UserDao();
        if (userDao.addNewUser(user)) {
            System.out.println("Insert User succeed");
        } else {
            System.out.println("Insert User failed");
        }

        response.sendRedirect("index.jsp");
    } 
}

