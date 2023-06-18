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
        String query = "insert into Like(like_idx, post_idx, user_idx) values (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, like.getLike_idx());
            preparedStatement.setInt(2, like.getPost_idx());
            preparedStatement.setInt(3, like.getUser_idx());

            return preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return -1;
    }
}
