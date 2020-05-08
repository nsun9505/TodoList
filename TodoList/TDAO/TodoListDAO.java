package TDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import TDTO.TodoListDTO;

public class TodoListDAO {
	DataSource dataSrc;
	private static String deleteAllQuery = "delete from todoList where ownnerId=?";
	private static String deleteTaskByStatusQuery = "delete from todoList where ownnerId=? AND taskStatus=?";
	private static String deleteQuery = "delete from todoList where ownnerId=? AND taskId=?";
	private static String updateQuery = "update todoList set task=?, taskStatus=?, deadline=? where ownnerId=? AND taskId=?";
	private static String getListQuery = "select * from todoList where ownnerId = ?";
	private static String insertQuery = "insert into todoList values(?,?,?,?,tId.NEXTVAL)";
	public TodoListDAO() {
		try {
			Context context = new InitialContext();
			dataSrc = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertTask(String ownnerId, String task, int taskStatus,String deadline) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(insertQuery);
			preStmt.setString(1, ownnerId);
			preStmt.setString(2, task);
			preStmt.setInt(3, taskStatus);
			preStmt.setString(4,deadline);
			preStmt.executeUpdate();
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
	}
	
	public ArrayList<TodoListDTO> getListById(String id){
		ArrayList<TodoListDTO> dtos = null;
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rSet = null;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(getListQuery);
			preStmt.setString(1, id);
			rSet = preStmt.executeQuery();
			dtos = new ArrayList<TodoListDTO>();
			while(rSet.next()) {
				String task = rSet.getString("task");
				int taskStatus = rSet.getInt("taskStatus");
				String deadline = rSet.getString("deadline");
				int tId = rSet.getInt("taskId");
				dtos.add(new TodoListDTO(id, task, taskStatus, deadline, tId));
			}
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
		return dtos;
	}
	public int updateTodo(String ownnerId, String task, int taskStatus, String deadline, int taskId) {
		int ret = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(updateQuery);
			preStmt.setString(1, task);
			preStmt.setInt(2, taskStatus);
			preStmt.setString(3, deadline);
			preStmt.setString(4, ownnerId);
			preStmt.setInt(5, taskId);
			ret = preStmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preStmt != null) preStmt.close();
				if(conn != null) conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}
	
	public int deleteTask(String ownnerId, int taskId) {
		int ret = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(deleteQuery);
			preStmt.setString(1, ownnerId);
			preStmt.setInt(2, taskId);
			ret = preStmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preStmt != null) preStmt.close();
				if(conn != null) conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}
	
	public int deleteAllTask(String id) {
		int ret = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(deleteAllQuery);
			preStmt.setString(1, id);
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
	
	public int deleteTaskByStatus(String id, int status) {
		int ret = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			conn = dataSrc.getConnection();
			preStmt = conn.prepareStatement(deleteTaskByStatusQuery);
			preStmt.setString(1, id);
			preStmt.setInt(2, status);
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
