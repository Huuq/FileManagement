<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件清单</title>
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
<script type="text/javascript"></script>
</head>
<body>
<div class="row-fluid" style="background-color:#708090">
		<div class="span12" >
			<ul class="nav nav-tabs" style="height:60px">
				<li class="active">
					<h1 style="line-height:60px;text-align:center;color:white"><i class="icon-shopping-cart"></i>文件管理系统</h1>
				</li>
			</ul>
		</div>
	</div>
	
    <div class="row" style="margin-left:150px;margin-top:30px;">				
		<div class="span10">				
			<div class="slate">			
				<div class="page-header">
					<div class="btn-group pull-right">
						<button class="btn dropdown-toggle" data-toggle="dropdown">
							文件筛选
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="">CSV/XSL</a></li>
							<li><a href="">PDF</a></li>
							<li><a href="">DOCX</a></li>
							<li><a href="">DOX</a></li>
						</ul>
					</div>
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
				    <s:iterator value="fileList" status="li">
					<tr>					   
					    <td><a href="#"><s:property value="fileName"/></a><br/><span class="meta">Added Today</span></td>
						<td><a href="#"><s:property value="fileSize"/></a></td>	
						<td><a href="#"><s:property value="uploadUserName"/></a></td>											
						<td><a href="#"><s:property value="date"/></a></td>
						<td class="actions">
							<a class="btn btn-small btn-danger" data-toggle="modal" href="#removeItem">删除</a>
							<a class="btn btn-small btn-primary" href="form.html">查看</a>							
								<!-- <a class="btn btn-small btn-primary"  href="updateFileName.jsp?fileID=${fileID}">重命名</a> -->
							<a class="btn btn-small btn-primary" href="filedownload.action?fileID=${fileID}">下载</a>
						</td>
					</tr>
			        </s:iterator>
				</tbody>
				</table>
			</div>		
	   </div>
	   <div class="span5" style="margin-top:50px;">
		
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
				
		<div class="span5 listing-buttons pull-right" style="margin-top:50px;">		
			<button class="btn btn-info">全选</button>
		
			<button class="btn btn-success">删除</button>
		
			<button class="btn btn-primary">下载</button>		
		</div>			
	    </div>
	    <div class="container-fluid" style="background-color:#708090;margin-top:300px;">
			<div class="row-fluid" style="color:white;margin-left:580px">
				<div class="span12">
					 <address> <strong>-----------JAVAEE-----------</strong><br /> CurriculumDesign大作业<br/>
					 </address>
				</div>
			</div>
	    </div>
</body>
</html>