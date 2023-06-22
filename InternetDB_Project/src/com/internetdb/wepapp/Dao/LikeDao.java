package com.internetdb.wepapp.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.internetdb.wepapp.DBConnection;
import com.internetdb.wepapp.Dto.LikeReq;
import com.internetdb.wepapp.Dto.LikeRes;
import java.sql.ResultSet;
import java.util.*;

public class LikeDao {
	private Connection connection;
    private PreparedStatement preparedStatement;
    public ResultSet resultSet;

    public LikeDao() {
        DBConnection dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
    }

    public boolean addNewLike(LikeReq likeReq) {
        String query = "insert into Like(post_idx, user_idx) values (?, ?)";
        int n = 0;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, likeReq.getPost_idx());
            preparedStatement.setInt(2, likeReq.getUser_idx());

            n = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return n == 1;
    }
    
    public List<LikeRes> countLike() {
    	String query = "select post_idx, count(*) from `Like` group by post_idx";
    	List<LikeRes> likeList = new ArrayList<>();
    	try {
    		preparedStatement = connection.prepareStatement(query);
            
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	likeList.add(new LikeRes(
            			resultSet.getInt("post_idx"),
            			resultSet.getInt("count(*)")
            			));
            }
    	} catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
    	return likeList;
    }
}
