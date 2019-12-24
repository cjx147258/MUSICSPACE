<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script src="js/jquery-1.11.0.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  
  <table class="table table-hover text-center">
     <tr>
       <th width="5%"></th>
      <th width="5%">ID</th>
      <th width="10%">歌手姓名</th>
      
      <th width="15%">歌手图片</th>
      <th width="20%">简介</th>
      <th width="15%">操作</th>
     
    </tr>
   
   
     
     
       <c:forEach items="${singerList}" var="sig" step="1" varStatus="status"  >     
        <tr>
       
         <td>${sig.id}</td>
          <td>${sig.name}</td>  
           
          <td><img src=${sig.img_url }  width="50" height="50" /></td>         
          <td>${sig.info }</td>
          
          <td>
     <a class="button border-main" href="javascript:void(0)" onclick="return init(${sig.id})"><span class="icon-edit"></span> 修改</a>
      <a class="button border-red" href="javascript:void(0)" onclick="return del(${sig.id})"><span class="icon-trash-o"></span>删除</a>
          </td>
        </tr>
       </c:forEach>
      
      
     <tr>
        <td colspan="8">
        <div id="page"> 
        <c:if test="${singerList==null}">
          <jsp:forward page="SingerModServlet?flag=bypage&currentPage=1"></jsp:forward>
        </c:if>
        <a href="SingerModServlet?flag=bypage&currentPage=1">首页</a>
         <c:if test="${currentPage!=1 }">
        <a href="SingerModServlet?flag=bypage&currentPage=${currentpage-1 }">上一页</a> 
       </c:if>
        
        <a  href="SingerModServlet?flag=bypage&currentPage=${currentpage}">${currentpage}</a>
        <a href="SingerModServlet?flag=bypage&currentPage=${currentpage+1}">${currentpage+1}</a>
         <c:if test="${currentPage!=50 }">
           <a href="SingerModServlet?flag=bypage&currentPage=${currentpage+1}">下一页</a>
        </c:if>
        <a href="SingerModServlet?flag=bypage&currentPage=20">尾页</a>
       </div>
       </td>
      </tr>
      
    </table>
 </div>
<script type="text/javascript">
function del(id){
	if(confirm("您确定要删除吗?")){
		location.href="SingerModServlet?flag=del&id="+id;	
	}
}
function init(id) { 
	document.getElementById("Id").value=id;
	location.href="#add";
}

</script>
<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 更改内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="SingerModServlet?flag=ud&id=${sig.id}">    
      <div class="form-group">
      <input type="hidden" name="Id" value="" id="Id">
        <div class="label">
          <label>歌手姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="title" data-validate="required:请输入歌手姓名" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>歌手图片：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="img" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-image="" />
          <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"  style="float:left;">
          <!--<div class="tipss">图片尺寸：1920*500</div>-->
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>简介：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input" name="note" style="height:120px;" value=""></textarea>
          <div class="tips"></div>
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