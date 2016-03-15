<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../jsp/plug/nav-head.jsp" %>

<script type="text/javascript">
	var nicEditorConfig = {
	buttons : {
		'save' : {name : '保存', type : 'nicEditorSaveButton', tile : 1},
		'undo' : {name : '撤销', command : 'undo', noActive : true, tile : 23},
		'redo' : {name : '重做', command : 'redo', noActive : true, tile : 24},
		'bold' : {name : '加黑', command : 'Bold', tags : ['B','STRONG'], css : {'font-weight' : 'bold'}, tile : 2},
		'italic' : {name : '倾斜', command : 'Italic', tags : ['EM','I'], css : {'font-style' : 'italic'}, tile : 3},
		'underline' : {name : '下划线', command : 'Underline', tags : ['U'], css : {'text-decoration' : 'underline'}, tile : 4},
		'left' : {name : '左对齐', command : 'justifyleft', noActive : true, tile : 8},
		'center' : {name : '中间对齐', command : 'justifycenter', noActive : true, tile : 9},
		'right' : {name : '右对齐', command : 'justifyright', noActive : true, tile : 10},
		'ol' : {name : '有序列表', command : 'insertorderedlist', tags : ['OL'], tile : 12},
		'ul' : 	{name : '无序列表', command : 'insertunorderedlist', tags : ['UL'], tile : 13},
		'fontSize' : {name : '字体大小', type : 'nicEditorFontSizeSelect', command : 'fontsize'},
		'fontFamily' : {name : '字体样式', type : 'nicEditorFontFamilySelect', command : 'fontname'},
		'fontFormat' : {name : '字体格式', type : 'nicEditorFontFormatSelect', command : 'formatBlock'},
		'subscript' : {name : '下标', command : 'subscript', tags : ['SUB'], tile : 6, disabled : true},
		'superscript' : {name : '上标', command : 'superscript', tags : ['SUP'], tile : 5, disabled : true},
		'strikeThrough' : {name : '删除线', command : 'strikeThrough', css : {'text-decoration' : 'line-through'}, tile : 7, disabled : true},
		'indent' : {name : '减少缩进量', command : 'indent', noActive : true, tile : 20},
		'unindent' : {name : '增加缩进量', command : 'outdent', noActive : true, tile : 21},
		'hr' : {name : '水平线', command : 'insertHorizontalRule', noActive : true, tile : 22},
		'color' : {name : '更改颜色', type : 'nicEditorColorButton', tile : 25},
		'image' : {name : '添加图片', type : 'nicEditorImageButton', tile : 14},
		'html' : {name : '编辑 HTML', type : 'nicEditorHTMLButton', tile : 16},
		'link' : {name : '链接', type : 'nicEditorLinkButton', tile : 17}
	},
	iconsPath : '${pageContext.request.contextPath}/jpg/nicEditorIcons.gif',
	fullPanel : false,
	onSubmit : null,
	buttonList : ['bold','italic','underline','left','center','right','ol','ul','indent','unindent','fontSize','fontFamily','image','link', 'superscript', 'subscript', 'strikeThrough'],
	toolTipOn : false,
	toolTipText : '点击编辑'
};
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bkLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/nicEdit.js"></script>
<script type="text/javascript">
	bkLib.onDomLoaded(function() { nicEditors.allTextAreas(); });
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/daterangepicker.js"></script>
<script>
	$(document).ready(function(){
		$('#datepicker').daterangepicker(null, function(start, end, label) {
        	console.log(start.toISOString(), end.toISOString(), label);
        });
		var tpl = $('#table_tpl').html();
		var index = 1;
		var addTpl = function(data){
			data = data || {};
			return tpl.replace(/\{\{=([^}]+)\}\}/g,function(str, key){
				console.log(key);
				return 	data[key] || '0';
			});
		};
		var addTr = function(){
			$('#table_footer').before($(addTpl({id:index++})));
		};		
		addTr();		
		$("#addtask").click(function(){
			addTr();
		});
		var deleTpl = function(){
			console.log("dele:"+index);
			if(index > 2){
				var tmp = '.change'+(index-1);
				console.log(tmp);
				$('.change'+(index-1)).remove();
				index--;

			}
			console.log("dele:"+index);};
		$("#removetask").click(function(){
			deleTpl();
		});
	});	
</script>

