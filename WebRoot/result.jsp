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
	<link rel="stylesheet" href="css/result.css">
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
				
				<div id="res">
					<div class="box-header">
						<h2 class="box-title icon-quote-left">最新资讯</h2>
					</div>							             
					<div class="res-list">
						<div clas="res-wrap">
						
							<div class="res-list-item">
								<a href="detail.jsp">
									<h3 class="res-list-item-title">
										土木职协举办第二次社团大会
									</h3>	
									<dl class="res-list-item-bd">
										<dt>
											<img src='img/gallery_1.jpg'>
										</dt>
										<dd>
											<p class="description">2015年4月6日晚上8:30，重庆大学土木工程学院职协在竹六505活动室召开了本学期的第二次社团大会。清明小长假刚刚结束，大家尽管有些疲惫，但还是积极参与了社团会议。本次会议的主要内容围绕职协本学期的发展以及接下来的“职海视航”讲座展开。 首先，刘明华、杨焰鑫两位职协的新成员进行了简单的自我介绍。他们的加入，为职协注入了新的力量，相信他们能在职协中发挥自己的能力，为职协的发展出谋划策。同时，在职协中成长得更好，为将来的职业之路奠定基础。 接下来，是本学期有关“职海视航”系列讲座的安排。该讲座是让同学们了解就业形势，培养就业意识，提高核心竞争力而开展的讲座。讲座总共分三期进行。第一期讲座初定于2015年4月12日下午进行。在此，虎溪负责人陈辰对活动的相关事宜进行了如下安排：活动的前期准备由基础事务及形象事务部负责，包括海报，展板的制作，教室的申请以及线上宣传等；活动的秩序维持以及现场的实时报道由发展培训部和市场推广部负责。并且他还对活动中的注意事项进行了强调，以及对活动后的反馈进行了安排。 此外，针对活动第二期和第三期做出如下设想：为了社团中各个成员得到锻炼的机会，以后每期活动将会更换活动的策划人，采取自愿报名的的方法。这样的安排，让每个成员都能够亲自去统筹一个活动，提高自己的统筹能力，这也正是他们加入社团所希望的。 这次会议还成立了一个职协主页新闻管理小组，由大一成员胡升友和舒维康负责职协的主页管理和新闻稿件的写作，让更多的同学关注职协，关注职业发展。 会议到这里结束。这次会议详细的安排了职协接下来的工作，各个部门会各司其职，在大家的共同努力下，职协的发展会越来越好，服务更多的同学。</p>
											
										</dd>
									</dl>

								</a>
								<p class="res-list-item-ft">
									<span class="time" data-time="2015-9-9 19:00">
										2015-04-10 14:12:52
									</span>
								</p>
							</div>
							
								
						
						</div>
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
	
  </body>
</html>
