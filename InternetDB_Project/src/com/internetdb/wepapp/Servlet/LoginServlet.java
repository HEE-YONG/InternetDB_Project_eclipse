package com.internetdb.wepapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.internetdb.wepapp.Dao.UserDao;
import com.internetdb.wepapp.Dto.PostLoginReq;
import com.internetdb.wepapp.Dto.PostLoginRes;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Login(request, response);
	}
	
	private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_email = request.getParameter("user_email");
		String user_pw = request.getParameter("user_pw");
	    // DB연결에 필요한 변수 선언      

		PostLoginReq postLoginReq = new PostLoginReq(user_email, user_pw);
		
        UserDao userDao = new UserDao();
        
        PostLoginRes loginResult = userDao.loginCheck(postLoginReq);
        
        HttpSession session = request.getSession(); // 세션 가져오기
        
        if (loginResult != null) {
            session.setAttribute("user_email", user_email);
            session.setAttribute("user_idx", loginResult.getUser_idx());
            session.setAttribute("user_nickname", loginResult.getUser_nickname());
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {
            // 로그인 실패 시 경고창 띄우기
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인에 실패했습니다. 다시 시도해주세요.'); location.href='login.jsp';</script>");
            out.flush();
            
            //RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            //dispatcher.forward(request, response);
            return;
        }


        
    }

}
