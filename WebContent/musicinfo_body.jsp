<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <!-- <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>-->
	<script src="https://code.jquery.com/jquery-3.4.1.js" ></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="js/pintuer.js"></script> 
</head>
    <style>
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
<audio src="${amusic.music_url }" controls="controls" style="position:fixed;top:500px;right:0">
</audio>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column" >
			<div class="row clearfix">
				<div class="col-md-4 column">
				<br />
					<img src="${amusic.cover_url}"  width="260px" height="260px"alt="260x260" src="v3/default3.jpg" />
				</div>
				<div class="col-md-1 column">
				</div>
				<div class="col-md-7 column">
					<h3>
						${amusic.name}
					</h3>
					<div class="row clearfix">
						<div class="col-md-2 column">
							<img src="${amusic.cover_url}" width="45px" height="45px" />
						</div>
						<div class="col-md-10 column">
							<br />
							<div class="music">   
							   歌手：<a href="SingerDetail?singer_id=${amusic.singer_id}&&flag=0" target="_top">${amusic.singer_name}</a>
							</div>	
						
						</div>
					</div>
					<div class="btn-group">
					     <br />
						 <a href="${amusic.music_url }" download="${amusic.name }" > 下载</a>
						 <button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-left"></em> 播放</button> 
						 <button onclick="showWindow()" class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-center"></em> 收藏</button>
						 
						 <ul id="showdiv" style=" margin: 5 auto; border: 1px solid #999; display: none;  z-index: 3; background: #fff">
						 <li style="display:block;height: 40px; font-size: 20px; " onclick="fun2('${sheet.id}','${amusic.id }')">
						 			
						 		</li>
						 	<c:forEach items="${sheet_list}" var="sheet" step="1" varStatus="status" >
						 		<li style="display:block;height: 40px; font-size: 20px; " onclick="fun2('${sheet.id}','${amusic.id }')">
						 			<button class="butt">${sheet.name}</button>
						 		</li>
						 	</c:forEach>
						 </ul>
						 <style>
						 	.butt:hover{
						 		background-color:lightgreen;
						 	}
						 </style>
						 <script type="text/javascript">
						 	
						 	function showWindow(showmsg) {
						        $('#showdiv').show();   //显示弹窗
						        $('.content').append(showmsg);    //追加内容
						        $('#cover').css('display','block'); //显示遮罩层
						        
						    }
						 	function closeWindow() {
						        $('#showdiv').hide();   //隐藏弹窗
						        $('#cover').css('display','none');     //显示遮罩层
						        $('#showdiv .content').html("");    //清空追加的内容
						    }
						 	function fun2(a,b){
						 		$.ajax({
						 			url:'likeServlet',
						 			type:'post',
						 			data:{
						 				sheetId:a,
						 				itemId:b,
						 				flag:"3"
						 			},
						 			success:function (){
						 				closeWindow();
						 				alert("添加音乐到歌单成功");
						 			}
						 		})
						 	}
						 </script>
						
						 <br />
						 <br />
						 <br />

					</div>
					<br />
					<p>
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-2 column">
		</div>
	</div>
</div>
  <br/>
  <br/>
  <div class="collector">
      <h4><b>有这首歌的歌单</b></h4>
      <hr align=left width=720 color=black size=2>
      
      <ul id="collector_info">
      <c:forEach items="${asheet}" var="sheet" step="1" varStatus="status" >
			<li id="col_pic"><a href="SheetDetail?msid=${sheet.id }&&flag=0" target="_top"><img src="${sheet.cover_url}" width="70px" height="70px"></a></li>
	  </c:forEach>
	  </ul>
	  
  </div>
  <br/>
  <br/>
  <div class="spacebar">
			
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
            		<textarea id="comm" cols="95" rows="5" name="usercomment">
			        </textarea>	
			        </div>
			        <div class="textbotton">
			            <input type="button" value="评论" onclick="fun('${user_id }','${amusic.id }')"/>
			            <script type="text/javascript">
			            	function fun(a,b){
			            		//var comm = document.getElementById("comm").value;
			            		var comm=$("#comm").val();
			            		alert(comm);
			            		$.ajax({
			            			url:'MusicInfoServlet',
			            			type:'post',
			            			data:{
			            				com:comm,
			            				t:"a",
			            				user_id:a,
			            				music_id:b
			            			},
			            			success:function(){
			            				alert("评论成功");
			            				document.getElementById("comm").value=""
			            			}
			            		})
			            	}
			            </script>
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
						<a  href="PersonalPageServlet?other=${c.user_id }" target="_top">${c.user_name}</a>:
						<p>${c.content}</p>
			        </div>
			        <hr align="left" width=722 color=cadetblue size=1>
            	</div>
            	<div class="spacebar1">
			        
                </div>
            	</c:forEach>
            	
            </div>
		</div>
</body>
</html>