
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.basic.common.COMMON"%>
<%@page import="com.basic.bo.User"%>
<%-- 引入标签库 --%>
<%@ include file="/common/headers/taglib-import.jspf"%>
<%@page import="com.eskytech.budget.daily.vo.BDprojBudget"%>
<%
    String path = request.getContextPath();
	String orgNo = (String) request.getAttribute("getOrgId");
	String dprojTypeDetail = (String)request.getAttribute("dprojTypeDetail");
	Integer year = (Integer)request.getAttribute("year");
	String isCross = (String)request.getAttribute("isCross");
	String taskId = request.getParameter("taskId");
	String pdId = request.getParameter("pdId");
	String status = (String)request.getAttribute("status");
	if (COMMON.isEmpty(taskId)) {
        taskId = "";
    }
    if (COMMON.isEmpty(pdId)) {
        pdId = "";
    }
%>
<script type="text/javascript" src="<%=path%>/js/COMMON.js"></script>
<script type="text/javascript" src="<%=path%>/widgets/workflow/workflow.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>日常项目预算申报</title>
		<%@ include file="/common/headers/jquery-plugin.jsp"%>
		<%@ include file="/common/headers/jquery-validate-plugin.jsp"%>
		<base target="_self">
		<script language="javascript">
			var taskId = '<%=taskId%>';
			var drafter=true;
			var rm;
			var dprojTypeDetail='<%=dprojTypeDetail%>';
			var isCross ='<%=isCross%>';
			var status = '<%=status%>';
			var haveDeputy = 0;
			jQuery(document).ready(function(){
			 	if(status != "0" && status != "4" && status != "6" && status != "null") {
			 		jQuery("#saveButton").hide();
			 	}
			 	if(status == "0" || status == "4") {
			 		jQuery("#submButton").show();
					jQuery("#buttonshow").hide();
				}
				jQuery(".commonList").css({"border-style":"solid solid none solid"});
				jQuery(".commonTable").css({"margin-top":"0px","border-style":"none solid solid"});
				
				//是否选择副领导
				if('${requestScope.deputyDeptLeader}'!=''&&'${requestScope.deputyDeptLeader}'!='null'){
					haveDeputy=1;
				}
				//母项目
				jQuery("img[name=batn]").livequery("click",function(){
					var returnVal = window.showModalDialog('<%=path %>/deptProjectAction.do?method=projectList&rand='+Math.random(),'','dialogWidth=800px;dialogHeight=600px');
				    if(returnVal!=null&&returnVal!=''&&returnVal!=undefined&&returnVal!='undefined'){
				        var obj = returnVal.split(",");
				        jQuery(this).parent().parent().find("input[name='parentNo']").val(obj[0]);
				        jQuery(this).parent().parent().find("input[name='parentName']").val(obj[1]);
				    }
				});
				//本年立项时间
				jQuery("#startDate1").click(function() {
					WdatePicker({el:'startDate',minDate:'<%=year %>-01-01 00:00:00',maxDate:'<%=year %>-12-31 23:59:59'});
				});
				jQuery("#endDate1").click(function() {
					WdatePicker({el:'endDate',minDate:$(this).parent().parent().find('input[name^=\'startDate\']').val(),maxDate:'<%=year %>-12-31 23:59:59'})
				});
				//跨年立项时间
				jQuery("#startDate2").click(function() {
					WdatePicker({el:'startDate',minDate:'<%=year %>-01-01 00:00:00',maxDate:'<%=year %>-12-31 23:59:59'});
				});
				jQuery("#endDate2").click(function() {
					WdatePicker({el:'endDate',minDate:'<%=year+1 %>-01-01 00:00:00'});
				});
				//预立项不跨年
				jQuery("#startDate3").click(function() {
					WdatePicker({el:'startDate',minDate:'<%=year %>-01-01 00:00:00',maxDate:'<%=year %>-12-31 23:59:59'});
				});
				jQuery("#endDate3").click(function() {
					WdatePicker({el:'endDate',minDate:'<%=year %>-01-01 00:00:00',maxDate:'<%=year %>-12-31 23:59:59'});
				});
				//预立项跨年
				jQuery("#startDate4").click(function() {
					WdatePicker({el:'startDate',minDate:'<%=year %>-01-01 00:00:00',maxDate:'<%=year %>-12-31 23:59:59'});
				});
				jQuery("#endDate4").click(function() {
					WdatePicker({el:'endDate',minDate:'<%=year+1 %>-01-01 00:00:00'});
				});
				//部门按钮-项目报账部门
				jQuery("#testPop3").click(function() {
					var resultVal = window.showModalDialog('/budget/common/comm/OrgOneSelectTreeDuty.jsp?orgNo=<%=orgNo%>&selectType=checkbox&selectAll=true&type=zhl','500','400');
					if (undefined != resultVal) {
						jQuery('#bzdept').val('');
						jQuery('#tempbz').val('');
						var varArr = resultVal.split("~~");
						var needVar = varArr[1].split(",");
						var codeVar = varArr[0].split(",");
						for (var i = 0; i < needVar.length; i++) {
							if (needVar[i] != '') {
								var temp = jQuery('#bzdept').val();
								var temp1 = jQuery('#tempbz').val();
								if (temp != '') {
									jQuery('#bzdept').val(temp + "," + needVar[i]);
									jQuery('#tempbz').val(temp1 + "," +codeVar[i]+":"+ needVar[i]);
								} else {
									jQuery('#bzdept').val(needVar[i]);
									jQuery('#tempbz').val(codeVar[i]+":"+needVar[i]);
								}
							}
						}
					}			
				});
				
				//部门按钮-可签合同部门 ADD BY zhangqingbin  20130819
				jQuery("#testPop5").click(function() {
					var resultVal = window.showModalDialog('/budget/common/comm/OrgOneSelectTreeDuty.jsp?orgNo='+'<%=orgNo%>&selectType=checkbox&selectAll=true&type=zhl','500','400');
					if (undefined != resultVal) {
						jQuery('#htDept').val('');  
						jQuery('#tempht').val('');
						var varArr = resultVal.split("~~");
						var needVar = varArr[1].split(","); 
						var codeVar = varArr[0].split(",");
						for (var j = 0; j < needVar.length; j++) {
							if (needVar[j] != '') {
								var temp = jQuery('#htDept').val();
								var temp1 = jQuery('#tempht').val();
								if (temp != '') {
									jQuery('#htDept').val(temp + "," + needVar[j]);
									jQuery('#tempht').val(temp1 + "," +codeVar[j]+":"+ needVar[j]);
								} else {
									jQuery('#htDept').val(needVar[j]);
									jQuery('#tempht').val(codeVar[j]+":"+needVar[j]);
								}
							}
						}
					}
				});
				/* //含税成本改变
				jQuery("input[name='ytdTotalAmount']").blur(function(){
					var thisValue = jQuery(this).val();
					if(isNaN(thisValue.replace(/,/g,""))||Number(thisValue.replace(/,/g,""))<0)
					{
		                alert("请输正实数！");
		                jQuery(this).val("0.00");
		                thisValue='0.00';
					}
					if(thisValue.replace(/,/g,"").indexOf('.')>0 && thisValue.replace(/,/g,"").substring(thisValue.replace(/,/g,"").indexOf('.')).length>3){
						alert('最多只允许两位小数，请重新输入！');
						thisValue =thisValue.substring(0,thisValue.indexOf('.')+3);
						jQuery(this).val(thisValue);
					}
					jQuery(this).formatMoney();
					var $taxRate= jQuery("select[name='taxRate']");
					var $ytdTotalCost=jQuery("input[name='ytdTotalCost']");
					var $tax=jQuery("input[name='tax']");
					var $totalCost=jQuery("input[name='totalCost']");
					if(dprojTypeDetail=='this'||(isCross=='0'&&dprojTypeDetail=='ahead')){
						$totalCost.val(thisValue);
					}else{
						if(Number(thisValue.replace(/,/g,""))>Number($totalCost.val().replace(/,/g,""))){
							alert("本年项目金额不能大于项目总金额!");
							jQuery(this).val($totalCost.val());
							thisValue=$totalCost.val();
						}
					}
					
					var totalCost=accSub(Number(thisValue.replace(/,/g,"")),Number($tax.val().replace(/,/g,"")));
					if(totalCost>=0){
						$ytdTotalCost.val(commafy(totalCost));
					}else{
							  $ytdTotalCost.val(thisValue);
							  $tax.val("0.00");
					   }
				}); */
				//增值税改变
				jQuery("select[name='taxRate']").change(function(){
					var thisValue = jQuery(this).val();
					var $ytdTotalAmount = jQuery("input[name='ytdTotalAmount']");
					var $tax= jQuery("input[name='tax']");
					var $ytdTotalCost=jQuery("input[name='ytdTotalCost']");
					var totalTax=accMul(Number($ytdTotalAmount.val().replace(/,/g,"")),Number(thisValue.replace(/,/g,"")));
					$tax.val(commafy(totalTax.toFixed(2)));
					var totalCost=accSub(Number($ytdTotalAmount.val().replace(/,/g,"")),Number($tax.val().replace(/,/g,"")));
					$ytdTotalCost.val(commafy(totalCost));
				});
				//增值税改变
				jQuery("input[name='tax']").blur(function(){
					var thisValue = jQuery(this).val();
					if(isNaN(thisValue.replace(/,/g,""))||Number(thisValue.replace(/,/g,""))<0)
					{
		                alert("请输正实数！");
		                jQuery(this).val("0.00");
		                thisValue='0.00';
					}
					if(thisValue.replace(/,/g,"").indexOf('.')>0 && thisValue.replace(/,/g,"").substring(thisValue.replace(/,/g,"").indexOf('.')).length>3){
						alert('最多只允许两位小数，请重新输入！');
						thisValue =thisValue.substring(0,thisValue.indexOf('.')+3);
						jQuery(this).val(thisValue);
					}
					jQuery(this).formatMoney();
					var $ytdTotalAmount = jQuery("input[name='ytdTotalAmount']");
					var $ytdTotalCost=jQuery("input[name='ytdTotalCost']");
					var totalCost=accSub(Number($ytdTotalAmount.val().replace(/,/g,"")),Number(thisValue.replace(/,/g,"")));
					if(totalCost>=0){
						$ytdTotalCost.val(commafy(totalCost));
					}else{
						alert("增值税金额不能大于含税成本总额！");
						jQuery(this).val($ytdTotalAmount.val());
					}	
				});
				//项目类型改变
				jQuery("select[name='addOrDefer']").change(function(){
					var thisValue=jQuery(this).val();
					if("新增"==thisValue){
						jQuery("input[name='up1TotalValue']").val("0.00");
						jQuery("input[name='up1TotalValue']").attr("readonly",true);
					}else if("递延"==thisValue){
						jQuery("input[name='up1TotalValue']").attr("readonly",false);
					}
				});
				//上一年金额为正数
				jQuery("input[name='up1TotalValue']").blur(function(){
					var thisValue = jQuery(this).val();
					if(isNaN(thisValue.replace(/,/g,""))||Number(thisValue.replace(/,/g,""))<0)
					{
		                alert("请输正实数！");
		                jQuery(this).val("0.00");
		                thisValue='0.00';
					}
					if(thisValue.replace(/,/g,"").indexOf('.')>0 && thisValue.replace(/,/g,"").substring(thisValue.replace(/,/g,"").indexOf('.')).length>3){
						alert('最多只允许两位小数，请重新输入！');
						thisValue =thisValue.substring(0,thisValue.indexOf('.')+3);
						jQuery(this).val(thisValue);
					}
					jQuery(this).formatMoney();
				});
				
				var validator = jQuery("#dailySumbit").validate({
					rules:{
						dprojName:{required:true,maxlength:300,remote:'dailyItemPost.do?method=validateDprojName&draftDprojName='+ encodeURI(encodeURI(jQuery("#dprojName").val()))},
						addOrDefer:{required:true},
						startDate:{required:true,dateISO:true,leid:"#endDate"},
						endDate:{required:true,dateISO:true,geid:"#startDate"},
						deptLeader:{required:true},
					  	bzdept:{required:true},
					  	remark:{required:true},
					  	dprojAim:{required:true},
					  	measure:{required:true,maxlength:200},
					  	ratioPrice:{required:true,maxlength:200}
					},
					messages:{
						
					}
				});
				
				//保存时验证表单
                jQuery("#saveButton").click(function() {
	                if(allChange=='0'){
	                	alert("项目基本信息未做修改，无须保存！");
	                	return;
	                }
	                
	                var projectLevelTwoCode =jQuery("input[name='projectLevel2Code']").val();
	                var projectLevelThreeCode =jQuery("input[name='projectLevel3Code']").val();
	                var totalCost = jQuery("input[name='totalCost']").val();  
	                if('SCQTYX'==projectLevelTwoCode&&('SCQTYX01'==projectLevelThreeCode||'SCQTYX02'==projectLevelThreeCode||'SCQTYX03'==projectLevelThreeCode)){
	    				if(Number(totalCost.replace(/,/g,""))!=0){
	    					alert("其他业务营销申请资源必须等于0！！");
	    					return false;
	    				}
	    			}
	                
 	                if(!validator.form()){ 
			         	validator.focusInvalid();
			         	return false;
	         		}
 	                
 	               	var startDate = jQuery("#startDate").val();
	                var endDate = jQuery("#endDate").val();
	                startDate = startDate.split("-")[0];
	                endDate = endDate.split("-")[0];
	                var addOrDefer = jQuery("select[name='addOrDefer']").val();
	                var up1TotalValue = jQuery("#up1TotalValue").val().replace(/,/g,"");
 	                if(startDate != endDate){
 	                	if(addOrDefer == '递延'){
 		                	if(!(Number(up1TotalValue) > 0)){
 			                	alert("上期项目总预算必须大于0！");
 			                	return false;
 		                	}
 		                }
 	                }
 	                
	             var businessType='${requestScope.dailyForm.businessType}'
	            
	   			 if(businessType=="dept_add"){
	                	jQuery("#businessType").val(businessType);
	                }else{
	               		jQuery("#businessType").remove();
	                } 
	   			 
	                jQuery("#dailySumbit").ajaxSubmit({
	        			url: "costProj.do?method=save",
	        			type: "POST",
	        			success: function(msg){
	        				if(msg.indexOf("T") !=-1){
	        					var dataArr = msg.split(",");
	        					jQuery("input[name='dprojCode']").val(dataArr[1]);
	        					jQuery("select[name='deputyDeptLeader']").val(dataArr[2]);
	        					jQuery("select[name='deptLeader']").val(dataArr[3]);
	        					jQuery("#submButton").show();
	        					allChange="0";
	        					periodChange="0";
	        					var deputyDeptLeader = jQuery("select[name='deputyDeptLeader']").val();
	        					if(deputyDeptLeader!=null&&deputyDeptLeader!=""){
	        						haveDeputy=1;
	        					}else{
	        						haveDeputy=0;
	        					}
	        					
	        					alert("保存成功");
	        				}else{
	        					alert("保存失败");
	        				}
	        			}
	        		});
                });
                
				jQuery("select[name='addOrDefer']").change(function(){
					isChangeMethod(this);
				});
			});
			
			function allFolw(){
				
				if(chackIsChangeMethod()==false){
			 		return;
			 	}
				var repetitiveApproval='<c:out value="${repetitiveApproval}"/>';
				var totalCost = jQuery("input[name='totalCost']").val().replace(/,/g,"");
				 
				var totalFund = jQuery("input[name='totalFund']").val().replace(/,/g,"");
				var dprojId = jQuery("input[name='dprojId']").val();
				var dprojCode= jQuery("input[name='dprojCode']").val();
				var dprojName =jQuery("input[name='dprojName']").val();
				
				var businessType='${requestScope.dailyForm.businessType}';
				
				if(businessType=="dept_add"){
					 
					var val = "&val=totalCost:"+totalCost+"^totalFund:"+totalFund+"^repetitiveApproval:"+repetitiveApproval+"^isToProvLine:${isToProvLine}^isToCompLine:${isToCompLine}^isFiLeaderEnd:${isFiLeaderEnd}^haveDeputy:" +haveDeputy+ "^businessId:" + dprojId + "^dprojCode:"+ dprojCode + "^processInstanceLifeBean:budgetAddLife^title:" + encodeURI(encodeURI(dprojName)) +"&totalAmount="+totalCost+ "&business=dept_add"; 
				}else{
				    var val = "&val=totalCost:"+totalCost+"^totalFund:"+totalFund+"^repetitiveApproval:"+repetitiveApproval+"^isToProvLine:${isToProvLine}^isToCompLine:${isToCompLine}^isFiLeaderEnd:${isFiLeaderEnd}^haveDeputy:" +haveDeputy+ "^businessId:" + dprojId + "^dprojCode:"+ dprojCode + "^processInstanceLifeBean:dailyItemLife^title:" + encodeURI(encodeURI(dprojName)) +"&totalAmount="+totalCost+ "&business="+dprojTypeDetail; 
				}
				var taskId = '<%=taskId%>';
					 if ("" != taskId)
					  { 
				    	tosubmit('10',taskId);
				     } else 
				     { 
				     	document.getElementById("val").value = val;
				     	tosubmit('10',taskId,val);
				   }
			}
			var allChange="0";//此全局变量表示基本信息是否作出修改，0表示为修改，1表示修改了
			var periodChange ="0";//此全局变量代表期间和金额变化
		 	function isChangeMethod(dom){
				var name=jQuery(dom).attr("name");
				if(name=='startDate'||name=='endDate'||name=='ytdTotalAmount'||name=='tax'){
					periodChange="1";
				}
		 		allChange="1";
		 	}
			
		 	function chackIsChangeMethod(){
			 	 if(allChange=="1"){
			 		alert("项目基本信息已了修改，请先保存！");
			 		return false;
			 	}
			 }
		 	
		 	function adjustPeriod(){
		 		var dprojCode =jQuery("input[name='dprojCode']").val();
		 		if(dprojCode ==null || dprojCode ==""){
		 			alert("请先保存后在修改期间明细！！");
		 			return false;
		 		}
		 		if(periodChange=="1"){
		 			alert("起止日期或者金额变化，请先保存后在修改期间明细!");
		 			return false;
		 		}
		 		var dprojId = jQuery("input[name='dprojId']").val();
		 		window.open("<%=path%>/costProj.do?method=editPeriod&dprojId="+dprojId);
		 	}
		</script>
	
	</head>
