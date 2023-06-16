package com.internetdb.wepapp.Servlet;

import com.internetdb.wepapp.Dao.PostDao;
import com.internetdb.wepapp.Dto.FeedRes;
import com.internetdb.wepapp.Dto.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/post-servlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

        switch (action) {
            case "addNewPost":
                addNewPost(request, response);
                break;
            case "filter":
                filter(request, response);
                break;
            case "deletePost":
                deletePost(request, response);
                break;
            default:
                break;
        }
	}

	
	private void addNewPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("post_title");
        String picture = request.getParameter("post_picture");
        String location = request.getParameter("post_location");
        String animal = request.getParameter("animal");
        String content = request.getParameter("post_content");
        
        Post post = new Post(3, title, picture, location, animal, content);

        PostDao postDao = new PostDao();
        if (postDao.addNewPost(post)) {
            System.out.println("Insert Post succeed");
        } else {
            System.out.println("Insert Post failed");
        }

        response.sendRedirect("index.jsp");
    }
	
	private void deletePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int post_idx = Integer.parseInt(request.getParameter("post_idx"));

        PostDao postDao = new PostDao();
        postDao.deletePost(post_idx);

        response.sendRedirect("mypage.jsp");
    }

    private void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String animal = request.getParameter("animal");
        String region = request.getParameter("region");
        String user_idx = request.getParameter("user_idx");
        
        PostDao postDao = new PostDao();
        List<FeedRes> filteredPosts;
        
        if (user_idx == null) {
        	filteredPosts = postDao.filterPost(animal, "");
        } else {
        	String user_region = postDao.findUserRegion(Integer.valueOf(user_idx));
        	if (region.equals("whole region")) {
        		filteredPosts = postDao.filterPost(animal, region);
        	} else {
        		filteredPosts = postDao.filterPost(animal, user_region);
        	}
        }

        request.setAttribute("filteredPosts", filteredPosts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}



