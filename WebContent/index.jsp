<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>文件管理系统首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="http://fonts.googleapis.com/css?family=Oxygen|Marck+Script" rel="stylesheet" type="text/css">
<link href="Css/bootstrap.css" rel="stylesheet">
<link href="Css/font-awesome.css" rel="stylesheet">
<link href="Css/index.css" rel="stylesheet">
<link href="Css/admin.css" rel="stylesheet">
<script src="Js/jquery.min.js"></script>
<script src="Js/bootstrap.js"></script>
<script src="Js/excanvas.min.js"></script>
<script src="Js/jquery.flot.min.js"></script>
<script src="Js/jquery.flot.resize.js"></script>
</head>    
<body>
<div style="width:1300px;height:640px;">
	<div class="row-fluid" style="background-color:#708090">
		<div class="span12" >
			<ul class="nav nav-tabs" style="height:60px">
				<li class="active">
					<h1 style="line-height:60px;text-align:center;color:white"><i class="icon-shopping-cart"></i>文件管理系统</h1>
				</li>
				<li style="margin-left:400px">
					<a href="#" style="height:40px;line-height:40px;color:white">列表显示</a>
				</li>
				<li>
					<a data-toggle="modal" href="#creatFileFolderItem"style="height:40px;line-height:40px;color:white">新建文件夹</a>
				</li>
				<li>
					<a data-toggle="modal" href="#createFileItem" style="height:40px;line-height:40px;color:white">新建文件</a>
				</li>
				<li>					
					<a data-toggle="modal" href="#FileUploadItem"style="height:40px;line-height:40px;color:white">上传文件</a>
				</li>
				<li>					
					<a href="history.action?user=${user}"style="height:40px;line-height:40px;color:white">历史记录</a>
				</li>
				<li>
					<a href="#" style="height:40px;line-height:40px;color:white">ZIP批量上传</a>
				</li>
				<li class="disabled">
					<a href="recyleList.action" style="height:40px;line-height:40px;color:white">回收站</a>
				</li>
				<li class="dropdown pull-right">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="height:40px;line-height:40px;color:white"><i class="icon-user"></i><s:property value="msg"/>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="Login.jsp">登录</a>
						</li>
						<li>
							<a href="Register.jsp">注册</a>
						</li>
						<li>
							<a href="Login.jsp">退出</a>
						</li>
						<li class="divider">
						</li>
						<li>
							<a href="#">其他操作</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	
	
	<div class="row">		
		<div class="span2">		
		<div class="main-left-col" style="background-color:#778899">		
			<h1><i class="icon-shopping-cart icon-large"></i>Adminize</h1>			
			<ul class="side-nav">
				<li class="active">
					<a href="#"><i class="icon-home"></i>共享文件管理</a>
				</li>				
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#website-dropdown" href="#"><i class="icon-sitemap"></i>共享文件夹<b class="caret"></b></a>
					<ul id="website-dropdown" class="collapse">
					    <s:iterator value="listFolder" status="li">
						<li><a href="fileList.action?fileFolderName=${fileFolderName}"><s:property value="fileFolderName"/></a></li>						
						</s:iterator>
					</ul>
				</li>   
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#store-dropdown" href="#"><i class="icon-shopping-cart"></i> 专属记忆 <b class="caret"></b></a>
					<ul id="store-dropdown" class="collapse">
						<li><a href="listing.html">Catalogue</a></li>
						<li><a href="orders.html">Orders</a></li>
						<li><a href="listing.html">Enquiries</a></li>
					</ul>
				</li>             
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#reports-dropdown" href="#"><i class="icon-signal"></i> 我的书签 <b class="caret"></b></a>
					<ul id="reports-dropdown" class="collapse">
						<li><a href="#">Sales Reports</a></li>
						<li><a href="#">Product Popularity</a></li>
						<li><a href="#">Member Registrations</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#members-dropdown" href="#"><i class="icon-group"></i> 其他精彩 <b class="caret"></b></a>
					<ul id="members-dropdown" class="collapse">
						<li><a href="#">Members</a></li>
						<li><a href="#">User Groups</a></li>
						<li><a href="#">Permissions</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#settings-dropdown" href="#"><i class="icon-cogs"></i>  设置  <b class="caret"></b></a>
					<ul id="settings-dropdown" class="collapse">
						<li><a href="#">Payment Processors</a></li>
						<li><a href="#">Order Statuses</a></li>
						<li><a href="#">Shipping Methods</a></li>
						<li><a href="#">Emails</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="icon-bullhorn"></i> 公告 <span class="badge badge-warning">2</span></a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#help-dropdown" href="#"><i class="icon-info-sign"></i>  帮助  <b class="caret"></b></a>
					<ul id="help-dropdown" class="collapse">
						<li><a href="#">联系 Admin</a></li>
						<li class="active"><a href="#">Admin_Email</a></li>
						<li><a href="#">系统介绍</a></li>
					</ul>
				</li>
			 </ul>		
		   </div>	
	   </div>	
    </div>  
      
	<div class="row" style="margin-left:150px;margin-top:-450px;z-index:3">				
				<div class="span10" >				
					<div class="slate">						
						<form class="form-inline" action="searchFile" method="post"  style="margin-left:620px">					 							
							<input type="text" name="searchInfo" class="input-large" placeholder="请输入搜索文件关键字">
							<button type="submit" class="btn btn-primary">搜索文件</button>
						</form>
					
					</div>
				
				</div>
			
	</div>
	
	<div class="row" style="margin-left:150px;margin-top:-450px">				
		<div class="span10">				
			<div class="slate">			
				<div class="page-header">
					<h2>文件清单</h2>
				</div>			
				<table class="orders-table table">
				<thead>
					<tr>
						<th>文件名</th>					
						<th>大小</th>	
						<th>出自</th>
						<th>最后更新时间</th>				
						<th class="actions">操作</th>
					</tr>
				</thead>
				<tbody>
				    <s:iterator value="listFile" status="li">
					<tr>					   
					    <td><a href="#"><s:property value="fileName"/></a><br/><span class="meta">Added Today</span></td>
						<td><a href="#"><s:property value="fileSize"/></a></td>	
						<td><a href="#"><s:property value="uploadUserName"/></a></td>											
						<td><a href="#"><s:property value="date"/></a></td>
						<td class="actions">
							<a class="btn btn-small btn-danger" data-toggle="modal" href="deleteFile.action?fileID=${fileID}">删除</a>						
							<a class="btn btn-small btn-primary" href="form.html">查看</a>	
							<!-- <a class="btn btn-small btn-primary"  href="updateFileName.jsp?fileID=${fileID}">重命名</a>	 -->					
							<a class="btn btn-small btn-primary" href="filedownload.action?fileName=${fileName}">下载</a>
						</td>
					</tr>
			        </s:iterator>
				</tbody>
				</table>
			</div>		
	   </div>				

	    <div class="modal hide fade" id="creatFileFolderItem">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>创建文件夹</h3>
			</div>
			<div class="modal-body" style="margin-left:120px">
				<form action="fileFolder" method="post">
					文件夹名:&nbsp<input type="text" name="folderName"/><br>
					关  键 字:&nbsp<input type="text" name="keyInfor" /><br>								
			    <a href="#" class="btn" data-dismiss="modal">取消</a>
			  <input type="submit" value="确定" <a href="#" class="btn btn-danger"></a>>
			</form>	
			</div>
			<div class="modal-footer">
			
			</div>
		</div>
		
		
		<div class="modal hide fade" id="FileUploadItem">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>文件上传</h3>
			</div>
			<div class="modal-body">
				<div style="width:320px;height:200px;margin-left:100px;"> 
					<form action="fileupload" method="post" enctype="multipart/form-data">
					    文件主题：<input type="text"/><br>
					    关 键 字：  <input type="text"/><br>
					    选择附件：<input type="file" name="myFile"/><br>
					    所属文件夹：
				     <select name="fileFolder" style="border-color:#33CCFF">
	                   <option value="0">选择</option>
	                   <s:iterator value="listFolder" status="li">
		                   <option value=<s:property value="fileFolderName"/>><s:property value="fileFolderName"/></option>		                   
	                   </s:iterator>             
	                 </select><br>
	                 <input value="取消" class="btn" data-dismiss="modal"/>
	                 <input type="submit" value="上传" class="btn btn-danger"/>		
					 </form> 
				 </div>			  
			</div>
		</div>
		
				
		
		<div class="modal hide fade" id="createFileItem">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>新建文件</h3>
			</div>
			<div class="modal-body">
				<div style="width:320px;height:200px;margin-left:100px;"> 
					<form action="createNewFile" method="post" enctype="multipart/form-data">
					    文  件  名：<input type="text" name="fileName"/><br>
					    关  键  字： <input type="text"/ name="keyWord"><br>
					    文件类型：<select name="content" style="border-color:#33CCFF">
	                   <option value="0">选择</option>
	                   <option value=".doc">.doc</option>
	                   <option value=".xsl">.xsl</option>
	                   <option value=".csv">.csv</option>
	                   <option value=".txt">.txt</option>
	                   <option value=".zip">.zip</option>
	                   </select><br>
					    所属文件夹：
				     <select name="fileFolder" style="border-color:#33CCFF">
	                   <option value="0">选择</option>
	                   <s:iterator value="listFolder" status="li">
		                   <option value=<s:property value="fileFolderName"/>><s:property value="fileFolderName"/></option>		                   
	                   </s:iterator>             
	                 </select><br>
	                 <input value="取消" class="btn" data-dismiss="modal"/>
	                 <input type="submit" value="确定" class="btn btn-danger"/>		
					 </form> 
				 </div>			  
			</div>
		</div>
	
		<div class="span5">
		
			<div class="pagination pull-left">
				<ul>
					<li><a href="#">上一页</a></li>
					<li class="active">
					  <a href="#">1</a>
					</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">下一页</a></li>
				</ul>
			</div>		
		</div>
				
		<div class="span5 listing-buttons pull-right">		
			<button class="btn btn-info">全选</button>
		
			<button class="btn btn-success">删除</button>
		
			<button class="btn btn-primary">下载</button>		
		</div>				
        </div>
        <div class="container-fluid" style="background-color:#708090;margin-top:50px;">
		   <div class="row-fluid" style="color:white;margin-left:580px">
			  <div class="span12">
				 <address> <strong>-----------JAVAEE-----------</strong><br /> CurriculumDesign大作业<br/>
				 </address>
			  </div>
		  </div>
        </div>
</div>
</body>
</html>