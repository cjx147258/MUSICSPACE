<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="space.bean.Music"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
#tab {
	width:550px;
	height:150px;
	text-align:center;
	margin:auto;
	margin-left:0px;
	float:left;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排行榜</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="css/primary.css">
<link rel="icon" href="favicons/1.png">

<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index.css">

<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript">

//function init(){
	//alert(1);
//	$("biaodan").submit();
//}
	</script>
</head>
<body >
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
        <li><a href="RankServlet" class="subNav-cur">排行榜</a></li>
        <li><a href="MusicSheetServlet">分类歌单</a></li>
      </ul>
    </div>
  </header>
	<div id="container">

		<div id="main">
			<div id="left">
				<dl>
					<dt>音乐巅峰榜</dt>
					<dd><a href="RankServlet?style_id=1">巅峰榜.流行指数</a></dd>
					<dd><a href="RankServlet?style_id=2">巅峰榜.新歌</a></dd>
					<dd><a href="RankServlet?style_id=3">巅峰榜.网络歌曲</a></dd>
					<dd><a href="RankServlet?style_id=4">巅峰榜·内地</a></dd>
					<dd><a href="RankServlet?style_id=5">巅峰榜·欧美</a></dd>
				</dl>
			</div>
			<div id="right">
				<dl>

					<table id="tab">
						<tr style="font-size:20px;">
							<th>热度</th>
							
							<th style="text-align:right">歌曲</th>
							<th></th>
							<th >歌手</th>
						</tr>
						<c:forEach items="${musics}" var="gequ" step="1"
							varStatus="status">
							<tr id="tr1" style="height:100px">
								<td>${gequ.heat}</td>
								<td style="text-align:right;margin-right:3px;width:70px;"><a href="MusicInfoServlet?mid=${gequ.id }&&flag=1"><img src="${gequ.cover_url}" style="height:60px;width:60px;"></a></td>
								<td style="text-align:left"><a href="MusicInfoServlet?mid=${gequ.id }&&flag=1">${gequ.name}</a></td>
								<td><a href="SingerDetail?singer_id=${gequ.singer_id }&&flag=0">${gequ.singer_name}</a></td>

							</tr>
						</c:forEach>
					</table>
				</dl>
			</div>
		</div>
	</div>
</body>
	<style>
	</style>
</html>
