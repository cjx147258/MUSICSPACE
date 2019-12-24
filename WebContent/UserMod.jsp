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
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong></div>
  <!--<div class="padding border-bottom">  
  <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span class="icon-plus-square-o"></span> 添加内容</button>
  </div>-->
  <table class="table table-hover text-center">
    <tr>
      <th width="16.8%">昵称</th>
      <th width="16.8%">用户id</th>
      <th width="16.8%">个性签名</th>
      <th width="16.8%">头像</th>
      <th width="16.8%">密码</th>
      <th width="16%">操作</th>
    </tr>
        
        <c:forEach var="user" items="${userList}" step="1" varStatus="status">
    <tr>
     
      <td>${user.name}</td>        
      <td>${user.id}</td>
      <td>${user.introduction}</td>
      <td><img src="${user.icon_url}" alt="" width="50" height="50" /></td>  
      <td>${user.password}</td>
      <td><div class="button-group">
    <a class="button border-main" href="javascript:void(0)" onclick="init(${user.id})"><span class="icon-edit"></span> 修改</a>
      <a class="button border-red" href="javascript:void(0)" onclick="return del(${user.id})"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
      
    </tr>
    </c:forEach> 

       <tr>
        <td colspan="8"><div > 
         <c:if test="${userList==null }">
        <jsp:forward page="UserModServlet?flag=userByPage&currentPage=1"></jsp:forward>
         </c:if>
        <a href="UserModServlet?flag=userByPage&currentPage=1">首页</a>
        <c:if test="${currentPage!=1 }">
          <span><a href="UserModServlet?flag=userByPage&currentPage=${currentpage-1 }">上一页</a></span> 
        </c:if>
        <a href="UserModServlet?flag=userByPage&currentPage=1">1</a>
        <c:if test="${currentPage!=1 }">
        <span class="notCursor currentPage"><a href="UserModServlet?flag=userByPage&currentPage=2" >2</a></span>
       	</c:if>
        <span class="notCursor currentPage"><a href="UserModServlet?flag=userByPage&currentPage=3}" >3</a></span>
   		
       <c:if test="${currentPage!=50 }">
          <span><a href="UserModServlet?flag=userByPage&currentPage=${currentpage+1 }">下一页</a></span>
        </c:if>
       <span><a href="UserModServlet?flag=userByPage&currentPage=3">尾页</a></span> 
       </div>
       </td>
      	</tr>
  </table>
</div>
<script type="text/javascript">
function del(id){
	if(confirm("您确定要删除吗?")){	
		
		location.href="UserModServlet?flag=delete&currentid="+id;
	}
	self.location.reload();
}
function init(id) { 
		document.getElementById("currentid").value=id;
		
		location.href="#add";
	}



</script>
<div class="panel admin-panel margin-top"  id = "add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 更改内容</strong></div>
  <div class="body-content">
    <form method="get" class="form-x" action="UserModServlet">  
    <input type="hidden" name="flag" value="update">  
    <input type="hidden" name="currentid" value="" id="currentid">  
      <div class="form-group">
        <div class="label">
          <label>昵称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="name" data-validate="required:请输入昵称" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="gender" data-validate="required:请输入性别" />
          <div class="tips"></div>
        </div>
      </div>
      <!--<div class="form-group">
        <div class="label">
          <label>用户id：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="id" value=""  />
          <div class="tips"></div>
        </div>
      </div>-->
      <div class="form-group">
        <div class="label">
          <label>个性签名：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input" name="introduction" style="height:120px;" value=""></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>头像：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="img" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-image="" />
          <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"  style="float:left;">
          <div class="tipss">图片尺寸：1920*500</div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="password" value=""  />
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