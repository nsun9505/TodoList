package MDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class MemberDAO {
	DataSource dataSrc;
	private static String userPassUpdateQuery = "update set pw=? where id=?";
	private static String getPassQuery = "select pw from member where id=?";
	private static String deleteQuery = "delete from member where id=?";
	private static String checkQuery = "select * from member where id = ? AND pw = ?";
	private static String insertQuery = "insert into member values(?,?,?)";
	private static String idCheckQuery = "select id from member where id = ?";
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSrc = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int inserMember(String user_id, String user_pw, String user_name) {
		int ret = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(insertQuery);
			preStmt.setString(1, user_id);
			preStmt.setString(2, user_pw);
			preStmt.setString(3, user_name);
			ret = preStmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preStmt != null) preStmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}
	
	public int memberCheck(String id, String pw) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rSet = null;
		int ret = 0;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(checkQuery);
			preStmt.setString(1, id);
			preStmt.setString(2, pw);
			rSet = preStmt.executeQuery();
			if(rSet.next())
				if(id.equals(rSet.getString("id")) && pw.equals(rSet.getString("pw")))
					ret = 1;		// login success
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rSet != null) rSet.close();
				if(preStmt != null) preStmt.close();
				if(conn != null) conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}
	public int checkUserId(String user_id) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rSet = null;
		int ret = 1;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(idCheckQuery);
			preStmt.setString(1, user_id);
			rSet = preStmt.executeQuery();
			if(rSet.next()) {
				if(user_id.equals(rSet.getString("id"))) {
					ret = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rSet != null) rSet.close();
				if(preStmt != null) preStmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}
	
	public int deleteMember(String user_id, String user_pw) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rSet = null;
		int ret = 0;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(getPassQuery);
			preStmt.setString(1, user_id);
			rSet = preStmt.executeQuery();
			if(rSet.next())
				if(rSet.getString("pw").equals(user_pw))
					ret = 1;
			if(ret == 1) {
				preStmt.close();
				preStmt = conn.prepareStatement(deleteQuery);
				preStmt.setString(1, user_id);
				preStmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rSet != null) rSet.close();
				if(preStmt != null) preStmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}
	
	public int updateUserPass(String user_id, String user_pw) {
		int ret = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(userPassUpdateQuery);
			preStmt.setString(1, user_pw);
			preStmt.setString(2, user_id);
			ret = preStmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preStmt != null) preStmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}
}