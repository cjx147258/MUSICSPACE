<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>歌单详情</title>
	<link rel="icon" href="favicons/1.png">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/index.css">
	<link href="css/player.css" rel="stylesheet" type="text/css" />
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
        <li><a href="MusicSheetServlet">分类歌单</a></li>
      </ul>
    </div>
  </header>
<div class="main_page">
 <iframe scrolling="no" id="main" name="main" frameborder="0"  src="SheetDetail?msid=${msid }&&uid=${uid }&&flag=1 "
                style="min-height:1500px;width:100%;height:100%;"></iframe>
    </div>
</body>
</html>