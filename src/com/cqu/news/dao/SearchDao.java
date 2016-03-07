package com.cqu.news.dao;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.cqu.news.model.NewsDetailModel;
import com.cqu.news.util.Constant;
import com.cqu.news.util.LuceneUtil;
import com.cqu.news.util.NewsToDocument;

/**
 * @author xiongxianren
 * @desciption TODO
 */
public class SearchDao {

	/**
	 * @decription:创建索引
	 * @parm:@param news
	 * @return:void
	 * @throws:IOException
	 */
	public void createIndex(NewsDetailModel news) throws IOException{
		IndexWriter indexWriter = LuceneUtil.getIndexWriter();
		Document document = NewsToDocument.newsToDocument(news);
		indexWriter.addDocument(document);
		indexWriter.close();
	}

	
	/**
	 * @decription:根据关键词查询
	 * @parm:@param keywords
	 * @return:TopDocs
	 * @throws:IOException
	 * @throws:ParseException
	 */
	public TopDocs searcher(String keywords) throws IOException, ParseException {
		Directory directory = FSDirectory.open(new File(Constant.INDEXDIR));
		TopDocs topDocs =null;
		
		IndexReader indexReader = DirectoryReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		
		Query query = new TermQuery(new Term("title",
				keywords));
		// 检索符合query条件的前n条记录
		topDocs = indexSearcher.search(query, 10);
		System.out.println("返回总记录数" + topDocs.totalHits);
		ScoreDoc scoreDocs[] = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			
			int docID = scoreDoc.doc;
			// 根据id检索document
			Document document = indexSearcher.doc(docID);
			System.out.println("标题:"+document.get("title"));
			System.out.println("内容:"+document.get("content"));
			System.out.println("-----------------------------------------------------");
		}
		return topDocs;
	}	
	
	
	/**
	 * @decription:测试
	 * @parm:@param args
	 * @return:void
	 * @throws:IOException
	 */
	public static void main(String[] args) throws IOException {
		SearchDao test = new SearchDao();
		try {
			System.out.println(test.searcher("虎溪校区举行辅导员座谈会"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
