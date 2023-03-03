package mysql.sec12;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionExample {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/thisisjava",
					"root",
					"1234"
			);
			
			String sql = "SELECT user_login(?,?)";
			
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "java");
			cstmt.setString(2, "12345");
			
			ResultSet rs = cstmt.executeQuery();
			
			int res;
			if(rs.next()) {
				res = rs.getInt(1);
			} else {
				System.out.println("에러");
				throw new Exception("아이디 및 비번이 맞지 않습니다");
			}
			
			String message = switch(res) {
			case 0 -> "로그인 성공";
			case 1 -> "비밀번호가 틀림";
			default -> "아이디가 존재하지 않음";
			};
			
			System.out.println(message);
			
			cstmt.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
 
	cstmt.setString(1, "java");    // 로그인 성공
	cstmt.setString(2, "12345");

	cstmt.setString(1, "java");    // 비밀번호가 틀림
	cstmt.setString(2, "123451");

	cstmt.setString(1, "java1");   // 아이디가 존재하지 않음
	cstmt.setString(2, "12345");
