package com.internetdb.wepapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internetdb.wepapp.DBConnection;
import com.internetdb.wepapp.Dto.FeedRes;
import com.internetdb.wepapp.Dto.PostLoginReq;
import com.internetdb.wepapp.Dto.PostLoginRes;
<<<<<<< HEAD
import com.internetdb.wepapp.Dto.User;
=======
import com.internetdb.wepapp.Dto.UserRes;
>>>>>>> branch 'main' of https://github.com/IndigoJSilver/InternetDB_Project.git

public class UserDao {
	private Connection connection;
    private PreparedStatement preparedStatement;
    public ResultSet resultSet;

    public UserDao() {
        DBConnection dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
    }
    
    public boolean addNewUser(User user) {
        String query = "insert into User(user_idx, user_email, user_pw, profile_image, member_introduce, user_nickname) values (?, ?, ?, ?, ?, ?)";
        int n = 0;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUser_idx());
            preparedStatement.setString(2, user.getUser_email());
            preparedStatement.setString(3, user.getUser_pw());
            preparedStatement.setString(4, user.getProfile_image());
            preparedStatement.setString(5, user.getMember_introduce());
            preparedStatement.setString(6, user.getUser_nickname());

            n = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return n == 1;
    }
    
    public PostLoginRes loginCheck(PostLoginReq postLoginReq) {
        String query = "select * from User where user_email = ? and user_pw = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, postLoginReq.getUser_email());
            preparedStatement.setString(2, postLoginReq.getUser_pw());
         
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int user_idx = resultSet.getInt("user_idx");
                String user_nickname = resultSet.getString("user_nickname");
                String user_email = resultSet.getString("user_email");
                String profile_image = resultSet.getString("profile_image");
                String member_introduce = resultSet.getString("member_introduce");
                
                return new PostLoginRes(user_idx, user_nickname, user_email, profile_image, member_introduce);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
//        finally {
//            try {
//                if (connection != null) connection.close();
//                if (preparedStatement != null) preparedStatement.close();
//                if (resultSet != null) resultSet.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        
        return null; // 로그인 실패 시 null 반환
    }
    
    public UserRes myInformation(int idx) {
        String query = "select * from User where User.user_idx = ?";
        

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idx);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int user_idx = resultSet.getInt("user_idx");
                String user_nickname = resultSet.getString("user_nickname");
                String user_email = resultSet.getString("user_email");
                String profile_image = resultSet.getString("profile_image");
                String member_introduce = resultSet.getString("member_introduce");
                String user_location = resultSet.getString("user_location");
                
                return new UserRes(user_idx, user_nickname, user_email, profile_image, member_introduce, user_location);
            }
            
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return null;
    }


}
