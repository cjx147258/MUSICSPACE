<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>歌手</title>
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
		margin:auto;
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
		height:100px;
	}
	li{
		text-align:center;
	}
	#lilist{
	    display: inline-block;
	    text-align:center;
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
          <a href="PersonalPageServlet"  class="open-green">主页/登录</a>

          <!-- <a href="#" class="open-vip">开通付费包</a> -->
        </div>
      </div>
      <ul class="header-subNav">
        <li><a href="indexServlet">首页</a></li>
        <li><a href="SingerServlet?label=1" class="subNav-cur">歌手</a></li>
        <li><a href="AlbumPageServlet?style=1">专辑</a></li>
        <li><a href="RankServlet">排行榜</a></li>
        <li><a href="MusicSheetServlet">分类歌单</a></li>
      </ul>
    </div>
  </header>
  <div id="d">
  	<div id="d1">
  		<ul id="ul">
  			<li id="lilist"><h3><b>华语</b></h3></li>
  			<ul id="ullist">
  			    <li id="lilist1"><a href="SingerServlet?label=1">华语男歌手</a></li>
  			    <li id="lilist1"><a href="SingerServlet?label=2">华语女歌手</a></li>
  		    </ul>
  		</ul>
  		<hr align=left width=115 color=#C9C9C9 size=1>
  		<ul id="ul">
  			<li id="lilist"><h3><b>欧美</b></h3></li>
  			<ul id="ullist">
  			    <li id="lilist1"><a href="SingerServlet?label=3">欧美男歌手</a></li>
  			    <li id="lilist1"><a href="SingerServlet?label=4">欧美女歌手</a></li>
  		    </ul>
  		</ul>
  		<hr align=left width=115 color=#C9C9C9 size=1>
  		<ul id="ul">
  			<li id="lilist"><h3><b>日本</b></h3></li>
  			<ul id="ullist">
  			    <li id="lilist1"><a href="SingerServlet?label=5">日本男歌手</a></li>
  			    <li id="lilist1"><a href="SingerServlet?label=6">日本女歌手</a></li>
  		    </ul>
  		</ul>
  		<hr align=left width=115 color=#C9C9C9 size=1>
  		<ul id="ul">
  			<li id="lilist"><h3><b>韩国</b></h3></li>
  			<ul id="ullist">
  			    <li id="lilist1"><a href="SingerServlet?label=7">韩国男歌手</a></li>
  			    <li id="lilist1"><a href="SingerServlet?label=8">韩国女歌手</a></li>
  		    </ul>
  		</ul>
  		<hr align=left width=115 color=#C9C9C9 size=1>
  		<ul id="ul">
  			<li id="lilist"><h3><b>其他歌手</b></h3></li>
  			<ul id="ullist">
  			    <li id="lilist1"><a href="SingerServlet?label=9">其他男歌手</a></li>
  			    <li id="lilist1"><a href="SingerServlet?label=10">其他女歌手</a></li>
  		    </ul>
  		</ul>
  	</div>
  	<c:forEach items="${slist}" var="s" step="1" varStatus="status" >
  	<div class="d2">
  	    <div class="single-featured-cars">
					<div class="featured-img-box"  >
						<div class="featured-cars-img">
							<a href="SingerDetail?singer_id=${s.id }&&flag=0"><img src= "${s.img_url}" /> </a>
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
  </div>
</body>
</html>