<div class="container-fluid">
	<div class="container">
    	<div class="row">
        	<form class="form-horizontal" action="<c:url value="/addweekly.html"/>" method="post">
        	<input class="hidden" type="text" name="username" value="${usermodel.username}"/>
        	<input class="hidden" type="text" name="type" value="${type}"/>
        	<input class="hidden" type="text" name="weektitle" value="${usermodel.realname}的${type}周报(${weekstart}-${weekend})"/>
            <fieldset>
            <legend>创建周报</legend>
        	<table class="table table-bordered table-condensed" border="1" cellpadding="5" cellspacing="0" style="border:2px #000 solid;border-collapse:collapse;">
            	<tbody>
                	<tr style="background-color:#0CF">
                    	<td colspan="8"><div class="text-center"><strong><c:out value="${usermodel.realname}"/>的<c:out value="${type}"/>周报(<input type="text" readonly name="datepicker" id="datepicker" class="" value="${startday} - ${endday}" />)</strong></div></td>
                   	</tr>
                   	<tr> 
                    	<td colspan="8">
                        	<input class="form-control" type="text" value="${usermodel.members}" name="members" readonly="readonly"/>
                        </td>
                    </tr>
                    <tr style="background-color:#0CF">
                    	<td colspan="8"><div class="text-center"><strong>本周重要事项说明</strong></div></td>
                    </tr>
                    <tr>
                    	<td colspan="8">
                        	<textarea class="form-control" rows="6" name="important" autofocus="autofocus"></textarea>
                        </td>
                    </tr>
                    <tr style="background-color:#0CF" id="table_header">
                    	<td colspan="8"><div class="text-center"><strong>本周业务工作概况</strong>
                        	<button id="addtask" type="button" class="btn btn-success btn-xs">添加业务线</button>
                        	<button id="removetask" type="button" class="btn btn-danger btn-xs">移除业务线</button></div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1" style="background-color:#FC6;vertical-align:middle;"><div class="text-center">总提测数</div></td>
                        <td colspan="1"><input class="form-control" type="text" placeholder="本周提测数目..." name="tasknum"/></td>
                        <td colspan="1" style="background-color:#FC6;vertical-align:middle;"><div class="text-center">已上线</div></td>
                        <td colspan="1"><input class="form-control" type="text" placeholder="已上线数目..." name="onlinenum"/></td>
                        <td colspan="1" style="background-color:#FC6;vertical-align:middle;"><div class="text-center">测试中</div></td>
                        <td colspan="1"><input class="form-control" type="text" placeholder="测试中数目..." name="runnum"/></td>
                        <td colspan="1" style="background-color:#FC6;vertical-align:middle;"><div class="text-center">提交bug数</div></td>
                        <td colspan="1"><input class="form-control" type="text" placeholder="提交BUG数目..." name="allbugnum"/></td>
                    </tr>
                    <tr style="background-color:#0CF" id="table_footer">
                    	<td colspan="8"><div class="text-center">业务，技术及其他事项补充说明</div></td>
                    </tr>
                    <tr>
                    	<td colspan="8">
                        	<textarea class="form-control" rows="6" name="description"></textarea>
                        </td>
                    </tr>
                    <tr style="background-color:#0CF">
                    	<td colspan="8"><div class="text-center">下周主要工作计划</div></td>
                    </tr>
                    <tr>
                    	<td colspan="8">
                        	<textarea class="form-control" rows="6" name="next"></textarea>
                        </td>
                    </tr>
                </tbody>
            </table>
            </fieldset>
            <div class="pull-right">
              <input type="submit" class="btn btn-primary" value="提交" id="confirm">
              <a href="/weekandmeeting/create-weekly.html?username=${usermodel.username}" class="btn btn-danger">清空</a>
            </div>
          </form>
        </div>
    </div>
</div>
    
<script type="text/tpl" id="table_tpl">
	<tr class="change{{=id}}">
		<td colspan="1" rowspan="5" style="background-color:#FC6;vertical-align:middle;"><div class="text-center">业务线{{=id}}</div></td>
		<td colspan="7"><input class="form-control" type="text" placeholder="请输入业务线名称..." name="businessname{{=id}}"/></td>
	</tr>
	<tr class="change{{=id}}">
		<td colspan="2" style="background-color:#FC6"><div class="text-center">产品线</div></td>
		<td colspan="1" style="background-color:#FC6"><div class="text-center">优先级</div></td>
		<td colspan="1" style="background-color:#FC6"><div class="text-center">工作进度</div></td>
		<td colspan="1" style="background-color:#FC6"><div class="text-center">BUG数</div></td>
		<td colspan="2" style="background-color:#FC6"><div class="text-center">跟进人员</div></td>
	</tr>
	<tr class="change{{=id}}">
		<td colspan="2"><input class="form-control" type="text" placeholder="产品线" name="productname{{=id}}"/></td>
		<td colspan="1">
			<select class="form-control"  name="priority{{=id}}">
				<option>P1</option>
				<option>P2</option>
				<option>P3</option>
			</select>
		</td>
		<td colspan="1">
			<select class="form-control"  name="progress{{=id}}">
				<option>0%</option>
				<option>10%</option>
				<option>20%</option>
				<option>30%</option>
				<option>40%</option>
				<option>50%</option>
				<option>60%</option>
				<option>70%</option>
				<option>80%</option>
				<option>90%</option>
				<option>100%</option>
			</select>
		</td>
		<td colspan="1"><input class="form-control" type="text" placeholder="BUG数" name="bugnum{{=id}}"/></td>
		<td colspan="2"><input class="form-control" type="text" placeholder="跟进人员" name="person{{=id}}"/></td>
	</tr>
	<tr class="change{{=id}}">
		<td colspan="7" style="background-color:#FC6"><div class="text-center">业务概述</div></td>
	</tr>
	<tr class="change{{=id}}">
		<td colspan="7"><textarea class="form-control" rows="5"  name="businessdescription{{=id}}"></textarea></td>
	</tr>
</script>

<%@include file="../jsp/plug/nav-bottom.jsp" %>