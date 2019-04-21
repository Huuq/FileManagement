<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>回收站</title>
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
					<h2>回收站</h2>
				</div>			
                <table class="orders-table table">
				<thead>
					<tr>
						<th>文件名</th>	
						<th>大小</th>	
						<th></th>																																																									
						<th class="actions">删除时间</th>					
					</tr>
				</thead>
				<tbody>
				    <s:iterator value="recyleList" status="li">
					<tr>					   
					    <td><a href="#"><s:property value="fileName"/></a><br/><span class="meta">Added Today</span></td>
						<td><a href="#"><s:property value="fileSize"/></a></td>	
						<td class="actions">
							<a class="btn btn-small btn-danger" data-toggle="modal" href="clearRecycle.action?fileName=${fileName}&recycleID=${recycleID}">粉碎</a>
						    <a class="btn btn-small btn-danger" data-toggle="modal" href="recoverFile.action?recycleID=${recycleID}">恢复</a>							
						</td>																									
						<td><a href="#" style="margin-left:30px"><s:property value="date"/></a></td>							
					</tr>
			        </s:iterator>
				</tbody>
				</table>
			</div>		
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