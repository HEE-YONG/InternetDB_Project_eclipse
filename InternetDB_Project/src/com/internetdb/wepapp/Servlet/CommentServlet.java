package com.internetdb.wepapp.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetdb.wepapp.Dao.CommentDao;
import com.internetdb.wepapp.Dto.CommentReq;


@WebServlet("/comment-servlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		switch (action) {
		case "registerComment":
			registerComment(request, response);
			break;
		}
	}
	
	public void registerComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_idx = Integer.valueOf(request.getParameter("user_idx"));
		int post_idx = Integer.valueOf(request.getParameter("post_idx"));
		String comment = request.getParameter("comment");
		
		CommentReq commentReq = new CommentReq(user_idx, post_idx, comment);
		
		CommentDao commentDao = new CommentDao();
		
		if (commentDao.registerComment(commentReq)) {
			System.out.println("Insert Comment succeed");
		} else {
			System.out.println("Insert Comment failed");
		}
		
		response.sendRedirect("index.jsp");
	}
}
