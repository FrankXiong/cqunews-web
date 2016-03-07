package com.cqu.news.dbhelper;  

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
  
/**
 * @author:xiongxianren
 * @description:TODO
 */
public class DBServer {
	private DBOperation dbOperation;
	
	public DBServer(String poolName) {
		dbOperation = new DBOperation(poolName);
	}
	
	/**
	 * @Author:xiongxianren  
	 * @Description: 关闭数据库连接
	 */
	public void close() {
		dbOperation.close();
	}
	
	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @Author:xiongxianren  
	 * @Description: 数据库插入操作
	 */
	public int insert(String sql) throws SQLException {
		return dbOperation.executeUpdate(sql);
	}
	
	/**
	 * @param tableName
	 * @param columns
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @Author:xiongxianren  
	 * @Description: 数据库插入操作
	 */
	public int insert(String tableName, String columns, HashMap<Integer, Object> params) throws SQLException, ClassNotFoundException {
		String sql = insertSql(tableName, columns);
		return dbOperation.executeUpdate(sql, params);
	}
	
	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @Author:xiongxianren  
	 * @Description: 数据库删除操作
	 */
	public int delete(String sql) throws SQLException {
		return dbOperation.executeUpdate(sql);
	}
	
	/**
	 * @param tableName
	 * @param condition
	 * @return
	 * @throws SQLException
	 * @Author:xiongxianren  
	 * @Description: 数据库删除操作
	 */
	public int delete(String tableName, String condition) throws SQLException {
		if (null == tableName) {
			return 0;
		}
		String sql = "delete from " + tableName + " " + condition;
		return dbOperation.executeUpdate(sql);
	}
	
	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @Author:xiongxianren  
	 * @Description: 数据库更新操作
	 */
	public int update(String sql) throws SQLException {
		return dbOperation.executeUpdate(sql);
	}
	
	/**
	 * @param tableName
	 * @param columns
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @Author:xiongxianren  
	 * @Description: 数据库更新操作
	 */
	public int update(String tableName, String columns, String condition, HashMap<Integer, Object> params) throws SQLException, ClassNotFoundException {
		String sql = updateSql(tableName, columns, condition);
		return dbOperation.executeUpdate(sql, params);
	}
	
	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @Author:xiongxianren  
	 * @Description: 数据库查询操作 
	 */
	public ResultSet select(String sql) throws SQLException {
		return dbOperation.executeQuery(sql);
	}
	
	/**
	 * @param tableName
	 * @param columns
	 * @param condition
	 * @return
	 * @throws SQLException
	 * @Author:xiongxianren  
	 * @Description: 数据库查询操作
	 */
	public ResultSet select(String tableName, String columns, String condition) throws SQLException {
		String sql = "select " + columns + " from " + tableName + " " + condition;
		return dbOperation.executeQuery(sql);
	}
	
	/**
	 * @param tableName
	 * @param columns
	 * @param condition
	 * @return
	 * @Author:xiongxianren  
	 * @Description: 组装 update sql eg: update tableName set column1=?,column2=? condition 
	 */
	private String updateSql(String tableName, String columns, String condition) {
		if (tableName == null || columns == null) {
			return "";
		}
		String[] column = columns.split(",");
		StringBuilder sb = new StringBuilder();
		sb.append("update ");
		sb.append(tableName);
		sb.append(" set ");
		sb.append(column[0]);
		sb.append("=?");
		for (int i = 1; i < column.length; i++) {
			sb.append(", ");
			sb.append(column[i]);
			sb.append("=?");
		}
		sb.append(" ");
		sb.append(condition);
		return sb.toString();
	}
	
	/**
	 * @param tableName
	 * @param columns
	 * @return
	 * @Author:xiongxianren  
	 * @Description: 组装 insert sql 
	 */
	private String insertSql(String tableName, String columns) {
		if (tableName == null || columns == null) {
			return "";
		}
		int n = columns.split(",").length;
		StringBuilder sb = new StringBuilder("");
		sb.append("insert into ");
		sb.append(tableName);
		sb.append(" (");
		sb.append(columns);
		sb.append(") values (?");
		for (int i = 1; i < n; i++) {
			sb.append(",?");
		}
		sb.append(")");
		return sb.toString();
	}

	/**  
	 * @param args
	 * @Author:xiongxianren  
	 * @Description:  
	 */
	public static void main(String[] args) {
		DBServer op = new DBServer("proxool.cqunews"); 
		try {
			op.select("select * from detail");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
