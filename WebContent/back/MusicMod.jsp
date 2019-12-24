<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="space.bean.Music" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<%
	if(request.getAttribute("musics")==null){
		%>
		<jsp:forward page="MusicModInitServlet?currentPage=1&pagesize=5"></jsp:forward>
<% 	}
%>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <!--<div class="padding border-bottom">  
  <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span class="icon-plus-square-o"></span> 添加内容</button>
  </div>-->
  <table class="table table-hover text-center">
    <tr>
      <th width="7.7%">歌曲id</th>
      <th width="7.7%">歌曲名</th>
      <th width="7.7%">热度</th>
      <th width="7.7%">所属专辑id</th>
      <th width="7.7%">所属专辑名称</th>
      <th width="7.7%">文件地址</th>
      <th width="7.7%">上传时间</th>
      <th width="7.7%">歌手id</th>
      <th width="7.7%">歌手姓名</th>
      <th width="7.7%">时长</th>
      <th width="7.7%">封面图</th>
      <th width="15.3%">操作</th>

    </tr>
   	<c:forEach items="${musics }" var="gequ" step="1" varStatus="status">	
    <tr>
      <td>${gequ.id}</td>     
      <td>${gequ.name}</td>     
      <td>${gequ.heat}</td>
      <td>${gequ.album_id}</td>
      <td>${gequ.album_name}</td>
      <td>${gequ.music_url}</td> 
      <td>${gequ.update_time}</td> 
      <td>${gequ.singer_id}</td> 
      <td>${gequ.singer_name}</td> 
      <td>${gequ.time}</td> 
      <td><img src="${gequ.cover_url}" alt="" width="120" height="50" /></td>
      <td><div class="button-group">
      <a class="button border-main" href="javascript:void(0)" onclick="init('${gequ.id}')"><span class="icon-edit"></span> 修改</a>
      <a class="button border-red" href="javascript:void(0)" onclick="del('${gequ.id}')"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
    </tr>
</c:forEach>
		   <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="MusicModInitServlet?currentPage=1">首页</a>
        <c:if test="${page.currentPage!=1 }">
          <span><a href="MusicModInitServlet?currentPage=${page.currentPage-1 }">上一页</a></span> 
        </c:if>
        <c:if test="${page.currentPage!=1 }">
        <span class="notCursor currentPage"><a href="MusicModInitServlet?currentPage=${page.currentPage-1 }" >${page.currentPage-1 }</a></span>
       	</c:if>
        <span class="notCursor currentPage"><a href="MusicModInitServlet?currentPage=${page.currentPage }" >${page.currentPage }</a></span>
   		<c:if test="${page.currentPage!=page.pageCount }">
   		<span class="notCursor currentPage"><a href="MusicModInitServlet?currentPage=${page.currentPage+1 }">${page.currentPage+1 }</a></span>
       	</c:if>
       <c:if test="${page.currentPage!=page.pageCount }">
          <span><a href="MusicModInitServlet?currentPage=${page.currentPage+1 }">下一页</a></span>
        </c:if>
       <span><a href="MusicModInitServlet?currentPage=${page.pageCount }">尾页</a></span> </div></td>
      	</tr>
  </table>
 
</div>
<script type="text/javascript">
function del(idd){
	var idx=idd;
	if(confirm("您确定要删除吗?")==true){
		window.location="MusicAddServlet?flag=del&Id="+idx;	
	}
	var func=function(){
		self.location.reload(true);
	}
	setTimeout(func,1000);
}
function init(id) { 
		document.getElementById("Id").value=id;
		var url=window.location.href;
		if(url.split('#')[1]=="add"){
				window.self.location=url;
		}else{
			window.self.location=url+"#add";
		}
}
</script>
<div class="panel admin-panel margin-top" id="add">

<div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 更改内容</strong></div>
  <div class="body-content">
    <form method="get" class="form-x" action="MusicAddServlet">  
    <input type="hidden" name="flag" value="mod">  
    <input type="hidden" name="Id" value="" id="Id">  
      <!--<div class="form-group">
        <div class="label">
          <label>歌曲id：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="id" data-validate="required:请输入歌曲id" />
          <div class="tips"></div>
        </div>
      </div>-->
      <div class="form-group">
        <div class="label">
          <label>歌曲名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="name" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>热度：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="heat" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>所属专辑id：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="album_id" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>所属专辑名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="album_name" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>文件地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="music_url" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>上传时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="update_time" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>歌手id：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="singer_id" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>歌手姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="singer_name" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>时长：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="time" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>封面图：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="img" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-image="" />
          <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"  style="float:left;">
          <div class="tipss">图片尺寸：1920*500</div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body>
</html>