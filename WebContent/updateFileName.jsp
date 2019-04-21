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
 <div class="modal" id="creatFileFolderItem">
			<div class="modal-header">				
				<h3>重命名</h3>
			</div>
			<div class="modal-body" style="margin-left:120px">
				<form action="recoverFile" method="post">
					关  键 字:&nbsp<input type="text" name="fileID"/><br>	
					文 件 名:&nbsp<input type="text" name="fileName"/><br>												
			    <a href="index.action" class="btn btn-danger" data-dismiss="modal" style="margin-left:150px;">取消</a>
			    <input type="submit"  class="btn btn-danger" style="margin-left:30px;">
			</form>	
			</div>
			<div class="modal-footer">
			
			</div>
		</div>
</body>
</html>