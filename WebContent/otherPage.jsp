<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="space.bean.User" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户主页</title>
<link rel="icon" href="favicons/1.png">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index.css">
<link href="css/player.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript"></script>
<script src="js/jquery-1.11.0.js"></script>
<script src="js/pintuer.js"></script>
<style>
#div1 {
	height: 300px;
	width: 910px;
	margin: auto;
	border: 1px solid #000000;
}

#div2 {
	height: 600px;
	width: 910px;
	margin: auto;
	margin-top: 50px;
	border: 1px solid #000000;
}

#d1 {
	height: 180px;
	width: 160px;
	border: 1px solid #000000;
	Margin: 50px;
	float: left;
}

.d2 {
	height: 180px;
	width: 160px;
	Margin: 10px;
	float: left;
}

#d3 {
	height: 180px;
	width: 500px;
	border: 1px solid #000000;
	Margin-left: 10px;
	Margin-top: 50px;
	float: left;
}
</style>
<body>

<%User user = (User)request.getSession().getAttribute("user");%>
  <header class="header">
  	
    <div class="header-container">
      <div class="header-top">
        <!--<a href="#" class="logo"></a>-->
        <nav class="header-nav">
          <ul>
            <li><a href="indexServlet" class="header-nav__cur">音乐馆</a></li>
            <li><a href="MyMusicServlet?label=0">我的音乐</a></li>
            <!-- <li><a href="#">下载客户端</a></li> -->
            <!-- <li><a href="#">VIP</a></li> -->
          </ul>
        </nav>
        <div class="header-search">
          <form action="SearchServlet" method="get">
	          <input type="text" name="Content" class="text" placeholder="here...">
	          <div class="btn"><i class="icon-sprite"></i></div>
          </form>
        </div>
        <div class="header-login">
          <!-- <a href="#" class="login">Login</a> -->  
          <a href="#"  class="open-green">主页/登录</a>

          <!-- <a href="#" class="open-vip">开通付费包</a> -->
        </div>
      </div>
      <ul class="header-subNav">
        <li><a href="indexServlet">首页</a></li>
        <li><a href="SingerServlet?label=1">歌手</a></li>
        <li><a href="AlbumPageServlet?style=1">专辑</a></li>
        <li><a href="RankServlet">排行榜</a></li>
        <li><a href="MusicSheetServlet">分类歌单</a></li>
      </ul>
    </div>
  </header>
	<div id="div1">
		<div id="d1">
			<img alt=""
				src=${user.icon_url } 
				style="height: 100%; width: 100%;">
		</div>
		<div id="d3">
			<p style="font-size: 30px; margin: 15px;">${user.name}</p>
			<hr style="margin-top: 20px">
			<p style="font-size: 15px; margin: 15px;">${user.introduction}</p>
		</div>
	</div>
	<div id="div2">
		<p style="font-size: 30px; margin: 10px;">我收藏的歌单</p>
		<hr>

		<c:forEach items="${sheetlist}" var="s" begin="1" end="6" step="1"
			varStatus="Status">
			<c:if test="${user.id != s.owner_id}">
				<div class="d2">
					<div class="featured-cars-img">
						<a href="SheetDetail?msid=${s.id }&&flag=0"><img src="${s.cover_url}"
							style="height: 160px; width: 160px;" /></a>
					</div>
					<div class="featured-model-info">
						<p>
							<span
								style="text-align: center; display: block; font-size: 20px;"><a
								href="SheetDetail?msid=${s.id }&&flag=0">${s.name}</a></span>
						</p>
					</div>
				</div>
				</c:if>
		</c:forEach>

	</div>

	<div id="div2">
		<p style="font-size: 30px; margin: 10px;">我创建的歌单</p>
		<hr>

		<c:forEach items="${sheetlist}" var="s" step="1" varStatus="status">
			<c:if test="${user.id ==s.owner_id}">
				<div class="d2">
					<div class="single-featured-cars">
						<div class="featuredj-img-box">
							<div class="featured-cars-img">
								<a href="SheetDetail?msid=${s.id }&&flag=0"><img src="${s.cover_url}"
									style="height: 160px; width: 160px;" /></a>
							</div>
							<div class="featured-model-info">
								<p>
									<span
										style="text-align: center; display: block; font-size: 17px;"><a
										href="SheetDetail?msid=${s.id }&&flag=0">${s.name}</a></span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>

	</div>
</body>
</html>