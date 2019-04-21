<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件上传</title>
</head>
<body>
  <div style="width:330px;height:150px;margin-left:200px;margin-top:50px;border:1px solid #000">
   <form action="fileupload" method="post" enctype="multipart/form-data">
     <input type="file" name="myFile" style="margin-left:50px;margin-top:20px"/>    
     <input type="submit" value="上传" style="margin-left:100px;margin-right:20px;margin-top:20px"/>
     <input type="reset" value="重置" style="margin-top:20px"/>  
    </form> 
  </div>
</body>
</html>