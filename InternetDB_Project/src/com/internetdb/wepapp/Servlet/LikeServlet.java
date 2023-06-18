package com.internetdb.wepapp.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.internetdb.wepapp.Dao.LikeDao;
import com.internetdb.wepapp.Dto.Like;
import com.internetdb.wepapp.Dto.PostLoginReq;
import com.internetdb.wepapp.Dto.PostLoginRes;
import com.internetdb.wepapp.Dao.PostDao;
import com.internetdb.wepapp.Dao.UserDao;

@WebServlet("/like-servlet")
public class LikeServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");

        switch (action) {
            case "addNewLike":
                addNewLike(request, response);
                break;
            default:
                break;
        }
    }
	
    private void addNewLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int like_idx = Integer.parseInt(request.getParameter("like_idx"));
    	int post_idx = Integer.parseInt(request.getParameter("post_idx"));
    	int user_idx = Integer.parseInt(request.getParameter("user_idx"));
    	
        HttpSession session = request.getSession();
        // 세션 확인
        String userIdx = null;
        if(session.getAttribute("user_idx") != null) {
        	userIdx = (String) session.getAttribute("user_idx");
        } else {
            // 로그인 하지 않고 좋아요 시,
            PrintWriter out = response.getWriter();
    		out.println("<script>alert('로그인을 해주세요.'); location.href='login.jsp'; </script>");
    		out.close();
    		return;
        }
        request.setCharacterEncoding("UTF-8");

    	String likeIdx = null;
    	if(request.getParameter("like_idx") != null) {
    		likeIdx = (String) request.getParameter("like_idx");
    	}
    	Like addNewLike = new Like(post_idx, user_idx);
    	LikeDao likeDao = new LikeDao();
    	
    	int result = addNewLike;
    	if (result == 1) {
    		result = like.addNewLike(like_idx);
    		if (result == 1) { // 해당 게시글 추천 완료
    			PrintWriter out = response.getWriter();
    			out.println("<script>alert('추천이 완료되었습니다.'); location.href='index.jsp'; </script>");
    			return;
    		} else {
    			PrintWriter out = response.getWriter();
    			out.println("<script>alert('오류가 발생했습니다.'); history.back(); </script>");
    			out.close();
    			return;
    		}
    	} else {
    		PrintWriter out = response.getWriter();
    		out.println("<script>alert('이미 추천을 누른 글입니다.'); history.back(); </script>");
    		out.close();
    		return;
    	}
    }
}