<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../jsp/plug/nav-head.jsp" %>

<div class="container-fluid">
	<div class="panel">
           <div class="panel-body">
               <table class="table table-striped table-bordered table-condensed table-hover">
                   <thead>
                       <tr style="background-color:#0CF">
                        <th>ID</th>
                        <th>周报标题</th>
                        <th>周报类型</th>
                        <th>创建者</th>
                        <th>是否补交</th>
                        <th>周报时间</th>
                        <th>创建日期</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${models}" var="model" varStatus="st">
                    	<tr align="center">
                    		<td><span style="font-weight:bold;"><c:out value="${model.id}"/></span></td>
                    		<td><a href="/weekandmeeting/show-my-detail.html?weeklyid=${model.id}">${model.title}</a></td>
                    		<c:choose>
                    			<c:when test="${model.type == 0}">
                    				<td><span style="font-weight:bold;color:brown;">个人</span></td>
                    			</c:when>
                    			<c:otherwise>
                    				<td><span style="font-weight:bold;color:green;">团队</span></td>
                    			</c:otherwise>
                    		</c:choose>
                    		<td><c:out value="${model.username}"/></td>
                    		<c:choose>
                    			<c:when test="${model.islatesubmit == 0}">
                    				<td>否</td>
                    			</c:when>
                    			<c:otherwise>
                    				<td><span style="font-weight:bold;color:red;">是</span></td>
                    			</c:otherwise>
                    		</c:choose>
                    		<td><c:out value="${model.datepicker}"/></td>
                    		<td><c:out value="${model.createtime}"/></td>
                    	</tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../jsp/plug/nav-bottom.jsp" %>