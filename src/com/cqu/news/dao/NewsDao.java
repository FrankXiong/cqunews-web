package com.cqu.news.dao;

import java.util.ArrayList;
import java.util.List;

import com.cqu.news.dbhelper.DBServer;
import com.cqu.news.model.NewsDetailModel;
import com.cqu.news.util.Constant;
import com.cqu.news.util.JsonUtil;

import java.sql.ResultSet;
import java.util.HashMap;
 
/**
 * @author xiongxianren
 * @desciption TODO
 */
public class NewsDao {

	/**
	 * @decription:获取新闻信息
	 * @parm:@return
	 * @parm:@return
	 * @return:List<NewsDetailModel>
	 * @throws:
	 */
	public List<NewsDetailModel> getNewsInfos() {
		List<NewsDetailModel> infos = new ArrayList<NewsDetailModel>();
		DBServer dbServer = new DBServer(Constant.POOLNAME);
		try {
			String sql = "select * from detail";
			ResultSet rs = dbServer.select(sql);
			while(rs.next()) {
				NewsDetailModel info = new NewsDetailModel();
				info.setId(rs.getString("id"));
				info.setUrl(rs.getString("url"));
				info.setTitle(rs.getString("title"));
				info.setContent(rs.getString("content"));
				info.setTime(rs.getString("time"));
				infos.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		return infos;
	}
	
	
	/**
	 * @decription:保存新闻信息到数据库
	 * @parm:@param bean
	 * @parm:@param bean
	 * @return:void
	 * @throws:
	 */
	public void saveNewsInfos(NewsDetailModel bean){
		if (bean == null) {
			return;
		}
		DBServer dbServer = new DBServer(Constant.POOLNAME);
		try {
			
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int i = 1;
			
			params.put(i++, bean.getId());
			params.put(i++, bean.getUrl());
			params.put(i++, bean.getTitle());
			params.put(i++, bean.getContent());
			params.put(i++, bean.getTime());
			
			String columns = "id,url,title,content,time";
			dbServer.insert("detail", columns, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}
	
	

	
	/**
	 * @decription:测试
	 * @parm:@param args
	 * @parm:@param args
	 * @return:void
	 * @throws:
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		NewsDao db = new NewsDao();
//		NewsDetailModel bean = new NewsDetailModel();
//		bean.setId("1");
//		bean.setUrl("www.123.com");
//		bean.setTitle("title");
//		bean.setContent("content");
//		bean.setTime("2015-11-30");
//	
//		db.saveNewsDetail(bean);
		System.out.println(JsonUtil.parseJson(db.getNewsInfos()));
		
	}

}


