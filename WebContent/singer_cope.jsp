<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>歌手详情</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <link rel="icon" href="favicons/1.png">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/index.css">
    <link href="css/player.css" rel="stylesheet" type="text/css" />

<!--    <link rel="stylesheet" href="../css/back.css">&lt;!&ndash; 我的css代码路径 &ndash;&gt;-->
</head>
<style>
#aaa{
    display:block;
    text-align:center;
    position:relative;
    float:right;
    margin-right:300px;
    margin-bottom:-300px;
}
</style>
<body>

<!--    <div class="bgimg">-->

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

                
        <div class="header-login" id="aaa">
          <a onclick="likesinger('${user_id}','${singer_id }');"  class="open-green">关注歌手</a>
        </div>
        
			${user_id}  ${singer_id }
    <div class="main_page">
    
        <iframe scrolling="no" id="main" name="main" frameborder="0" src="SingerDetail?id=${singer_id }&&flag=3"
                style="min-height:1500px;width:100%;height:100%;"></iframe>
                <!-- src="Singer_songServlet?name=${Singer_song.name}&&image=${Singer_song.img_url}-->
    </div>

</body>
			<script type="text/javascript">
				function likesinger(a,b){
					alert(a),
					$.ajax({
						url:'likeServlet',
						type:'post',
						data:{
							uid:a,
							itemId:b,
							flag:"2"
						},
						success:function(){
							alert("已关注");
						},
						error:function(){
							alert("error");
						}
					}),
					alert("test")
				}
			</script>
</html>