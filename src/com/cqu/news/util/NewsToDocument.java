/**
 * 
 */
package com.cqu.news.util;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;

import com.cqu.news.model.NewsDetailModel;

/**
 * @author xiongxianren
 * @desciption TODO
 */
public class NewsToDocument {

	public static Document newsToDocument(NewsDetailModel news){
		Document document = new Document();
		
		StringField idField = new StringField("id",news.getId(),Store.YES);
		StringField urlField = new StringField("url",news.getUrl(),Store.YES);
		StringField titleField = new StringField("title",news.getTitle(),Store.YES);
		StringField contentField = new StringField("content",news.getContent(),Store.YES);
		StringField timeField = new StringField("time",news.getTime(),Store.YES);
		
		document.add(idField);
		document.add(urlField);
		document.add(titleField);
		document.add(contentField);
		document.add(timeField);
	
		return document;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
