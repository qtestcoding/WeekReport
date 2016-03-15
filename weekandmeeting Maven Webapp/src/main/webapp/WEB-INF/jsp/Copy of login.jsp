<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<title>qtest周报登陆</title>
	
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style>
	#basic-grey {
		margin-left: 20%;
		margin-right: 20%;
		margin-bottom: 10%;
		max-width: 1000px;
		max-height: 1000px;
		background: #FFF;
		padding: 25px 15px 25px 10px;
		font: 12px Georgia, "Times New Roman", Times, serif;
		color: #888;
		text-shadow: 1px 1px 1px #FFF;
		border-width: 6px;
		border-style: solid;
		border-top-colors: #000 #fff #999 #aaa #ccc #eee;
		border-right-colors: #000 #fff #999 #aaa #ccc #eee;
		border-bottom-colors: #000 #fff #999 #aaa #ccc #eee;
		border-left-colors: #000 #fff #999 #aaa #ccc #eee;
		border-style: outset;
		-webkit-border-radius: 10px;
		-moz-border-radius: 10px;
		border-radius: 10px;
		box-shadow: -10px 10px 40px #888888;
	}
	#basic-grey form {
		margin-top: 5%;
	}
	#basic-grey .btn{
		width:120px;
	}
	</style>
	<!-- link and script -->
	<link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  </head>
  
  <body>
    <div class="container-fluid">
    	<h2 class="text-center">周报系统</h2>
        <div id="basic-grey">
        	<c:if test="${!empty error}">
        		<font color="red"><c:out value="${error}"></c:out></font>
        	</c:if>
            <form class="form-horizontal" action="<c:url value="/login-success.html"/>" method="post">
                <div class="form-group">
                    <label for="inputname" class="col-sm-2 control-label">name:</label>
                    <div class="col-sm-8">
                    	<input class="form-control" type="text" id="inputname" name="username" placeholder="名字全拼" autofocus/>
                	</div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                  		<button type="submit" class="btn btn-primary">Sign in</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
  </body>
</html>
