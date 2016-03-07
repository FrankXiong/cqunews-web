package com.cqu.news.dbhelper;  

import com.cqu.news.util.ClassUtil;


/**
 * @author xiongxianren
 * @desciption TODO
 */
public class DBPool {
	private String poolPath;//数据库连接池的配置文件路径
	
	private DBPool() {
	}
		
	public static DBPool getDBPool() {
		return DBPoolDao.dbPool;
	}

	private static class DBPoolDao{
		private static DBPool dbPool = new DBPool();
	}
	
	public String getPoolPath() {
		if (poolPath == null) {
			//如果poolPath为空，赋值为默认值
			poolPath = ClassUtil.getClassRootPath(DBPool.class) + "proxool.xml";
		}
		return poolPath;
	}

	
	/**
	 * @decription:设置数据库连接池配置文件路径
	 * @parm:@param poolPath
	 * @return:void
	 * @throws:
	 */
	public void setPoolPath(String poolPath) {
		this.poolPath = poolPath;
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
