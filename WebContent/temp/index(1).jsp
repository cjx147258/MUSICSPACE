<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Demo</title>
  <link rel="icon" href="favicons/1.png">

  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/index.css">
  <style>
			.main img{
				width: 450px;
				height: 300px;
				display: none;
				padding-left: 0px;
			}
			.main a{
				float:left;
			}
			
		</style>
</head>
<body onload="showImg(1)">

  <header class="header">
  	<!--引入悬浮播放器-->
  	
    <div class="header-container">
      <div class="header-top">
        <!--<a href="#" class="logo"></a>-->
        <nav class="header-nav">
          <ul>
            <li><a href="#" class="header-nav__cur">音乐馆</a></li>
            <li><a href="#">我的音乐</a></li>
            <!-- <li><a href="#">下载客户端</a></li> -->
            <!-- <li><a href="#">VIP</a></li> -->
          </ul>
        </nav>
        <div class="header-search">
          <input type="text" class="text" placeholder="here...">
          <div class="btn"><i class="icon-sprite"></i></div>
          <!-- <div class="result">
            <a href="#" class="result-item">
              <span class="rank">1</span>
              <span class="title">默</span>
              <span class="num">3.4万</span>
            </a>
            <a href="#" class="result-item">
              <span class="rank">2</span>
              <span class="title">侧田</span>
              <span class="num">3.4万</span>
            </a>
            <a href="#" class="result-item">
              <span class="rank">3</span>
              <span class="title">让我留在你身边</span>
              <span class="num">3.4万</span>
            </a>
            <a href="#" class="result-item">
              <span class="rank">4</span>
              <span class="title">皮皮虾我们走</span>
              <span class="num">3.4万</span>
            </a>
            <a href="#" class="result-item">
              <span class="rank">5</span>
              <span class="title">欢乐好声音</span>
              <span class="num">3.4万</span>
            </a>
            <div class="history">
              <span>搜索历史</span>
              <i class="icon-sprite"></i>
            </div>
          </div> -->
        </div>
        <div class="header-login">
          <!-- <a href="#" class="login">Login</a> -->
          <a href="#" class="open-green">login</a>
          <!-- <a href="#" class="open-vip">开通付费包</a> -->
          
        </div>
      </div>
      <ul class="header-subNav">
        <li><a href="index.html" class="subNav-cur">首页</a></li>
        <li><a href="singers.html">歌手</a></li>
        <li><a href="albums.html">专辑</a></li>
        <li><a href="rankpage.html">排行榜</a></li>
        <li><a href="musicsheets.html">分类歌单</a></li>
        <!-- <li><a href="#">MV</a></li> -->
      </ul>
    </div>
  </header>
  
    <!-- 精彩推荐 -->
  <div class="main" id="recommend" >
    <div>
			<img id="myImg1" src="images/11.jpg" border="1"/>
			<img id="myImg2" src="images/cont/mv_img1.jpg" border="1"/>
			<img id="myImg3" src="images/cont/mv_img2.jpg" border="1"/>
			<img id="myImg4" src="images/cont/mv_img3.jpg" border="1"/>
		</div>
		<div>
			<a href="javascript: showImg(1)">1</a>
			<a href="javascript: showImg(2)">2</a>
			<a href="javascript: showImg(3)">3</a>
			<a href="javascript: showImg(4)">4</a>
		</div>
  </div>

  <!-- 新歌首发 -->
  <div class="main" id="newSong">
    <div class="main-inner">
      <div class="main-title">
        <h2 class="title"><i></i></h2>
        <span class="line line-left"></span>
        <span class="line line-right"></span>
      </div>
      <a href="#" class="readAll">全部<i class="icon-sprite"></i></a>
      <div class="main-tab tab-title">
        <a href="javascript:;" class="item item-cur">全部</a>
        <a href="javascript:;" class="item">华语</a>
        <a href="javascript:;" class="item">欧美</a>
        <a href="javascript:;" class="item">日韩</a>
        <a href="javascript:;" class="item">粤语</a>
      </div>
      <div class="main-slider tab-cont">
        <ul class="slider-wrapper">
        <c:forEach items="${NewMusicList}" var="music" step="1" varStatus="status">
          <li>
            <a href="#" class="img">
              <img src=${music.music_url } alt="#">
              <span class="mask"></span>
              <i class="icon-play"></i>
            </a>
            <div class="info">
              <div class="title">
                <a href="#">${music.name }</a>
                <i class="icon-sprite"></i>
              </div>
              <a href="#" class="author">${music.singer_name }</a>
            </div>
          </li>
       </c:forEach>
       <c:forEach items="${HMusicList}" var="music" step="1" varStatus="status">
          <li>
            <a href="#" class="img">
              <img src=${music.music_url } alt="#">
              <span class="mask"></span>
              <i class="icon-play"></i>
            </a>
            <div class="info">
              <div class="title">
                <a href="#">${music.name }</a>
                <i class="icon-sprite"></i>
              </div>
              <a href="#" class="author">${music.singer_name }</a>
            </div>
          </li>
       </c:forEach>
       <c:forEach items="${OMusicList}" var="music" step="1" varStatus="status">
          <li>
            <a href="#" class="img">
              <img src=${music.music_url } alt="#">
              <span class="mask"></span>
              <i class="icon-play"></i>
            </a>
            <div class="info">
              <div class="title">
                <a href="#">${music.name }</a>
                <i class="icon-sprite"></i>
              </div>
              <a href="#" class="author">${music.singer_name }</a>
            </div>
          </li>
       </c:forEach>
       
        </ul>
        
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
              <a href="#"><span> ${status.index+1 }</span>${music.name }</a>
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
              <a href="#"><span> ${status.index+1 }</span>${music.name }</a>
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
            <c:forEach items="${NewMusicList}" var="music" step="1" varStatus="status">
            <li class="song-list__item">
              <a href="#"><span> ${status.index+1 }</span>${music.name }</a>
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
              <a href="#"><span> ${status.index+1 }</span>${music.name }</a>
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
            <a href="#" class="img">
              <img src=${sheet.cover_url } alt="#">
              <span class="mask"></span>
              <i class="icon-play"></i>
            </a>
            <div class="info">
              <div class="title">
                <!-- <a href="#">那个静默的阳光午后</a> -->
                <a href="#">${sheet.name }</a>
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


  <!-- 歌手入驻 -->
  <div class="main" id="mv">
    <div class="main-inner">
      <div class="main-title">
        <h2 class="title"><i></i></h2>
        <span class="line line-left"></span>
        <span class="line line-right"></span>
      </div>
      <a href="#" class="readAll">全部<i class="icon-sprite"></i></a>
      <div class="main-tab tab-title">
        <a href="javascript:;" class="item item-cur">全部</a>
        <a href="javascript:;" class="item">华语</a>
        <a href="javascript:;" class="item">欧美</a>
        <a href="javascript:;" class="item">港台</a>
        <a href="javascript:;" class="item">韩国</a>
        <a href="javascript:;" class="item">日本</a>
      </div>
      <ul class="mv-list tab-cont">
      <c:forEach items="${SingerList}" var="singer" step="1" varStatus="status">
           <li class="item">
          <a href="#" class="img"><img src=${singer.img_url } alt="#"><i class="icon-play"></i></a>
          <div class="info">
            <a href="#" class="author">${singer.name }</a>
            <span class="play-total"><i class="icon-sprite"></i>18.8万</span>
          </div>
        </li>
      </c:forEach>
      </ul>
    </div>
  </div>

  <!-- footer -->
  <footer class="footer">
    <div class="footer-inner">
      <div class="footer-info">
        <div class="footer-info__download">
          <h3>下载KK音乐客户端</h3>
          <ul class="list">
            <li><a href="#">
              <i class="footer-icon icon-pc"></i>
              PC版
            </a></li>
            <li><a href="#">
              <i class="footer-icon icon-mac"></i>
              Mac版
            </a></li>
            <li><a href="#">
              <i class="footer-icon icon-android"></i>
              Android版
            </a></li>
            <li><a href="#">
              <i class="footer-icon icon-iphone"></i>
              iPhone版
            </a></li>
          </ul>
        </div>
        <div class="footer-info__product">
          <h3>特色产品</h3>
          <ul class="list">
            <li class="hasPic"><a href="#">
              <i class="footer-icon icon-kg"></i>
              全民K歌
            </a></li>
            <li class="hasPic"><a href="#">
              <i class="footer-icon icon-ss"></i>
              全民K歌
            </a></li>
            <li class="hasPic"><a href="#">
              <i class="footer-icon icon-qp"></i>
              全民K歌
            </a></li>
            <li><a href="#">KK音乐原创音乐平台</a></li>
            <li><a href="#">上传视频</a></li>
            <li><a href="#">上传视频</a></li>
            <li><a href="#">上传视频</a></li>
          </ul>
        </div>
        <div class="footer-info__link">
          <h3>特色产品</h3>
          <ul class="list">
            <li><a href="#">CJ E&M</a></li>
            <li><a href="#">我们视频</a></li>
            <li><a href="#">手机KK空间</a></li>
            <li><a href="#">CJ E&M</a></li>
            <li><a href="#">我们视频</a></li>
            <li><a href="#">手机KK空间</a></li>
            <li><a href="#">CJ E&M</a></li>
            <li><a href="#">我们视频</a></li>
            <li><a href="#">手机KK空间</a></li>
            <li><a href="#">CJ E&M</a></li>
            <li><a href="#">我们视频</a></li>
            <li><a href="#">手机KK空间</a></li>
          </ul>
        </div>
      </div>
      <div class="footer-copyright">
        <p><a href="#">关于我们</a><span>|</span><a href="#">关于我们</a><span>|</span><a href="#">关于我们</a><span>|</span><a href="#">关于我们</a><span>|</span><a href="#">关于我们</a><span>|</span><a href="#">关于我们</a><span>|</span><a href="#">关于我们</a><span>|</span><a href="#">关于我们</a></p>
        <p>Copyright © 1998 - 2017 kk. All Rights Reserved.</p>
        <p>我们公司 版权所有 我们网络文化经营许可证</p>
      </div>
    </div>
  </footer>


  <!-- 分享到 -->
  <ul class="slider-share">
    <li><a href="#">
      <i class="icon-sprite icon-add"></i>
      添加到
      <i class="icon-sprite icon-arrow"></i>
    </a></li>
    <li><a href="#">
      <i class="icon-sprite icon-share"></i>
      分享
      <i class="icon-sprite icon-arrow"></i>
    </a></li>
    <li><a href="#">
      <i class="icon-sprite icon-download"></i>
      下载
    </a></li>
  </ul>

  <script src="js/jquery.min.js"></script>
  <script src="js/script.js"></script>
<script>
		var nowshow=1;//当前显示的图片
		var sid; //声明sid来接受setTimeOut返回置
		function showImg(index){
			
			if(Number(index)){
				clearTimeout(sid);
				nowshow=index;
			}
			for(var i=1;i<5;i++){
				if(i==nowshow){
					document.getElementById("myImg"+nowshow).style.display="block";
				}else{
					document.getElementById("myImg"+i).style.display="none";
				}
			}
			if(nowshow>=4){
				nowshow=1;
			}else{
				nowshow++;
			}
			sid=setTimeout("showImg()",2000);

//			document.getElementById("myImg"+index).style.display="block";
		}
	</script>
</body>
</html>