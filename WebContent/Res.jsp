<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>搜索结果</title>
  <link rel="icon" href="favicons/1.png">

  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/index.css">


<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="js/music.js"></script>
<link rel="stylesheet" type="text/css" href="css/music_table.css"/>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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
    </div>
  </header>
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
					<c:forEach items="${MusicList}" var="music" step="1" varStatus="status">
					<tr class="success">
						<td>
							<a href="MusicInfoServlet?flag=1&&mid=${music.id }">${music.name }</a>
						</td>
						<td>
							<a href="SingerDetail?flag=0&&singer_id=${music.singer_id }">${music.singer_name }</a>
						</td>
						<td>
							<a href="#">${music.album_name }</a>
						</td>
						<td>
							${music.time }
						</td>
						<td>
							<button type="button" value="当前音乐id" class="playmusic">播放</button>
							<button type="button" value="当前音乐id"  class="collectmusic">收藏</button>
							<button type="button" value="当前音乐id" class="addplaylist">加入列表</button>
						</td>
						<td>
							${music.heat }
						</td>
					</tr>
					</c:forEach>
			
				</tbody>
			</table>
		</div>
			
<!-- 		</div>
	</div>
</div> -->
</body>

</html>