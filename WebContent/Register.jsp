<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>欢迎使用</title>
<link href="Css/login.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<!-- -->
<script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
<script src="Js/jquery.min.js"></script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
</head>
<body>
<!-- contact-form -->	
<div class="message warning" style="background-color:gray">
	<div class="inset">
		<div class="login-head">
			<h1>Welcome To Register</h1>
			 <div class="alert-close"> </div> 			
		</div>
		<form action="register" method="post">
			<li>
				<input type="text" class="text" name="userName" value="电话号码/QQ邮箱" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'userName';}"><a href="#" class=" icon user"></a>
			</li>
				<div class="clear"> </div>
			<li>
				<input type="password" name="password"  value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"> <a href="#" class="icon lock"></a>
			</li>
			<li>
				<input type="password" name="password1"  value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"> <a href="#" class="icon lock"></a>
			</li>
			<li>
				<input type="text" name="nickName"  value="真实姓名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"> <a href="#" class=" icon user"></a>
			</li>
			<div class="clear"> </div>
			<div class="submit">
				<input type="submit" onclick="myFunction()" value="注册" >
				<h4><a href="Login.jsp">取消</a></h4>
			<div class="clear">  </div>	
			</div>				
		</form>
		</div>					
	</div>	
	<div class="clear"> </div>
</body>
</html>