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
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="js/music.js"></script>
    <link rel="stylesheet" type="text/css" href="css/music_table.css"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column">
			<div class="row clearfix">
				<div class="col-md-4 column">
				<br />
					<img src=${Album.cover_url}  width="260px" height="260px"  />
				</div>
				<div class="col-md-1 column">
				</div>
				<div class="col-md-7 column" >
					<h3>
						专辑: ${Album.name}
					</h3>
					<div class="row clearfix">
						<div class="col-md-2 column">
							<img src=" "  width="45px" height="45px"alt="45x45"  />
						</div>
						<div class="col-md-10 column">
							<br />
							<div class="music">   
							   <a href="SingerDetail?singer_id=${Album.singer_id }&&flag=0" target="_top">歌手：${Album.singer_name}</a>
							   <p>		</p>
							  发行时间：${Album.issue_time}
							</div>	
						
						</div>
					</div>
					<div class="btn-group">
					     <br />
					     
						 
						  
						  <input id="llll" type="button" onclick="fun('${user_id }','${ Album.id}' )" value="收藏" />

						   
						 <br />
						 <br />
						 <br />

					</div>
					<p>
						介绍： ${Album.info}
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
			<table class="table" style="weight:500px;margin:auto">
				<thead>
					<tr>
						<th >
							歌曲标题
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
							
  							<c:forEach items="${MusicList}" var="m" step="1" varStatus="status" >  
							<tr class="success">
								<td>
									<a href="MusicInfoServlet?mid=${m.id }&&flag=1" target="_top">${m.name}</a>
								</td>
								<td>
									${m.time}
								</td>
								<td>
									<button type="button" value="当前音乐id" class="playmusic">播放</button>
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

</body>
<script type="text/javascript">

 function fun(user_id,a_id){
	 
	 $.ajax({
			url:'likeServlet',          //请求的地址
			type:'post',                //请求的方式
			data:{                      //请求的参数
				uid:user_id,
				itemId:a_id,
				flag:"1"
			},
			success:function(){   //请求成功后的回调方法，result为请求的返回结果
				alert("收藏成功");
			},
			error:function(){
				alert("error");
			}
	})
} 
</script>
</html>