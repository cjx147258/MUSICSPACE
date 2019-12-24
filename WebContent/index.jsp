<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>MUSIC_SPACE</title>
  <link rel="icon" href="favicons/1.png">

  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/index.css">
  
</head>

<body id="index">
<%
	if(request.getAttribute("NewMusicList")==null){
		%>
		<jsp:forward page="indexServlet"></jsp:forward>
<% 	}
%>
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
        <li><a href="indexServlet" class="subNav-cur">首页</a></li>
        <li><a href="SingerServlet?label=1">歌手</a></li>
        <li><a href="AlbumPageServlet?style=huayu">专辑</a></li>
        <li><a href="RankServlet">排行榜</a></li>
        <li><a href="MusicSheetServlet">分类歌单</a></li>
      </ul>
    </div>
  </header>
  


  <!-- 新歌首发 -->
  <div class="main" id="newSong">
    <div class="main-inner">
      <div class="main-title">
        <h2 class="title"><i></i></h2>
        <span class="line line-left"></span>
        <span class="line line-right"></span>
      </div>
      <a href="#" class="readAll">全部<i class="icon-sprite"></i></a>
      <div class="main-slider tab-cont">
        <ul class="slider-wrapper">
        <c:forEach items="${NewMusicList}" var="music" step="1" varStatus="status">
          <li>
            <a href="MusicInfoServlet?mid=${music.id }&&flag=1" class="img">
              <img src=${music.music_url } alt="#" style="width:100%">
              <span class="mask"></span>
              <i class="icon-play"></i>
            </a>
            <div class="info">
              <div class="title">
                <a href="MusicInfoServlet?id=${music.id }&&flag=1">${music.name }</a>
                <i class="icon-sprite"></i>
              </div>
              <a href="SingerDetail?singer_id=${music.singer_id }&&flag=0" class="author">${music.singer_name }</a>
            </div>
          </li>
       </c:forEach>
       
        </ul>
        <div class="slider-btns">
          <span class="cur"><i></i></span>
          <span><i></i></span>
          <span><i></i></span>
        </div>
      </div>
    </div>
    <div class="main-operate">
      <a href="javascript:;" class="slider-prev"><i class="icon-sprite"></i></a>
      <a href="javascript:;" class="slider-next"><i class="icon-sprite"></i></a>
    </div>
  </div>



  <!-- 排行榜 -->
  <div class="main" id="rank">
    <div class="main-inner">
      <div class="main-title">
        <h2 class="title"><i></i></h2>
        <span class="line line-left"></span>
        <span class="line line-right"></span>
      </div>
      <a href="#" class="readAll">全部<i class="icon-sprite"></i></a>
      <ul class="rank-list">
        <li class="rank-list__item rank-list__1">
          <span class="rank-bg"></span>
          <span class="mask"></span>
          <i class="icon-play"></i>
          <div class="title">
            <i></i>
            <h3>华语歌曲</h3>
          </div>
          <i class="line"></i>
          <ul class="song-list">
            <c:forEach items="${HHMusicList}" var="music" step="1" varStatus="status">
            <li class="song-list__item">
              <a href="MusicInfoServlet?mid=${music.id }&&flag=1"><span> ${status.index+1 }</span>${music.name }</a>
              <span> ${music.singer_name }</span>
            </li>
           </c:forEach>
          </ul>
        </li>
        <li class="rank-list__item rank-list__2">
          <span class="rank-bg"></span>
          <span class="mask"></span>
          <i class="icon-play"></i>
          <div class="title">
            <i></i>
            <h3>热歌</h3>
          </div>
          <i class="line"></i>
          <ul class="song-list">
           <c:forEach items="${MusicList}" var="music" step="1" varStatus="status">
            <li class="song-list__item">
              <a href="MusicInfoServlet?mid=${music.id }&&flag=1"><span> ${status.index+1 }</span>${music.name }</a>
              <span> ${music.singer_name }</span>
            </li>
           </c:forEach>
          </ul>
        </li>
        <li class="rank-list__item rank-list__3">
          <span class="rank-bg"></span>
          <span class="mask"></span>
          <i class="icon-play"></i>
          <div class="title">
            <i></i>
            <h3>新歌</h3>
          </div>
          <i class="line"></i>
          <ul class="song-list">
            <c:forEach items="${HMusicList}" var="music" step="1" varStatus="status">
            <li class="song-list__item">
              <a href="MusicInfoServlet?mid=${music.id }&&flag=1"><span> ${status.index+1 }</span>${music.name }</a>
              <span> ${music.singer_name }</span>
            </li>
           </c:forEach>
          </ul>
        </li>
        <li class="rank-list__item rank-list__4">
          <span class="rank-bg"></span>
          <span class="mask"></span>
          <i class="icon-play"></i>
          <div class="title">
            <i></i>
            <h3>欧美歌曲</h3>
          </div>
          <i class="line"></i>
          <ul class="song-list">
            <c:forEach items="${HOMusicList}" var="music" step="1" varStatus="status">
            <li class="song-list__item">
              <a href="MusicInfoServlet?mid=${music.id }&&flag=1"><span> ${status.index+1 }</span>${music.name }</a>
              <span> ${music.singer_name }</span>
            </li>
           </c:forEach>
          </ul>
        </li>
      </ul>
    </div>
  </div>

  <!-- 热门歌单 -->
  <div class="main" id="hotSong">
    <div class="main-inner">
      <div class="main-title">
        <h2 class="title"><i></i></h2>
        <span class="line line-left"></span>
        <span class="line line-right"></span>
      </div>
      <div class="main-slider">
        <ul class="slider-wrapper">
        
        <c:forEach items="${MusicSheetList}" var="sheet" step="1" varStatus="status">
          <li>
            <a href="SheetDetail?msid=${sheet.id }&&flag=0" class="img">
              <img src=${sheet.cover_url } alt="#" style="width:100%">
              <span class="mask"></span>
              <i class="icon-play"></i>
            </a>
            <div class="info">
              <div class="title">
                <!-- <a href="#">那个静默的阳光午后</a> -->
                <a href="SheetDetail?msid=${sheet.id }&&flag=0">${sheet.name }</a>
                <i class="icon-sprite"></i>
              </div>
              <a href="#" class="author">热度 : ${sheet.heat }</a>
            </div>
          </li>
        </c:forEach>
        </ul>
        <div class="slider-btns">
          <span class="cur"><i></i></span>
          <span><i></i></span>
          <span><i></i></span>
        </div>
      </div>
    </div>
    <div class="main-operate">
      <a href="javascript:;" class="slider-prev"><i class="icon-sprite"></i></a>
      <a href="javascript:;" class="slider-next"><i class="icon-sprite"></i></a>
    </div>
  </div>
  <div style="display:block;width:900px;margin:auto">
  <c:forEach items="${SingerList}" var="s" step="1" varStatus="status">
       <div class="single-featured-cars" style="margin:20px;float:left">
					<div class="featured-img-box"  >
						<div class="featured-cars-img">
							<a href="SingerDetail?singer_id=${s.id }&&flag=0"><img src= "${s.img_url }" /></a> 
						</div>
						<div class="featured-model-info">
							<p>
								<span class="featured-hp-span">${s.name }</span>
							</p>
						</div>
					</div>
			</div>
       
      </c:forEach>
  </div>




  <script src="js/jquery.min.js"></script>
  <script src="js/script.js"></script>
<script>
	//$document.ready()
	/*$.ajax({
             type: "POST",
             url: "indexServlet",
             contentType: 'application/x-www-form-urlencoded;charset=utf-8',
             success: function(data){
                 $("#index").html("");
             },      
         });*/
</script>
</body>
</html>