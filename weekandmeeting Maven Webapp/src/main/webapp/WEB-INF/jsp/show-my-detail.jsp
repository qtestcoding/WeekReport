<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../jsp/plug/nav-head.jsp" %>

    <div class="container-fluid">
    	<div class="container">
        	<div class="row">
            	<input class="hidden" type="text" name="username" value="${usermodel.username}"/>
            	<input class="hidden" type="text" name="type" value="${type}"/>
            	<input class="hidden" type="text" name="weektitle" value="${weeklymodel.title}"/>
            	<input class="hidden" type="text" name="weeklyid" value="${weeklymodel.id}"/>
                <fieldset>
                <legend>查看周报</legend>
            	<table class="table table-bordered table-condensed" border="1" cellpadding="5" cellspacing="0" style="border:2px #000 solid;border-collapse:collapse">
                	<tbody>
                    	<tr style="background-color:#0CF">
                        	<td colspan="16"><div class="text-center"><strong>${weeklymodel.title}</strong></div></td>
                       	</tr>
                       	<tr> 
                        	<td colspan="16">
                            	<input class="form-control" type="text" value="${usermodel.members}" readonly="readonly"/>
                            </td>
                        </tr>
                        <tr style="background-color:#0CF">
                        	<td colspan="16"><div class="text-center"><strong>本周重要事项说明</strong></div></td>
                        </tr>
                        <tr>
                        	<td colspan="16">
                            	${detailmodel.important}
                            </td>
                        </tr>
                        <tr style="background-color:#0CF" id="table_header">
                        	<td colspan="16"><div class="text-center"><strong>本周业务工作概况</strong></div></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="background-color:#FC6;vertical-align:middle;"><div class="text-center">总提测数</div></td>
                            <td colspan="2" style="text-align:center;font-weight:bold;color:red;">${detailmodel.tasknum}</td>
                            <td colspan="2" style="background-color:#FC6;vertical-align:middle;"><div class="text-center">已上线</div></td>
                            <td colspan="2" style="text-align:center;font-weight:bold;color:red;font-style:oblique;">${detailmodel.onlinenum}</td>
                            <td colspan="2" style="background-color:#FC6;vertical-align:middle;"><div class="text-center">测试中</div></td>
                            <td colspan="2" style="text-align:center;font-weight:bold;color:green;font-style:oblique;">${detailmodel.runnum}</td>
                            <td colspan="2" style="background-color:#FC6;vertical-align:middle;"><div class="text-center">提交bug数</div></td>
                            <td colspan="2" style="text-align:center;font-weight:bold;">${detailmodel.bugnum}</td>
                        </tr>
                        <c:forEach  items="${Businessmodel}" var="business" varStatus="st">
                        	<tr class="change${st.count}">
								<td colspan="2" style="background-color:#FC6"><div class="text-center">业务线</div></td>
								<td colspan="2" style="background-color:#FC6"><div class="text-center">产品线</div></td>
								<td colspan="2" style="background-color:#FC6"><div class="text-center">优先级</div></td>
								<td colspan="1" style="background-color:#FC6"><div class="text-center">工作进度</div></td>
								<td colspan="1" style="background-color:#FC6"><div class="text-center">BUG数</div></td>
								<td colspan="8" style="background-color:#FC6"><div class="text-center">跟进人员</div></td>
							</tr>
							<tr class="change${st.count}">
								<td colspan="2" style="text-align:center;font-weight:bold;">${business.businessname}</td>
								<td colspan="2" style="text-align:center;font-weight:bold;">${business.productname}</td>
								<td colspan="2" style="text-align:center;">${business.priority}</td>
								<td colspan="1" style="text-align:center;">${business.progress}</td>
								<td colspan="1" style="text-align:center;">${business.bugnum}</td>
								<td colspan="8" style="text-align:center;">${business.person}</td>
							</tr>
							<tr class="change${st.count}">
								<td colspan="16" style="background-color:#FC6"><div class="text-center">业务概述</div></td>
							</tr>
							<tr class="change${st.count}">
								<td colspan="16">${business.businessdescription}</td>
							</tr>
                        </c:forEach>
                        <tr style="background-color:#0CF" id="table_footer">
                        	<td colspan="16"><div class="text-center">业务，技术及其他事项补充说明</div></td>
                        </tr>
                        <tr>
                        	<td colspan="16">
                            	${detailmodel.description}
                            </td>
                        </tr>
                        <tr style="background-color:#0CF">
                        	<td colspan="16"><div class="text-center">下周主要工作计划</div></td>
                        </tr>
                        <tr>
                        	<td colspan="16">
                            	${detailmodel.next}
                            </td>
                        </tr>
                    </tbody>
                </table>
                </fieldset>
            </div>
        </div>
    </div>

<%@include file="../jsp/plug/nav-bottom.jsp" %>