<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <!-- <div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 歌手设置</strong></div>-->
  <!--<div class="padding border-bottom">  
  <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span class="icon-plus-square-o"></span> 添加内容</button>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="10%">ID</th>
      <th width="10%">歌手姓名</th>
      <th width="15%">歌手图片</th>
      <th width="20%">简介</th>
      <th width="15%">操作</th>
    </tr>
    <tr>
      <td>1</td> 
      <td>XXX</td>
      <td><img src="images/11.jpg" alt="" width="120" height="50" /></td>
      <td>描述文字....</td>
      <td><div class="button-group">
      <a class="button border-main" href="#add"><span class="icon-edit"></span> 修改</a>
      <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1)"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
    </tr>
  </table>
</div>
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){
	
	}
}
</script>-->
<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加歌手</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="UserAddServlet?flag=singer">    
      <div class="form-group">
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