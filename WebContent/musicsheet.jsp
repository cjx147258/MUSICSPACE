<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>歌单分类</title>
	<link href="css/album_template.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="icon" href="favicons/1.png">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/index.css">
	<link href="css/player.css" rel="stylesheet" type="text/css" />
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
</head>
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
        <li><a href="AlbumPageServlet?style=1">专辑</a></li>
        <li><a href="RankServlet">排行榜</a></li>
        <li><a href="MusicSheetServlet" class="subNav-cur">分类歌单</a></li>
      </ul>
    </div>
  </header>
  
  <div style="width:1000px;height:100px;margin:auto">
  	<div class="dropdown">
				<button class="dropbtn">全部分类</button>
			<hr noshade="noshade" style="height:2px;width:1000px;color:gray">
				<div class="dropdown-content">
					<p class="menul_p1">
						<span class="as">
  						语种
  					</span>

						<a href="MusicStyleServlet?style_id=1"> 华语 </a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=2"> 欧美</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=3"> 日语</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=4"> 韩语</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=5"> 粤语</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=6"> 小语种</a><span class="line1">|</span>

					</p>
					<p class="menul_p1">
						<span class="as">
  						风格
  					</span>
						<a href="MusicStyleServlet?style_id=7"> 流行 </a><span class="line1">|</span>
						<a href="MusicStyleServlet?style_id=8"> 古典</a><span class="line1">|</span>
						<a href="MusicStyleServlet?style_id=9"> 摇滚</a><span class="line1">|</span>
						<a href="MusicStyleServlet?style_id=10"> 朋克</a><span class="line1">|</span>
						<a href="MusicStyleServlet?style_id=11"> 民谣</a><span class="line1">|</span>
						<a href="MusicStyleServlet?style_id=12"> 拉丁</a><span class="line1">|</span>
						<a href="MusicStyleServlet?style_id=13"> 爵士</a><span class="line1">|</span>
						<a href="MusicStyleServlet?style_id=14"> 轻音乐</a><span class="line1">|</span>
						<a href="MusicStyleServlet?style_id=15"> 古风</a><span class="line1">|</span>
						<a href="MusicStyleServlet?style_id=16"> 金属</a><span class="line1">|</span>
					</p>
					<p class="menul_p1">
						<span class="as">
  						场景
  					</span>
						<a href="MusicStyleServlet?style_id=17"> 清晨 </a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=18"> 夜晚</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=19"> 学习</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=20"> 工作</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=21"> 运动</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=22"> 旅行</a><span class="line1">|</span>

					</p>
					<p class="menul_p1">
						<span class="as">
  						情感
  					</span>
						<a href="MusicStyleServlet?style_id=23"> 怀旧</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=24"> 浪漫</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=25"> 清新</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=26">感动</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=27"> 安静</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=28"> 伤感</a><span class="line1">|</span>

					</p>
					<p class="menul_p1">
						<span class="as">
  						主题
  					</span>
						<a href="MusicStyleServlet?style_id=29"> 儿童 </a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=30"> 校园</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=70"> 70后</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=80"> 80后</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=90"> 90后</a><span class="line1">|</span>

						<a href="MusicStyleServlet?style_id=00"> 00后</a><span class="line1">|</span>

					</p>

				</div>
			</div>
  </div>
  
  <div style="width: 1000px;margin:auto">
  	<div style="margin: auto;width:900px">
  	<ul style="display: inline-block">
  		<c:forEach items="${musicsheet}" var="a" step="1" varStatus="status" >     
          <li style="float: left; margin: 10px">
          <div class="single-featured-cars">
					<div class="featured-img-box">
						<div class="featured-cars-img">
						<a href="SheetDetail?msid=${a.id }&&flag=0">
							<img class="bigger"src= ${a.cover_url } >
							
							</a>
						</div>
						<div class="featured-model-info">
							<p>
								
								<!-- 图标: 播放量 -->
								<!-- <span class="featured-mi-span"></span> -->
								<a href="SheetDetail?msid=${a.id }&&flag=0">
								<span class="featured-hp-span">${a.name }<br>播放量：&nbsp${a.heat }</span>
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