<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
    <title>qtest</title>
    
    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!-- style -->
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<script>
		$(document).ready(function(){
			setInterval(function() {
			    var now = (new Date()).toLocaleString();
			    $('#current-time').text(now);
			}, 1000);
		});	
		$('#nav_header').find('li').click(function() {
			// 为当前点击的导航加上高亮，其余的移除高亮
			$(this).addClass('active').siblings('li').removeClass('active');
		});
	</script>
	
  </head>
  
  <body>
  	<nav class="navbar navbar-default" id="navbar">
       <div class="container-fluid">
           <div class="row">
                <div class="col-lg-6">
                    <ul class="nav navbar-nav nav-pills pull-left" id="nav_header">
                        <li class="active"><a href="/weekandmeeting/show-my-weekly.html">我的周报</a></li>
                        <li><a href="/weekandmeeting/create-weekly.html">创建周报</a></li>
                        <li><a href="/weekandmeeting/show-this-weekly.html">本周周报</a></li>
                    </ul>	
                </div>
                <div class="col-lg-6">
                    <ul class="nav navbar-nav navbar-default pull-right">
                        <li><a id="current-time"></a></li>
                        <li class="nav-divider"></li>
                        <li><a href="/weekandmeeting/show-my-weekly.html"><c:out value="${usermodel.realname}"/></a></li>
                        <li class="nav-divider"></li>
                        <li><a href="/weekandmeeting/login-out.html" style="font-weight:bold;">退出点我</a></li>
                    </ul>
                </div>
           </div>
       </div>
    </nav>
