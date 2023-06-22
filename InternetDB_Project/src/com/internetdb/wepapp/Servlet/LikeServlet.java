package com.internetdb.wepapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import com.internetdb.wepapp.Dao.LikeDao;
import com.internetdb.wepapp.Dto.LikeReq;

@WebServlet("/like-servlet")
public class LikeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LikeServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	addNewLike(request, response);
    }
	
    private void addNewLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int post_idx = Integer.parseInt(request.getParameter("post_idx"));
    	int user_idx = Integer.parseInt(request.getParameter("user_idx"));
   

    	LikeReq likeReq = new LikeReq(post_idx, user_idx);
    	LikeDao likeDao = new LikeDao();
    	
    	if(likeDao.addNewLike(likeReq)) {
    		response.setContentType("text/html");
    		response.getWriter().println("insert like success");
    	} else {
    		System.out.println("Insert Like failed");
    	}
    }
}