<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />MUSIC SPACE后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="indexServlet"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <!--<h2><span class="icon-user"></span>用户设置</h2>
  <ul style="display:block">
    <li><a href="UserAdv.html" target="right"><span class="icon-caret-right"></span>用户</a></li>
    <li><a href="SingerAdv.html" target="right"><span class="icon-caret-right"></span>歌手</a></li>
    <li><a href="MusicAdv.html" target="right"><span class="icon-caret-right"></span>音乐</a></li>  
    <li><a href="AlbumAdv.html" target="right"><span class="icon-caret-right"></span>专辑</a></li>   
  
  </ul>   -->
  <h2><span class="icon-user"></span>用户设置</h2>
  <ul style="display:block">
    <li><a href="UserAdd.jsp" target="right"><span class="icon-caret-right"></span>增加用户</a></li>
    <li><a href="UserMod.jsp" target="right"><span class="icon-caret-right"></span>更改用户</a></li>
  </ul> 
  <h2><span class="icon-user"></span>歌手设置</h2>
  <ul style="display:block">
    <li><a href="SingerAdd.jsp" target="right"><span class="icon-caret-right"></span>增加歌手</a></li>
    <li><a href="SingerMod.jsp" target="right"><span class="icon-caret-right"></span>更改歌手</a></li>
  </ul> 
  <h2><span class="icon-user"></span>音乐设置</h2>
  <ul style="display:block">
    <li><a href="MusicAdd.html" target="right"><span class="icon-caret-right"></span>增加音乐</a></li>
    <li><a href="MusicMod.jsp" target="right"><span class="icon-caret-right"></span>更改音乐</a></li>
  </ul> 
  <h2><span class="icon-user"></span>专辑设置</h2>
  <ul style="display:block">
    <li><a href="AlbumAdd.jsp" target="right"><span class="icon-caret-right"></span>增加专辑</a></li>
    <li><a href="AlbumMod.jsp" target="right"><span class="icon-caret-right"></span>更改专辑</a></li>
  </ul> 
  
  <!--<h2><span class="icon-pencil-square-o"></span>音乐设置</h2>
  <ul>
    <li><a href="MusicAdd.html" target="right"><span class="icon-caret-right"></span>增加音乐</a></li>
    <li><a href="MusicMod.html" target="right"><span class="icon-caret-right"></span>更改音乐</a></li>    
  </ul>
  <h2><span class="icon-pencil-square-o"></span>专辑设置</h2>
  <ul>
    <li><a href="AlbumAdd.html" target="right"><span class="icon-caret-right"></span>增加专辑</a></li>
    <li><a href="AlbumMod.html" target="right"><span class="icon-caret-right"></span>更改专辑</a></li>     
  </ul>-->
  
  <!--<h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
  <ul>
    <li><a href="list.html" target="right"><span class="icon-caret-right"></span>内容管理</a></li>
    <li><a href="add.html" target="right"><span class="icon-caret-right"></span>添加内容</a></li>
    <li><a href="cate.html" target="right"><span class="icon-caret-right"></span>分类管理</a></li>        
  </ul>  -->
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>

<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="UserAdd.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
<!--<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>-->
</div>
</body>
</html>