package com.cqu.news.util;  

import java.security.MessageDigest;
  
  
/**
 * @author xiongxianren
 * @desciption 加密类
 */
public class Encrypt {
	//MD5加密
	public static final String MD5 = "MD5";
	
	/**
	 * @decription:对字符串加密
	 * @parm:@param str
	 * @parm:@encName 加密种类名
	 * @parm:@return
	 * @return:String
	 * @throws:
	 */
	public static String encrypt(String str, String encName) {
		String reStr = null;
		try {
			//加密器
			MessageDigest digest = MessageDigest.getInstance(encName);
			byte[] bytes = digest.digest(str.getBytes());
			StringBuffer stringBuffer = new StringBuffer();
			for (byte b : bytes) {
				int bt = b&0xff;
				//如果小于16，补位一个0
				if (bt < 16) {
					stringBuffer.append(0);
				}
				stringBuffer.append(Integer.toHexString(bt));
			}
			
			reStr = stringBuffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reStr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub  

	}

}
