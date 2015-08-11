<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.basic.common.util.DateUtil"%>
<%@ include file="/common/headers/taglib-import.jspf"%>
<%@ include file="/common/headers/jquery-plugin.jsp"%>
<%@ include file="/common/headers/queryAndturnPage.jsp"%>
<%
    String path = request.getContextPath();
    BaseForm bForm = (BaseForm) request.getAttribute("BaseForm");
    String subjectCode = (String)request.getAttribute("subjectCode"); //立项类型(this:本年项目;cross:跨年项目;ahead:预立项目)
    
    Integer year = DateUtil.getYear(); 
    
%>
<html>
<head>
	<title>成本费用立项</title>
	<script type="text/javascript" src="<%=path%>/widgets/workflow/workflow.js"></script>
	
	<script type="text/javascript">
	</script>
</head>
<body>
	<form id="p" name="form1" action="costProj.do?method=viewDetail&subjectCode=${subjectCode }"  method="post">
		<input type="hidden" id="subjectCode" name="dprojTypeDetail" value="${subjectCode  }">
		<input id="basePath" type="hidden" name="basePath" value="<%=path%>" />
		<tag:turnPage urlPath="costProj.do?method=viewDetail&subjectCode=${subjectCode }" excelCol="dprojCode:项目编号;dprojName:项目名称;sponsor:项目经办人;ytdTotalAmount:金额"/>		
		<display:table class="commonList" name="List" id="vo" export="false">
		<display:column title="项目编号" attribute="style='cursor:hand' title='点击排序' onclick=\" orderBy('dprojCode')\"" property="dprojCode" />
			<display:column title="项目名称" attribute="style='cursor:hand' title='点击排序' onclick=\" orderBy('dprojName')\"" property="dprojName" />
			<display:column title="项目经办人" attribute="style='cursor:hand' title='点击排序' onclick=\"orderBy('sponsor')\"" property="sponsor"/>	
			<display:column title="金额" attribute="style='cursor:hand' title='点击排序' onclick=\"orderBy('ytdTotalAmount')\"">
				<fmt:formatNumber pattern="#,##0.00" value="${vo.ytdTotalAmount}"/> 
			</display:column>
		</display:table>
	</form>
</body>
</html>

