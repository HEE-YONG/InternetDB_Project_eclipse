package com.internetdb.wepapp.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.internetdb.wepapp.DBConnection;
import com.internetdb.wepapp.Dto.Like;
import java.sql.ResultSet;
public class LikeDao {
	private Connection connection;
    private PreparedStatement preparedStatement;
    public ResultSet resultSet;

    public LikeDao() {
        DBConnection dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
    }

    public int addNewLike(Like like) {
        String query = "insert into Like(post_idx, user_idx) values (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, like.getPost_idx());
            preparedStatement.setInt(2, like.getUser_idx());

            return preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return -1;
    }
    
    public int countLike(Like like) {
    	String query = "select count(*) from Like where post_idx = ?";
    	try {
    		preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, like.getPost_idx());
            
            return preparedStatement.executeUpdate();
    	} catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
    	return -1;
    }
    
    public int deleteLike(Like like) {
    	String query = "delete from Like where post_idx = ? and user_idx = ?";
    	try {
    		preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, like.getPost_idx());
            preparedStatement.setInt(2, like.getUser_idx());

            return preparedStatement.executeUpdate();
    	} catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return -1;
    }
    
    public int checkLike(Like like) {
    	String query = "select count(*) from Like where post_idx = ? and user_idx = ?";
    	try {
    		preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, like.getPost_idx());
            preparedStatement.setInt(2, like.getUser_idx());

            return preparedStatement.executeUpdate();
    	} catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return -1;
    }
}
