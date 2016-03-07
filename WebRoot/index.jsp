<%@ page language="java" import="java.sql.*,com.cqu.news.dao.*,java.util.List,com.cqu.news.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>重大新闻网</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="重大新闻网">
	
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/responsiveslides.min.css">
	
	<script src="js/app/main.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/responsiveslides.min.js"></script>

  </head>
  
  <body>
  	<%  
        String driverName = "com.mysql.jdbc.Driver";         
        String userName = "root";           
        String userPasswd = "951013xm";           
        String dbName = "cqunews";            
        String tableName = "detail";  
        String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="  
                + userName + "&password=" + userPasswd;  
        Class.forName("com.mysql.jdbc.Driver").newInstance();  
        Connection connection = DriverManager.getConnection(url);  
        Statement statement = connection.createStatement();  
        String sql = "SELECT * FROM DETAIL";  
        ResultSet rs = statement.executeQuery(sql);  
    %>  
    <div id="backToTop" class="icon-circle-arrow-up"><a href="#"><span>返回顶部</span></a></div>
    <div class="header">
		<div class="header-main wrap">
			<div class="logo">
				<img src="img/logo.png"><h1 id="site-name">重大新闻网</h1>
			</div>
			<div class="login">
				<a href="reg.jsp" id="reg-btn">注册</a>
				<a href="login.jsp" id="login-btn">登录</a>
			</div>
		</div>
		<div class="nav">
			<div class="wrap">
			<nav>
				<ul>
					<li class="nav-item nav-item-active"><a href="#">首页</a></li>
					<li class="nav-item"><a href="#">综合新闻</a></li>
					<li class="nav-item"><a href="#">推荐新闻</a></li>
					<li class="nav-item"><a href="#">热点新闻</a></li>
				</ul>
			</nav>
			<div class="search-box">
				<form action="result.jsp" method="GET" name="search">
					<input type="submit" name="search-btn" id="search-btn" value="搜索">
					<input type="text" name="query" id="search" placeholder="搜点什么...">
				</form>
			</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="wrap">

			<div class="chief">
				<div id="scroll-img">
					<div class="callbacks_container">
					      <ul class="rslides" id="slider">
					        <li>
					          <img src="img/gallery_1.jpg" alt="">
					          <p class="caption">毕业生秋季双选会 四百企业来校揽才</p>
					        </li>
					        <li>
					          <img src="img/gallery_2.jpg" alt="">
					          <p class="caption">输配电装备及系统安全与新技术国家重点实验室召开学术委员会议</p>
					        </li>
					        <li>
					          <img src="img/gallery_3.jpg" alt="">
					          <p class="caption">“2015国际光年——重庆照明科技活动周”在重庆大学举行</p>
					        </li>
					      </ul>
				    </div>
				</div>
				<div id="res">
					<div class="box-header">
						<h2 class="box-title icon-quote-left">最新资讯</h2>
					</div>							             
					<div class="res-list">
						<div clas="res-wrap">
						<%
				           NewsDao db=new NewsDao();
				           List<NewsDetailModel> list =db.getNewsInfos();    
				           for(NewsDetailModel tl:list)
			            {%>
							<div class="res-list-item">
								<a href="detail.jsp">
									<h3 class="res-list-item-title">
										<%=tl.getTitle() %>
									</h3>	
									<dl class="res-list-item-bd">
										<dt>
											<img src='img/gallery_1.jpg'>
										</dt>
										<dd>
											<p class="description"><%=tl.getContent() %></p>
										</dd>
									</dl>

								</a>
								<p class="res-list-item-ft">
									<span class="time" data-time="2015-9-9 19:00">
										<%=tl.getTime() %>
									</span>
								</p>
							</div>
							<%}
			       		 %>
								
						
						</div>
					</div>
				</div>

				<div class="page">
					<div class="page-pre">
						<span><a href="#">上一页</a></span>
					</div>
					<div class="page-list">
						<span ><a href="#" class="page-item page-active">1</a></span>
						<span ><a href="#" class="page-item">2</a></span>
						<span ><a href="#" class="page-item">3</a></span>
						<span ><a href="#" class="page-item">4</a></span>
						<span ><a href="#" class="page-item">5</a></span>
						<span ><a href="#" class="page-item">6</a></span>
						<span ><a href="#" class="page-item">7</a></span>
						<span ><a href="#" class="page-item">8</a></span>
						<span ><a href="#" class="page-item">9</a></span>
						<span ><a href="#" class="page-item">10</a></span>
					</div>
					<div class="page-next">
						<span><a href="#">下一页</a></span>
					</div>
				</div>
			</div>
			<div class="side">
				<div class="mod-news side-box">
					<div class="box-header  ">
						<h2 class="box-title icon-fire">热点新闻</h2>
					</div>
					<ul>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/kyzx/other/201509/20150915/1504240096.html"><p>重庆大学举行毕业生秋季双选会 四百企业来校揽</p></a></li>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/kyzx/kydt/201511/20151120/1510080221.html;jsessionid=2ED5928EAB964A4F3B508C5495444FE4"><p>我校教授论文入选“中国百篇最具影响优秀国内学</p></a></li>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/kyzx/kydt/201511/20151113/1509501275.html"><p>中央宣讲团成员王志刚来学校电镜中心调研</p></a></li>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/kyzx/kydt/201511/20151109/1509285977.html"><p>重庆大学2名教授入选2015年国家百千万人才工程</p></a></li>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/kyzx/kydt/201511/20151121/1510188047.html"><p>我校11位教师入选重庆市高层次人才特殊支持计划</p></a></li>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/kyzx/kydt/201511/20151119/1510067994.html"><p>唐立新校友回母校座谈交流</p></a></li>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/yzzt/tmzn2016/"><p>重庆大学理学图书馆正式开馆</p></a></li>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/kyzx/jybzc/201509/20150911/1504074468.html;jsessionid=2ED5928EAB964A4F3B508C5495444FE4"><p>重钢集团与重庆大学签订钢结构产业技术合作协议</p></a></li>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/yzzt/yzbk2016"><p>重庆大学2015年再获国家社科基金重大项目立项</p></a></li>
						<li class="mod-news-item"><a href="http://yz.chsi.com.cn/kyzx/kydt/201511/20151120/1510079303.html"><p>重庆大学留学生在“重庆最美外国留学生”评选大</p></a></li>
					</ul>
				</div>

				<div class="refer-links side-box">
					<div class="box-header">
						<h2 class="box-title icon-tags">推荐网站</h2>
					</div>
					<ul>
						<a href="http://www.cqu.edu.cn/"><li class="mod-news-item"><p>重大官网</p><span class="icon-arrow-right"></span></li></a>
						<a href="http://ids.cqu.edu.cn/"><li class="mod-news-item"><p>信息门户</p><span class="icon-arrow-right"></li></a>
						<a href="http://huxi.cqu.edu.cn/"><li class="mod-news-item"><p>虎溪校区</p><span class="icon-arrow-right"></li></a>
						<a href="http://www.cqumzh.cn/"><li class="mod-news-item"><p>民主湖论坛</p><span class="icon-arrow-right"></li></a>
						<a href="http://lib.cqu.edu.cn/newversion/index.htm"><li class="mod-news-item"><p>数字图书馆</p><span class="icon-arrow-right"></li></a>
						<a href="http://ias.cqu.edu.cn/"><li class="mod-news-item"><p>高研院</p><span class="icon-arrow-right"></li></a>
						<a href="http://www.jwc.cqu.edu.cn/"><li class="mod-news-item"><p>教务网</p><span class="icon-arrow-right"></li></a>
						<a href="http://jjh.cqu.edu.cn/dxlm/"><li class="mod-news-item"><p>重庆市大学联盟</p><span class="icon-arrow-right"></li></a>
						<a href="http://www.wenxin.info/"><li class="mod-news-item"><p>熊贤仁的博客</p><span class="icon-arrow-right"></li></a>
						<a href="http://www.funyan.win/"><li class="mod-news-item"><p>Fun言官网</p><span class="icon-arrow-right"></li></a>
						
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="wrap">
			<div class="copyright-tab">
				<div class="tab-group">
					<h3>标题</h3>
					<ul>
						<li><a href="">链接1</a></li>
						<li><a href="">链接1</a></li>
						<li><a href="">链接1</a></li>
						<li><a href="">链接1</a></li>
					</ul>
				</div>
				<div class="tab-group">
					<h3>标题</h3>
					<ul>
						<li><a href="">链接1</a></li>
						<li><a href="">链接1</a></li>
						<li><a href="">链接1</a></li>
						<li><a href="">链接1</a></li>
					</ul>
				</div>
				<div class="tab-group">
					<h3>标题</h3>
					<ul>
						<li><a href="">链接1</a></li>
						<li><a href="">链接1</a></li>
						<li><a href="">链接1</a></li>
						<li><a href="">链接1</a></li>
					</ul>
				</div>
			</div>

			<div class="copyright-content">
				<p>@Copyright Reserved By Xiong Xianren</p>
			</div>
		</div>
	</div>
	<script>
		$(function () {
	      $("#slider").responsiveSlides({
	        auto: true,
	        pager: false,
	        nav: true,
	        speed: 500,
	        namespace: "callbacks"
	      });

	    });
	</script>
  </body>
</html>
