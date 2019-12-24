<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <meta charset="UTF-8">
    <title>歌单详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="js/music.js"></script>
    <link rel="stylesheet" type="text/css" href="css/music_table.css"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
< <style>
            .spacebar{
            	display: inline-block;
            	width:auto;
	            height:30px;
            }
            .spacebar1{
                display: inline-block;
            	width:auto;
	            height:120px;
            }
            .content_input{
            	display: inline-block;
            	width:auto;
            	height:250px;
            }
            .content{
            	margin: auto;
            	width: 750px;
            }
            .input_title{
            	display: inline-block;
            	width:auto;
            	height:25px;
            	text-align:end;
            }
            .intput_info{
            	width:auto;
            	height:150px;
            }
            .userimg{
            	display: inline-block;
            	width:55px;
            	height:55px;
            	position: relative;
            	top:0px;
            	left:0px;
            }
            .input_text{
            	position: relative;
            	bottom:45px;
            	left:80px;
            }
            .content_details{
            	display: inline-block;
            	width:auto;
            	height:80px;
            }
            .collector,.sheet{
                margin: auto;
            	width: 750px;
            	height:100px;
            }
            #collector_info{
                list-style-type: none;
                display:inline-block;
            }
            #col_pic{
            float:left;
            margin:10px;
            }
            #sheet_info{
                list-style-type: none;
                display:inline-block;
            }
            .textbotton{
                position: relative;
            	bottom:35px;
            	left:650px;
            }
    </style> 

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column">
			<div class="row clearfix">
				<div class="col-md-4 column">
				<br />
					<img src="${amusic_sheet.cover_url}"  width="260px" height="260px"  />
				</div>
				<div class="col-md-1 column">
				</div>
				<div class="col-md-7 column" >
					<h3>
						    ${amusic_sheet.name}
					</h3>
					<div class="row clearfix">
						<div class="col-md-2 column">
							<img src=" ${owner.icon_url}"  width="45px" height="45px"alt="45x45"  />
						</div>
						<div class="col-md-10 column">
							<br />
							<div class="music">   
							   创建人：<a href="PersonalPageServlet?other=${owner.id }" target="_top"> ${owner.name}</a>
							${ owner.id }
							   创建时间： ${amusic_sheet.update_time}
							</div>	
						
						</div>
					</div>
					<div class="btn-group">
					     <br />
						 <button class="btn btn-default" type="button" 
						 onclick="fun('${user_id}','${amusic_sheet.id }')"
						 ><em class="glyphicon glyphicon-align-left"></em> 收藏</button>  
						 <br />
						 <br />
						 <br />

					</div>
					<br />
				
					<p>
					    
						标签：
						<!--  <a href="">aa</a>-->
						<c:forEach items="${style_sheet}" var="ss" step="1" varStatus="status" >  
						<a href="MusicStyleServlet?style=${ss.style_id }"  target="_top">${ss.style }</a>
							</c:forEach>
						
					</p>

					<br />
					<p>
						介绍： ${amusic_sheet.info}
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-2 column">
		</div>
		<div>
		 <br />
		    <br />
		    <br />
		    <br />
		    <br /> 
		     <br />
		    <br />
		    <br />
		    <br />
		    <br />
		    <br />
		    <br />
		    <br />
		    <br /> 
		     <br />
		    <br />
		    <br />
		    <br />
		</div>
		<div class="musictable">
			<table class="table">
				<thead>
					<tr>
						<th >
							歌曲标题
						</th>
						<th>
							歌手
						</th>
						<th>
							专辑
						</th>
						<th>
							时长
						</th>
						<th>
							操作
						</th>
						<th>
							热度
						</th>
					</tr>
				</thead>
				<tbody>
							<!-- foreach循环输出每一行 href到对应的详情servlet -->
							
  							<c:forEach items="${amusic}" var="m" step="1" varStatus="status" >  
							<tr class="success">
								<td>
									<a href="MusicInfoServlet?mid=${m.id }&&flag=1 " target="_top">${m.name}</a>
								</td>
								<td>
									<a href="SingerDetail?singer_id=${m.singer_id }&&flag=0" target="_top">${m.singer_name}</a>
								</td>
								<td>
									<a href="AlbumDetailServlet?album_id=${m.album_id }&&flag=0" target="_top">${m.album_name} </a>
								</td>
								<td>
									${m.time}
								</td>
								<td>
									<button type="button" value="当前音乐id" class="playmusic">播放</button>
									<button type="button" value="当前音乐id"  class="collectmusic">收藏</button>
									
								</td>
								<td>
									${m.heat}
								</td>
							</tr>
							</c:forEach>
						</tbody>
				
			</table>
		</div>
	</div>
</div>

  <!--评论区-->
		<div class="content">
            <div class="content_input">
            	<div>
            	<h4><b>评论</b></h4>
            	<hr align=center width=720 color=black size=2>
            	</div>
            	<div class="input_info">
            		<div class="userimg">
            		<img src="${auser.icon_url}" width="45px" height="45px" />
                    </div>
            		<div class="input_text">
            		<textarea cols="95" rows="5" name="usercomment"> 
				请输入评论
			        </textarea>	
			        </div>
			        <div class="textbotton">
			            <input type="button" value="评论" />
			        </div>
            	</div>
            </div>
            <div class="content_info">
            	<div>
            	<h5><b>精彩评论</b></h5>
            	<hr align="left" width=722 color=cadetblue size=2>
            	</div>
            	<c:forEach items="${acontent}" var="c" step="1" varStatus="status" >
            	<div class="content_details">
            		<div class="other_userimg">
            		<img src="${c.user_url}" width="45px" height="45px" />
                    </div>
            		<div class="input_text">
						<a href="PersonalPageServlet?other=${c.user_id }" target="_top">${c.user_name}</a>:
						<p>${c.content}</p>
			        </div>
			        <hr align="left" width=722 color=cadetblue size=1>
            	</div>
            	<div class="spacebar1">
			        
                </div>
            	</c:forEach>
            	
            </div>
		</div>

<script type="text/javascript">
function fun(a,b){

	$.ajax({
		 url:'likeServlet',
		 type:'post',
		 data:{
			 uid:a,
			 itemId:b,
			 flag:'0'
		 },
		 success:function (){
		 alert('已收藏歌单');
		 }
	})
}
</script>
</body>
</html>