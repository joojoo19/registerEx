package user;

import java.sql.Connection;
import java.sql.*;

public enum UserDAO {
	private Connection con1;



	public UserDAO() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "c##mydbms"; // mydb00
			String password = "admin"; // adminAdmin12

			// 1.드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.연결생성
			con1 = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int resgisterCheck(String userID) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM user_register WHERE userID = ?";
		try {
			pstmt = con1.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 0; // 존재하는 ID
			} else {
				return 1;  // 가입가능 ID
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1; // db오류
	}
	public int register(String userID, String userPW, String userName, String userAge, String userGender, String userEmail) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO user_register VALUES (?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con1.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			pstmt.setString(3, userName);
			pstmt.setInt(4, Integer.parseInt(userAge));
			pstmt.setString(5, userGender);
			pstmt.setString(6, userEmail);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1; // db오류
	}
}