<body style="overflow-x:hidden;overflow-y:hidden">
	<div id="ld" style="width:100%;display:none">
		<form action="/costProj.do?method=save" method="post"
			id="dailySumbit">
			<input id="basePath" type="hidden" name="basePath" value="<%=path%>" />
			<input type="hidden" id="businessType"  name="businessType"/>
			<input type="hidden" id="val" />
			<html:hidden property="dprojId" name="dailyForm" styleId="dprojId"/>
			<input type="hidden" name="totalFund" value='<tag:attr source="vo" attr="totalFund" />'>
			<html:hidden property="dprojTypeDetail" name="dailyForm" styleId="dprojTypeDetail"/>
			<table class="commonTable">
				<thead>
					<tr>
						<c:if test="${dprojTypeDetail=='this'&& requestScope.dailyForm.businessType!='dept_add'}">	
							<td colspan="100%">本年项目申报</td>
						</c:if>	
						<c:if test="${dprojTypeDetail=='cross'&& requestScope.dailyForm.businessType!='dept_add'}">	
							<td colspan="100%">跨年项目申报</td>
						</c:if>
						<c:if test="${dprojTypeDetail=='ahead'}">
							<td colspan="100%">预立项目申报</td>
						</c:if>	
						<c:if test="${dprojTypeDetail=='this'&& requestScope.dailyForm.businessType=='dept_add'}">	
							<td colspan="100%">部门年度预算追加(本年)</td>
						</c:if>	
						<c:if test="${dprojTypeDetail=='cross'&& requestScope.dailyForm.businessType=='dept_add'}">	
							<td colspan="100%">部门年度预算追加(跨年)</td>
						</c:if>		
					</tr>
				</thead>
			</table>
			
			<table class="commonList">
				<tr bordercolor="blue" bgcolor="#E4EDF9">
					<th>一级</th>
					<th>二级</th>
					<th>三级</th>
					<th>四级</th>
					<th>五级</th>
				</tr>
				<tr>
					<td>
						<html:hidden property="projectLevel1Code" name="dailyForm" styleId="projectLevel1Code"/>
						<html:text property="projectLevel1Name" name="dailyForm" styleId="projectLevel1Name" readonly="true"/>
					</td>
					<td>
						<html:hidden property="projectLevel2Code" name="dailyForm" styleId="projectLevel2Code"/>
						<html:text property="projectLevel2Name" name="dailyForm" styleId="projectLevel2Name" readonly="true"/>
					</td>
					<td>
						<html:hidden property="projectLevel3Code" name="dailyForm" styleId="projectLevel3Code"/>
						<html:text property="projectLevel3Name" name="dailyForm" styleId="projectLevel3Name" readonly="true"/>
					</td>
					<td>
						<html:hidden property="projectLevel4Code" name="dailyForm" styleId="projectLevel4Code"/>
						<html:text property="projectLevel4Name" name="dailyForm" styleId="projectLevel4Name" readonly="true"/>
					</td>
					<td>
						<html:hidden property="projectLevel5Code" name="dailyForm" styleId="projectLevel5Code"/>
						<html:text property="projectLevel5Name" name="dailyForm" styleId="projectLevel5Name" readonly="true"/>
					</td>
				</tr>
			</table>
			<table class="commonTable">
				<tr>
					<td class="bgcolorclass">
						预算科目
						<br>
					</td>
					<td class="contentclass">
						<html:hidden property="proBdgtSubjCode" name="dailyForm" styleId="proBdgtSubjCode"></html:hidden>
						<html:text name="dailyForm" property="proBdgtSubjName" readonly="true" styleId="proBdgtSubjName"></html:text>
						<br>
					</td>
					<td class="bgcolorclass">
						立项方式
						<br>
					</td>
					<td class="contentclass">
						<html:text name="dailyForm" property="applyType" readonly="true" styleId="applyType"></html:text>
						<br>
					</td>
					<td class="bgcolorclass">
						省归口部门
						<br>
					</td>
					<td class="contentclass">
						<html:hidden name="dailyForm" property="provLineDeptCode" styleId="provLineDeptCode"/>
						<html:text name="dailyForm" property="provLineDeptName" readonly="true" styleId="provLineDeptName"></html:text>
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass" colspan="6">
						<b>项目基本信息</b>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass">
						母项目
						<br>
					</td>
					<td class="contentclass">
						<html:hidden property="parentNo" name="dailyForm" styleId="parentNo"></html:hidden>
						<html:text name="dailyForm" property="parentName" readonly="true" styleId="parentName" onchange="isChangeMethod(this)"></html:text>
						<img name="batn" class="hand" src="<%=path%>/images/find2.gif"/>
						<br>
					</td>
					<td class="bgcolorclass">
						信息化母项目编码
						<br>
					</td>
					<td class="contentclass">
						<html:text name="dailyForm" property="infoProjectCode"  styleId="infoProjectCode" onchange="isChangeMethod(this)"></html:text>
						<br>
					</td>
					<td class="bgcolorclass">
						产品一体化编码
						<br>
					</td>
					<td class="contentclass">
						<html:text name="dailyForm" property="infoUnifyCode"  styleId="infoUnifyCode" onchange="isChangeMethod(this)"></html:text>
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass">
						项目名称
						<br>
					</td>
					<td class="contentclass">
						<html:text name="dailyForm" property="dprojName" styleId="dprojName" onchange="isChangeMethod(this)"></html:text><font color="red"> *</font>
						<br>
					</td>
					<td class="bgcolorclass">
						项目编码
						<br>
					</td>
					<td class="contentclass">
						<html:text name="dailyForm" property="dprojCode" styleId="dprojCode" readonly="true" />
						<br>
					</td>
					<td class="bgcolorclass">
						项目类型
						<br>
					</td>
					<td class="contentclass">
						<tag:dic name="addOrDefer" value="${dailyForm.addOrDefer }" staticDic="新增:新增;递延:递延" showType="select" ></tag:dic><font color="red"> *</font>
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass">
						项目总预算
						<br>
					</td>
					<td class="contentclass">
					<input readonly="true" type="text" name="totalCost" style="text-align:right"
							id="totalCost" value="<fmt:formatNumber pattern='#,##0.00' value='${dailyForm.totalCost}'/>" />
						元
						<br>
					</td>
					<td class="bgcolorclass">
						上期项目总预算
						<br>
					</td>
					<td class="contentclass" colspan="3">
					<input type="text" name="up1TotalValue" style="text-align:right" readonly="readonly"
							id="up1TotalValue" onchange="isChangeMethod(this)" value="<fmt:formatNumber pattern='#,##0.00' value='${dailyForm.up1TotalValue}'/>" />
						元
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass">
						项目起始时间
						<br>
					</td>
					<td class="contentclass">
						<input id="startDate" name="startDate" type="text"
							value='<fmt:formatDate pattern="yyyy-MM-dd" value="${dailyForm.startDate}"/>'
							readonly="true" onchange="isChangeMethod(this)"/><font color="red"> *</font>
							<c:if test="${dprojTypeDetail eq 'this' }">
								<img id="startDate1" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
							</c:if>
							<c:if test="${dprojTypeDetail eq 'cross' }">
								<img id="startDate2" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
							</c:if>
							<c:if test="${dprojTypeDetail eq 'ahead' && isCross eq '0'}">
								<img id="startDate3" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
							</c:if>
							<c:if test="${dprojTypeDetail eq 'ahead' && isCross eq '1'}">
								<img id="startDate4" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
							</c:if>
						<br>
					</td>
					<td class="bgcolorclass" >
						项目截止时间
						<br>
					</td>
					<td class="contentclass" colspan="3">
						<input id="endDate" name="endDate" type="text"
							value='<fmt:formatDate pattern="yyyy-MM-dd" value="${dailyForm.endDate}"/>'
							readonly="true" onchange="isChangeMethod(this)"/>
							<font color="red"> *</font>
							<c:if test="${dprojTypeDetail eq 'this' }">
								<img id="endDate1" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
							</c:if>
							<c:if test="${dprojTypeDetail eq 'cross' }">
								<img id="endDate2" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
							</c:if>	
							<c:if test="${dprojTypeDetail eq 'ahead' && isCross eq '0'}">
								<img id="endDate3" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
							</c:if>	
							<c:if test="${dprojTypeDetail eq 'ahead' && isCross eq '1'}">
								<img id="endDate4" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
							</c:if>	
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass" style="text-align:center;width:165px;">
						项目背景及内容描述
						<br>
					</td>
					<td colspan="5">
						<textarea name="remark" rows="3" style="font-size: 16px;width: 80%;line-height: 1.0;" class="expand70-700" onchange="isChangeMethod(this)">${dailyForm.remark}</textarea><font color="red"> *</font>
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass" style="text-align:center;width:165px;">
						项目预算构成及测算过程
						<br>
					</td>
					<td colspan="5">
						<textarea name="measure" rows="3" style="font-size: 16px;width: 80%;line-height: 1.0;" class="expand70-700" onchange="isChangeMethod(this)">${dailyForm.measure}</textarea><font color="red"> *</font>
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass" style="text-align:center;width:165px;">
						比价情况
						<br>
					</td>
					<td colspan="5">
						<textarea name="ratioPrice" rows="3" style="font-size: 16px;width: 80%;line-height: 1.0;" class="expand70-700" onchange="isChangeMethod(this)">${dailyForm.ratioPrice}</textarea><font color="red"> *</font>
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass" style="text-align: center;width: 165px;">
						项目期望目标
						<br>
					</td>
					<td colspan="5">
						<textarea style="font-size: 16px;leading:50;width: 80%;line-height: 1.0;" name="dprojAim" rows="2" onchange="isChangeMethod(this)">${dailyForm.dprojAim}</textarea><font color="red"> *</font>
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass">
						项目经办人
						<br>
					</td>
					<td class="contentclass">
						<html:text name="dailyForm" property="sponsor" styleId="sponsor" readonly="true"></html:text>
						<br>
					</td>
					<td class="bgcolorclass">
						项目经办部门
						<br>
					</td>
					<td class="contentclass" colspan="3">
						<html:text name="dailyForm" property="startDept" styleId="startDept" readonly="true" />
						<br>
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass">
						项目报销部门
						<br>
					</td>
					<td class="contentclass">
						<html:hidden property="tempbz" name="dailyForm" styleId="tempbz" />
						<html:text property="bzdept" name="dailyForm" styleId="bzdept"
							readonly="true" onchange="isChangeMethod(this)"></html:text>

						<font color="red"> *</font>
						<img id="testPop3" class="hand"
							src="<%=request.getContextPath()%>/images/find2.gif">
						<br>
					</td>
					<td class="bgcolorclass">
						项目签合同部门
					</td>
					<td class="contentclass" colspan="3">
						<input id="htDept" type="text" name="htDept" title="" value="${dailyForm.htDept}" style = "font-size: 12px;" readonly="true" onchange="isChangeMethod(this)"/>
                        <input id="tempht" type="hidden" name="tempht" title="" value="${dailyForm.tempht}"/>
						<img id="testPop5" class="hand" src="<%=request.getContextPath()%>/images/find2.gif">
					</td>
				</tr>
				<tr>
					<td class="bgcolorclass">部门副经理审批</td>
					<td class="contentclass">
						<select id="deputyDeptLeader" name="deputyDeptLeader" style="width:125px;" onchange="isChangeMethod(this)">
							<option value="">请选择</option>
							<logic:notEmpty name="deputyDeptLeaderList" scope="request">
								<logic:iterate id="deputyDeptLeaderId" name="deputyDeptLeaderList" scope="request">
								<c:if test="${deputyDeptLeader ne  deputyDeptLeaderId.personName}">
									<option value="${deputyDeptLeaderId.personCode }">${deputyDeptLeaderId.personName }</option>
								</c:if>
								<c:if test="${deputyDeptLeader eq  deputyDeptLeaderId.personName}">
									<option value="${deputyDeptLeaderId.personCode }" selected >${deputyDeptLeaderId.personName }</option>
								</c:if>
								</logic:iterate>
							</logic:notEmpty>
						</select>
					</td>
					<td class="bgcolorclass" >部门经理审批</td>
					<td class="contentclass" colspan="3">
						<select id="deptLeader" name="deptLeader" style="width:125px;" onchange="isChangeMethod(this)">
							<option value="">请选择</option>
							<logic:notEmpty name="deptLeaderList" scope="request">
								<logic:iterate id="deptLeaderId" name="deptLeaderList" scope="request">
								<c:if test="${deptLeader ne deptLeaderId.personName }">
									<option value="${deptLeaderId.personCode }">${deptLeaderId.personName }</option>
								</c:if>
								<c:if test="${deptLeader eq deptLeaderId.personName }">
									<option value="${deptLeaderId.personCode }" selected >${deptLeaderId.personName }</option>
								</c:if>
								</logic:iterate>
							</logic:notEmpty>
						</select>
						<font color="red"> *</font>
					</td>
				</tr>
			</table>
			<table class="commonList">
				<tr bordercolor="blue" bgcolor="#E4EDF9">
					<th colspan="4">当前年预算期间(<%=year %>)</th>
				</tr>
				<tr bordercolor="blue" bgcolor="#E4EDF9">
					<th>含税成本</th>
					<th>不含税成本</th>
					<th>增值税率</th>
					<th>增值税金</th>
				</tr>
				<tr>
					<td>
						<input  type="text" name="ytdTotalAmount" style="text-align:right"
							id="ytdTotalAmount" value="<fmt:formatNumber pattern='#,##0.00' value='${dailyForm.ytdTotalAmount}'/>" readonly="true"/>
						元
						<br>
					</td>
					<td>
						<input readonly="true" type="text" name="ytdTotalCost" style="text-align:right"
							id="ytdTotalCost" value="<fmt:formatNumber pattern='#,##0.00' value='${dailyForm.ytdTotalCost}'/>" />
						元
					</td>
					<td>
						<select id="taxRate" name="taxRate" class="taxRate" style="width: 125px;" onchange="isChangeMethod(this)">
							<option value="">请选择</option>
							<logic:notEmpty name="taxRateArr" scope="request">
								<logic:iterate id="taxRateId" name="taxRateArr">
								<c:if test="${dailyForm.taxRate ne taxRateId}">
									<option value="${taxRateId }">${taxRateId }</option>
								</c:if>
								<c:if test="${dailyForm.taxRate eq taxRateId}">
									<option value="${taxRateId }" selected >${taxRateId }</option>
								</c:if>
								</logic:iterate>
							</logic:notEmpty>	
						</select>
					</td>	
					<td>
						<input type="text" name="tax" style="text-align:right"
							id="tax" value="<fmt:formatNumber pattern='#,##0.00' value='${dailyForm.tax}'/>" onchange="isChangeMethod(this)"/>
						元
						<br>
					</td>
				</tr>
			</table>
			<table class="commonTable">
				<c:if test="${dprojTypeDetail eq 'cross' || isCross eq '1' }">
					<tr>
						<td class="bgcolorclass">
							跨年份各年预算明细
						</td>
						<td class="bgcolorclass" colspan="5">
							<a href="#" onclick="adjustPeriod();">明细填报/查看</a>
						</td>
					</tr>
				</c:if>
				<tr>
					<td class="bgcolorclass" style="text-align: center;width: 165px;">
						立&nbsp;项&nbsp;文&nbsp;档
						<br>
					</td>
					<td colspan="5">
						<iframe width="755" style="height:180px;" FRAMEBORDER=0 scrolling="auto"
							src="sysFile.do?method=init&orderObject=dailyForm&orderPropertyName=dprojId&orderPropertyValue=${dailyForm.dprojId}&dprojStatus=${dailyForm.status}&fileUploadUserid='${sessionScope.User.sysUser.userId}'&fileUploadUsername='${sessionScope.User.sysUser.username}'&fileUploadDeptid='${sessionScope.User.sysUser.orgId}'&fileUploadDeptname='${sessionScope.User.sysUser.orgname}'">
						</iframe>
						<br>
					</td>
				</tr>
				<tfoot>
					<tr align="center" >
						<td colspan="6" align="right">
							<button id="saveButton" title="保存"><img src="<%=request.getContextPath() %>/billow/ico13.gif" width="16" height="16" align="absmiddle"/>保存</button>
							<c:if test="${null != dailyForm.dprojCode}">
								<div id="buttonshow" style="position:relative;display:inline;top:8px;width: 80px;">
									<jsp:include page="../../workflow/processOperationPermissions.jsp"/>
								</div>
							</c:if>
							<button id="submButton" style="display: none;" title="提交" onclick="allFolw();"><img src="<%=request.getContextPath() %>/billow/ico13.gif" width="16" height="16" align="absmiddle"/>提交</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		</div>
	</body>
</html>

