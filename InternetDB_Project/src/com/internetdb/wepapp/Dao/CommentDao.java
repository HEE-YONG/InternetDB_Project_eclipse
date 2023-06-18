package com.internetdb.wepapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internetdb.wepapp.DBConnection;
import com.internetdb.wepapp.Dto.CommentReq;
import com.internetdb.wepapp.Dto.CommentRes;

public class CommentDao {
	 private Connection connection;
	    private PreparedStatement preparedStatement;
	    public ResultSet resultSet;

	    public CommentDao() {
	        DBConnection dbConnection = DBConnection.getInstance();
	        connection = dbConnection.getConnection();
	    }
	    
	    public boolean registerComment(CommentReq commentReq) {
	    	String query = "insert into Comment(post_idx, user_idx, comment_content) values (?, ?, ?)";
	    	int n = 0;
	    	
	    	try {
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, commentReq.getPost_idx());
	            preparedStatement.setInt(2, commentReq.getUser_idx());
	            preparedStatement.setString(3, commentReq.getComment());
	         
	            n = preparedStatement.executeUpdate();

	        } catch (Exception e) {
	            System.out.println("Error :" + e.getMessage());
	        }

	    	return n == 1;
	    }
	    
	    public List<CommentRes> findAllComment() {
	    	String query = "select comment_idx, post_idx, Comment.user_idx, user_nickname, comment_content from Comment join User ON Comment.user_idx = User.user_idx";
	    	List<CommentRes> commentList = new ArrayList<>();
	    	try {
	    		preparedStatement = connection.prepareStatement(query);
	    		
	    		resultSet = preparedStatement.executeQuery();
	    		
	    		while (resultSet.next()) {
	    			CommentRes comment = new CommentRes(
	    					resultSet.getInt("comment_idx"),
	    					resultSet.getInt("post_idx"),
	    					resultSet.getInt("user_idx"),
	    					resultSet.getString("user_nickname"),
	    					resultSet.getString("comment_content")
	    					);
	    			
	    			commentList.add(comment);			
	    		}
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    	return commentList;
	    }
}
