package com.internetdb.wepapp.Dao;

import com.internetdb.wepapp.DBConnection;
import com.internetdb.wepapp.Dto.FeedRes;
import com.internetdb.wepapp.Dto.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public ResultSet resultSet;

    public PostDao() {
        DBConnection dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
    }

    public boolean addNewPost(Post post) {
        String query = "insert into Post(user_idx, post_title, post_picture, post_location, animal, post_content) values (?, ?, ?, ?, ?, ?)";
        int n = 0;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, post.getPost_title());
            preparedStatement.setString(3, post.getPost_picture());
            preparedStatement.setString(4, post.getPost_location());
            preparedStatement.setString(5, post.getAnimal());
            preparedStatement.setString(6, post.getPost_content());
         
            n = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return n == 1;
    }
    
    public boolean deletePost(int idx) {
        String query = "delete from Post where post_idx = ?";
        int n = 0;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idx);

            n = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return n == 1;
    }

    public List<FeedRes> filterPost(String animal, String region) {
        String query = "select * from Post join User ON Post.user_idx = User.user_idx";
        List<FeedRes> filteredPosts = new ArrayList<>();

        try {
            if (!animal.equals("") && !animal.equals("all") && !region.equals("") && !region.equals("whole region")) {
            	query += " where animal = ? and post_location = ?";
            } else if (!animal.equals("") && !animal.equals("all")) {
            	query += " where animal = ?";
            } else if (!region.equals("") && !region.equals("whole region")) {
            	query += " where post_location = ?";
            }

            preparedStatement = connection.prepareStatement(query);

            if (!animal.equals("") && !animal.equals("all") && !region.equals("") && !region.equals("whole region")) {
            	preparedStatement.setString(1, animal);
            	preparedStatement.setString(2, region);
            } else if (!animal.equals("") && !animal.equals("all")) {
            	preparedStatement.setString(1, animal);
            } else if (!region.equals("") && !region.equals("whole region")) {
            	preparedStatement.setString(1, region);
            }

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                FeedRes feedRes = new FeedRes(
                        resultSet.getInt("post_idx"),
                        resultSet.getInt("user_idx"),
                        resultSet.getString("user_nickname"),
                        resultSet.getString("post_title"),
                        resultSet.getString("post_picture"),
                        resultSet.getString("post_location"),
                        resultSet.getString("animal"),
                        resultSet.getString("post_content")
                );
                filteredPosts.add(feedRes);
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return filteredPosts;
    }

    public String findUserRegion(int user_idx) {
    	String query = "select user_location from User where user_idx = ?";
    	String user_location = null;
    	try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user_idx);
			
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			user_location = resultSet.getString("user_location");
			
		} catch (Exception e) {
			System.out.println(e);
		}
    	
    	return user_location;
    }
    
    public List<FeedRes> myPost(int user_idx) {
        String query = "select * from Post join User ON Post.user_idx = User.user_idx where User.user_idx = ?";
        List<FeedRes> myPosts = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user_idx);
            
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                FeedRes feedRes = new FeedRes(
                        resultSet.getInt("post_idx"),
                        resultSet.getInt("user_idx"),
                        resultSet.getString("user_nickname"),
                        resultSet.getString("post_title"),
                        resultSet.getString("post_picture"),
                        resultSet.getString("post_location"),
                        resultSet.getString("animal"),
                        resultSet.getString("post_content")
                );
                myPosts.add(feedRes);
            }
            
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return myPosts;
    }
//    private void closeResources() {
//        try {
//            if (resultSet != null) resultSet.close();
//            if (preparedStatement != null) preparedStatement.close();
//            if (connection != null) connection.close();
//        } catch (SQLException e) {
//            System.out.println("Error while closing resources: " + e.getMessage());
//        }
//    }
}
