<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>歌手专辑</title>
</head>

<style>
    #d {
        height:5000px;
        width:840px;
        margin:auto;
        border:1px solid #FFFFFF;
    }
    .d1{
        height:50px;
        width:820px;
        border:1px solid #FFFFFF;
        /*Margin:10px;*/
        float:left;
    }
    .d2 {
        height:500px;
        width:500px;
        border:1px solid #999999;
        /*Margin:15px;*/
        float:left;
    }
    .d3{
        height:500px;
        width:820px;
        border:1px solid #999999;
        /*Margin:10px;*/
        float:left;
    }
    .d4{
        height:180px;
        width:160px;
        border:1px solid #999999;
        Margin:10px;
        float:left;
    }
    .d5{
        height:120px;
        width:120px;
        margin:auto;
        border:1px solid #999999;
    }

    #ul{
        display:table;
        padding:10px;
        margin:auto;
        width:90px;
    }
    li{
        text-align:center;
    }

    /*<style type="text/css">*/
    /*设置div样式的整体布局*/

    .page-icon{
      margin:20px 0 0 0;/*设置距离顶部20像素*/
      font-size:0;/*修复行内元素之间空隙间隔*/
      text-align:center;/*设置内容居中显示*/
    }

    /*设置共有的的样式布局，主要是进行代码优化，提高运行效率*/
    .page-icon a,.page-disabled,.page-next{
        border:1px solid #ccc;
        border-radius:3px;
        padding:4px 10px 5px;
        font-size:14PX;/*修复行内元素之间空隙间隔*/
        margin-right:10px;
    }

    /*对 a 标签进行样式布局 */
    .page-icon a{
        text-decoration:none;/*取消链接的下划线*/
        color:#005aa0;
    }

    .page-current{
        color:#ff6600;
        padding:4px 10px 5px;
        font-size:14PX;/*修复行内元素之间空隙间隔*/
    }

    .page-disabled{
        color:#ccc;
    }

    .page-next i,.page-disabled i{
        cursor:pointer;/*设置鼠标经过时的显示状态，这里设置的是显示状态为小手状态*/
        display:inline-block;/*设置显示的方式为行内块元素*/
        width:5px;
        height:9px;
        background-image:url(http://img.mukewang.com/547fdbc60001bab900880700.gif);/*获取图标的背景链接*/
    }
    .page-disabled i{
        background-position:-80px -608px;
        margin-right:3px;
    }

    .page-next i{
        background-position:-62px -608px;
        margin-left:3px;
    }


</style>

<body>

<div id="d">

<!--    <div class="d2">-->
<!--        <img width=100% height=100% src="../images/post2.jpg" title="。。"/>-->
<!--    </div>-->
    <div class="container-fluid">
        <div class="row-fluid">
            <r class="span8">
                <div class="page-header">
                    <h1>
                         ${requestScope.Singer_album.name}
                    </h1>
                </div>

<!--                歌手图片-->
                <div class="d2">
                    <img width=100% height=100% src=${Singer_album.img_url} title=${Singer_album.name}>
                </div>

                <div class="d1">
                    <ul class="nav nav-tabs">
                        <li>
                            <a href=" SingerDetail?id=${Singer_album.id}&&flag=3">热门作品</a>
                        </li>
                        <li class="active">
                            <a href=" SingerDetail?id=${Singer_album.id}&&flag=2">所有专辑</a>
                        </li>
                        <li>
                            <a href=" SingerDetail?id=${Singer_album.id}&&flag=1">艺人介绍</a>
                        </li>
    
                    </ul>
                </div>

                <p>             </p>
                <p>             </p>


                <div class="d3">
				  		<c:forEach items="${AlbumList}" var="a" step="1" varStatus="status" >     
				          <li style="float: left; margin-left: 10px">
				          <div class="single-featured-cars">
									<div class="featured-img-box">
									<a href="AlbumDetailServlet?album_id=${a.id }&&flag=0" target="_top">
										<div class="featured-cars-img">
											<img src= ${a.cover_url } alt="cars">
										</div>
										</a>
										<div class="featured-model-info">
											<p>
												
												<!-- 图标: 播放量 -->
												<!-- <span class="featured-mi-span"></span> -->
												<span class="featured-hp-span">${a.name }</span>
											</p>
										</div>
									</div>
						
							</div>
				          </li>
				       </c:forEach> 
                </div>


                </div>


    </div>

</div>

</body>
</html>