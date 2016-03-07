package com.cqu.news.crawl;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

import com.cqu.news.util.ParseMD5;
import com.cqu.news.dao.NewsDao;
import com.cqu.news.model.NewsDetailModel;


/**
 * @author xiongxianren
 * @desciption 爬取信息
 */
public class NewsIndexPage extends BreadthCrawler {

    
    /**
     * @param crawlPath 爬取下来的信息保存路径
     * @param autoParse
     */
    public NewsIndexPage(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse); 
        this.addSeed("http://news.cqu.edu.cn/news/article/");       
        this.addRegex("http://news.cqu.edu.cn/news/article/*.*html"); 
        //this.addRegex("-.*\\.(jpg|png|gif).*");
        //this.addRegex("-.*#.*");
    }

    /* (non-Javadoc)
     * @see cn.edu.hfut.dmic.webcollector.fetcher.Visitor#visit(cn.edu.hfut.dmic.webcollector.model.Page, cn.edu.hfut.dmic.webcollector.model.CrawlDatums)
     */
    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.getUrl();
        
        if (page.matchUrl("http://news.cqu.edu.cn/news/article/*.*html")) {
           
            String title = page.select("div[class=title]>h1").first().text();
            String content = page.select("div#zoom", 0).text();
            String time = page.select("span[class=datetime]").text();
            String desc = page.select("div[class=description]>p").text();
            String tag = page.select("div#location a:nth-child(2)").text();  
           
            NewsDetailModel bean = new NewsDetailModel();
    		bean.setUrl(url);
    		bean.setId(ParseMD5.parseStrToMD5(bean.getUrl()));
    		bean.setTitle(title);
    		bean.setContent(content);
    		bean.setTime(time);
  
    		NewsDao db = new NewsDao();
            db.saveNewsInfos(bean);
                       
            System.out.println("url:\n" + url);
            System.out.println("title:\n" + title);
            System.out.println("time:\n" + time);
            System.out.println("desc:\n" + desc);
            System.out.println("content:\n" + content);
            System.out.println("tag:\n" + tag);
            
            System.out.println("----------------------------------------------------------");
        }
    }
    
    
    /**
     * @decription:启动爬虫
     * @parm:@param args
     * @parm:@throws Exception
     * @return:void
     * @throws:
     */
    public static void main(String[] args){
    	NewsIndexPage crawler = new NewsIndexPage("data", true);

        crawler.setThreads(50);
        crawler.setTopN(10000);
        try {
			crawler.start(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

