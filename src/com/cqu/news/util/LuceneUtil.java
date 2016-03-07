package com.cqu.news.util;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;


/**
 * @author xiongxianren
 * @desciption lucene工具类
 */
public class LuceneUtil {

	private static Directory directory = null;
	private static IndexWriterConfig config = null;
	private static Analyzer analyzer = null;
	private static IndexReader indexReader = null;
	private static Version version = null;
	
	static{
		try {
			directory = FSDirectory.open(new File(Constant.INDEXDIR));
			//如果索引处于锁定状态就解锁
			if (IndexWriter.isLocked(directory)) {
				IndexWriter.unlock(directory);
			}
			version = Version.LUCENE_43;
			analyzer = new StandardAnalyzer(version);
			config = new IndexWriterConfig(version,analyzer);
			indexReader = DirectoryReader.open(directory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static IndexWriter getIndexWriter() throws IOException{
		IndexWriter indexWriter = new IndexWriter(directory,config);
		
		return indexWriter;
	}
	public static IndexSearcher getIndexSearcher(){
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		return indexSearcher;
	}
	public static Version getCurrentVersion(){
		return version;
	}
	public static Analyzer getCurrentAnalyzer(){
		return analyzer;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
