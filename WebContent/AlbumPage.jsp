<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专辑</title>
	<link href="css/album_template.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="icon" href="favicons/1.png">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/index.css">
	<link href="css/player.css" rel="stylesheet" type="text/css" />
</head>
<style>
			.dropbtn {
				color: black;
				padding: 16px;
				font-size: 16px;
				border: none;
				cursor: pointer;
			}
			
			.dropdown {
				position: relative;
				display: inline-block;
			}
			
			.dropdown-content {
				display: none;
				position: absolute;
				background-color: #f9f9f9;
				width: 550px;
				/*box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);*/
			}
			
			.dropdown-content p {
				color: black;
				padding: 5px 5px;
				text-decoration: none;
				display: block;
				float: left;
			}
			
			.dropdown-content a:hover {
				background-color: #AAAAAA
			}
			
			.dropdown:hover .dropdown-content {
				display: block;
			}
			
			.dropdown:hover .dropbtn {
				background-color: #3e8e41;
			}
			
			.line1 {
				margin: 0px 8px 0px 10px;
				color: #000000;
			}
			
			.as {
				margin-right: 30px;
			}
			
			a {
				text-decoration: none;
			}
			
			.menul_p1 {
				line-height: 50px;
				margin: 0px;
				float: left;
			}
			.dropdown-content a{
				display: inline;
			}
			.featured-cars-img img{
				width:120px;
				display:block;
			}
	.featured-cars-img img.bigger {
       width: 120px; 
      
       transition:transform 1s; 
    } 
    img.bigger:hover{ 
       transform: scale(1.2,1.2); 
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
        <li><a href="SingerServlet?label=1">歌手</a></li>
        <li><a href="AlbumPageServlet?style=1" class="subNav-cur">专辑</a></li>
        <li><a href="RankServlet">排行榜</a></li>
        <li><a href="MusicSheetServlet">分类歌单</a></li>
      </ul>
    </div>
  </header>
  
	<div style="width: 1000px; height: 100px; margin: auto">
		<div class="dropdown">
			<button class="dropbtn">全部分类</button>
			<hr noshade="noshade" style="height: 2px; width: 1000px; color: gray">
			<div class="dropdown-content">
				<p class="menul_p1">
					
					<a href="AlbumPageServlet?style=1"> 流行 </a><span class="line1">|</span>

					<a href="AlbumPageServlet?style=2"> 摇滚</a><span class="line1">|</span>
					 <a href="AlbumPageServlet?style=3">中文</a><span class="line1">|</span> 
					 <a href="AlbumPageServlet?style=4"> 好听</a><span class="line1">|</span>

					<a href="AlbumPageServlet?style=5"> 粤语</a><span class="line1">|</span> 
					<a href="AlbumPageServlet?style=6">小语种</a><span class="line1">|</span>

				</p>

			</div>
		</div>
	</div>
	<div style="width: 1000px;margin:auto">
  	<div style="margin: auto;width:900px">
  	<ul style="display: inline-block">
  		<c:forEach items="${Alist}" var="a" step="1" varStatus="status" >     
          <li style="float: left; margin: 10px">
          <div class="single-featured-cars">
					<div class="featured-img-box">
						<div class="featured-cars-img">
						<a href="AlbumDetailServlet?album_id=${a.id }&&flag=0">
							<img class="bigger" src= ${a.cover_url } alt="cars">
							</a>
						</div>
						<div class="featured-model-info">
							<p>
								
								<!-- 图标: 播放量 -->
								<!-- <span class="featured-mi-span"></span> -->
								<a href="AlbumDetailServlet?album_id=${a.id }&&flag=0">
								<span class="featured-hp-span">${a.name }</span>
								</a>
							</p>
						</div>
					</div>
		
			</div>
          </li>
       </c:forEach> 
  	</ul>
  	</div>
  </div>
</body>
</html>