package SolidProgramming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VideoDao {
	
	public void persist(Video video) throws SQLException {
		String url = "jdbc:mysql://192.168.160.130/Yotobe";
		Connection conn = DriverManager.getConnection(url, "Performer", "4488226600DD%!");
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO Video (Title, Time, Likes, Views) Values "
				+ "("+ video.getTitle() + "," + video.getTime() + "," + video.getLikes() + "," + video.getViews() +")";
		
		stmt.executeUpdate(sql);
	}
}
