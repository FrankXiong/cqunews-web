/**
 * 
 */
package com.cqu.news.util;

/**
 * @author:xiongxianren
 * @description:Json格式数据解析工具类
 */
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
  
public class JsonUtil {
	//默认json字符串，null值或错误的情况下返回该值
	private static final String noData = "{\"result\" : null}";
	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
		//如果属性值为空，直接忽略
		mapper.setSerializationInclusion(Include.NON_NULL);
	}

	/**
	 * @decription:将object转化为json字符串
	 * @parm:@param object
	 * @parm:@return
	 * @return:String
	 * @throws:
	 */
	public static String parseJson(Object object) {
		if (object == null) {
			return noData;
		}
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
			return noData;
		}
	}
	
	/**
	 * @decription:将json字符串转化为JsonNode
	 * @parm:@param json
	 * @parm:@return
	 * @return:JsonNode
	 * @throws:
	 */
	public JsonNode json2Object (String json) {
		try {
			return mapper.readTree(json);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @decription:JavaBean转化为Json字符串
	 * @parm:@param obj
	 * @parm:@param root
	 * @parm:@return
	 * @return:String
	 * @throws:
	 */
	public static String parseJson(Object obj, String root){
		
		if(obj == null){
			return noData;
		}
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("{\"");
			sb.append(root);
			sb.append("\":");
			sb.append(mapper.writeValueAsString(obj));
			sb.append("}");
			return sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return noData;
		}
	}
	
	
	/**  
	 * @param args
	 * @Author:lulei  
	 * @Description:  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub  

	}

}
