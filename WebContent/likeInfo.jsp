<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>我的音乐</title>
	<link rel="icon" href="favicons/1.png">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/index.css">
	<link href="css/player.css" rel="stylesheet" type="text/css" />
	
	<link rel="stylesheet" href="css/album_template.css">
	
	<script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script> 
</head>
<style>
	#d {
		height:auto;
		width:1000px;
		margin-left:70px;
	}
	#d1{
		height:700px;
		width:130px;
		border-right: 1px solid #C9C9C9;
		float:left;
	}
	#d3{
		height:600px;
		width:800px;
		border:1px solid #000000;
	}
	.d2 {
		height:180px;
		width:160px;
		Margin:20px;
		padding:5px;
		float:left;
	}
	#ul{
		display:table;
		padding:5px;
		margin:8px;
		width:94px;
		height:40px;
	}
	li{
		text-align:center;
	}
	#lilist{
	    display: inline-block;
	    position: relative;
        top:15px;
        right:5px;
	    text-align:;
	    margin:3px;
	    padding:3px;
	    width:90px;
	    height:25px;
	}
	#ullist{
	    display: inline-block;
	    text-align:center;
	    margin:3px;
	    padding:3px;
	    width:90px;
	    height:60px;
	}
	#lilist1{
	    display: inline-block;
	    text-align:center;
	    margin:3px;
	    padding:1px;
	    width:80px;
	    height:25px;
	}
</style>
<body>
	
  <header class="header">
  	<!--引入悬浮播放器-->
  	
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
          <input type="text" class="text" placeholder="here...">
          <div class="btn"><i class="icon-sprite"></i></div>
          
        </div>
        <div class="header-login">
          <!-- <a href="#" class="login">Login</a> -->
          <a href="#" class="open-green">login</a>
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
  <div id="d" style="margin:auto">
  	<div id="d1">
  		<ul id="ul">
  			<li id="lilist"><a href="MyMusicServlet?label=0">收藏歌单</a></li>
  			
  		</ul>
  		<hr align=left width=115 color=#C9C9C9 size=1>
  		<ul id="ul">
  			<li id="lilist"><a href="MyMusicServlet?label=1"><h2><b>收藏专辑</b></h2></a></li>
  		</ul>
  		<hr align=left width=115 color=#C9C9C9 size=1>
  		<ul id="ul">
  			<li id="lilist"><a href="MyMusicServlet?label=2"><h2><b>收藏歌手</b></h2></a></li>
  		</ul>
  	</div>
  	
  	<c:if test="${flag==0}">
  	
  	<c:forEach items="${slist}" var="s" step="1" varStatus="status" >
  	<div class="d2">
  	    <div class="single-featured-cars">
					<div class="featured-img-box"  >
						<div class="featured-cars-img">
							<a href=""><img src= "${s.cover_url}" /> </a>
						</div>
						<div class="featured-model-info">
							<p>
								<span class="featured-hp-span"><a href="">${s.name}</a></span>
							</p>
						</div>
					</div>
	    </div>
	</div>
  	</c:forEach>
  	</c:if>
  	
  	<c:if test="${flag==1}">
  	<c:forEach items="${slist}" var="s" step="1" varStatus="status" >
  	<div class="d2">
  	    <div class="single-featured-cars">
					<div class="featured-img-box"  >
						<div class="featured-cars-img">
							<a href=""><img src= "${s.cover_url}" /> </a>
						</div>
						<div class="featured-model-info">
							<p>
								<span class="featured-hp-span"><a href="">${s.name}</a></span>
							</p>
						</div>
					</div>
	    </div>
	</div>
  	</c:forEach>
  	</c:if>
  	
  	<c:if test="${flag==2}">
  	<c:forEach items="${slist}" var="s" step="1" varStatus="status" >
  	<div class="d2">
  	    <div class="single-featured-cars">
					<div class="featured-img-box"  >
						<div class="featured-cars-img">
							<a href=""><img src= "${s.img_url}" /> </a>
						</div>
						<div class="featured-model-info">
							<p>
								<span class="featured-hp-span"><a href="">${s.name}</a></span>
							</p>
						</div>
					</div>
	    </div>
	</div>
  	</c:forEach>
  	</c:if>
  	
  </div>
</body>
</html>