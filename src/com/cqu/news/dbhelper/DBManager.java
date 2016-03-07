package com.cqu.news.dbhelper;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;
 
/**
 * @author xiongxianren
 * @desciption TODO
 */
public class DBManager {
	
	private DBManager(){
		try {
			//数据库连接池配置文件
			JAXPConfigurator.configure(DBPool.getDBPool().getPoolPath(), false);
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @decription:TODO
	 * @parm:@param poolName
	 * @return:Connection
	 * @throws:SQLException
	 */
	public Connection getConnection(String poolName) throws SQLException {
		return DriverManager.getConnection(poolName);
	}
	

	/**
	 * @author xiongxianren
	 * @desciption 内部静态类实现单例模式
	 */
	private static class DBManagerDao {
		private static DBManager dbManager = new DBManager();
	}
	
	/**
	 * @decription:TODO
	 * @parm:@return
	 * @return:DBManager
	 * @throws:
	 */
	public static DBManager getDBManager() {
		return DBManagerDao.dbManager;
	}

	/**
	 * @decription:测试
	 * @parm:@param args
	 * @return:void
	 * @throws:
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub  

	}

}

