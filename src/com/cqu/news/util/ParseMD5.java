package com.cqu.news.util;  
  
/**
 * @author xiongxianren
 * @desciption 对URL进行MD5加密生成ID
 */
public class ParseMD5 extends Encrypt{
	
	/**
	 * @decription:32位小写MD5
	 * @parm:@param str
	 * @parm:@return
	 * @return:String
	 * @throws:
	 */
	public static String parseStrToMD5 (String str) {
		return encrypt(str, MD5);
	}	
	
	
	/**
	 * @decription:测试
	 * @parm:@param args
	 * @return:void
	 * @throws:
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		System.out.println(ParseMD5.parseStrToMD5("abc"));
		
	}

}
