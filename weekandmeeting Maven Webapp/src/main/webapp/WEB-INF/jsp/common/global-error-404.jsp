<%@ page language="java" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
	<head>
		<base href="<%=basePath%>">
    
		<!-- start: Meta -->
		<meta charset="utf-8">
		<meta name="description" content="loginTest" />
		<meta name="author" content="cyy" />
		<!-- end: Meta -->
		<!-- start: Mobile Specific -->
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<!-- end: Mobile Specific -->
		<title>qtest我的周报</title>
		
		<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
				<link id="ie-style" href="css/ie.css" rel="stylesheet">
		<![endif]-->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dandelion.css"  media="screen" />
	</head>

	<body>
		<!-- Main Wrapper. Set this to 'fixed' for fixed layout and 'fluid' for fluid layout' -->
		<div id="da-wrapper" class="fluid">
	        <!-- Content -->
	        <div id="da-content">
	            <!-- Container -->
	            <div class="da-container clearfix">
	            
	            	<div id="da-error-wrapper">
	                	
	                   	<div id="da-error-pin"></div>
	                    <div id="da-error-code">
	                    	error <span>404</span>                    </div>
	                
	                	<h1 class="da-error-heading">灰常抱歉！页面让狗狗叼走了！</h1>
	                </div>
	            </div>
	        </div>
	    </div>
	</body>
</html>