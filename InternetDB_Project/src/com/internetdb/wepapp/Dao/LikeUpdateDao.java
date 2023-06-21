package com.internetdb.wepapp.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internetdb.wepapp.DBConnection;
import com.internetdb.wepapp.Dto.Like;

public class LikeUpdateDao {
	private Connection connection;
    private PreparedStatement preparedStatement;
    public ResultSet resultSet;

    public LikeUpdateDao() {
        DBConnection dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
    }
	
	public int updateNewLike(Like like) {
		preparedStatement = null;
		
        try {
        	String query = "update like set count = count+1 where like_idx = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, like.getLike_idx());
            return preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return -1;
    }
}
