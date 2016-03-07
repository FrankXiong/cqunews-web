package com.cqu.news.util;

 
/**
 * @author xiongxianren
 * @desciption TODO
 */
public class ClassUtil {
	
	
	/**
	 * @decription:返回class文件所在的目录
	 * @parm:@param c
	 * @parm:@return
	 * @return:String
	 * @throws:
	 */
	public static String getClassPath(Class<?> c) {
		return c.getResource("").getPath().replaceAll("%20", " ");
	}
	
	
	/**
	 * @decription:返回class文件所在项目的根目录
	 * @parm:@param c
	 * @parm:@return
	 * @return:String
	 * @throws:
	 */
	public static String getClassRootPath(Class<?> c) {
		return c.getResource("/").getPath().replaceAll("%20", " ");
	}
	
	/**
	 * @decription:返回class文件所在的目录
	 * @parm:@param c
	 * @parm:@param hasName
	 * @parm:@return
	 * @return:String
	 * @throws:
	 */
	public static String getClassPath(Class<?> c, boolean hasName) {
		String name = c.getSimpleName() + ".class";
		//将‘%20’转换回空格		
		String path = c.getResource(name).getPath().replaceAll("%20", " ");
		if (hasName) {
			return path;
		} else {
			return path.substring(0, path.length() - name.length());
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub  

	}

}

