<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@ include file="/common/headers/taglib-import.jspf"%>
<%@ include file="/common/headers/jquery-plugin.jsp"%>
<%@ include file="/common/headers/queryAndturnPage.jsp"%>
<%@ include file="/common/headers/jquery-validate-plugin.jsp"%>
<html>
<%
    String path = request.getContextPath();
	String dprojTypeDetail = (String)request.getAttribute("dprojTypeDetail");
%>
<head>
<title>成本项目立项新增</title>
<script language="javascript">
	var dprojTypeDetail='<%=dprojTypeDetail%>'
	jQuery(document).ready(function(){
		jQuery("input[name='totalAmount']").blur(function(){
			jQuery(this).formatMoney();
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
			if(dprojTypeDetail=='provToComp'){
				var isCross =jQuery("select[name='isCross']").val();
				if(isCross=='1'){
					var ytdTotalAmount = jQuery("input[name='ytdTotalAmount']").val();
					if(Number(thisValue.replace(/,/g,""))<Number(ytdTotalAmount.replace(/,/g,""))){
						alert("当前年金额不能大于申请总资源!!");
						jQuery(this).val(ytdTotalAmount);
					}
				}
			}
			
		});
		
		jQuery("input[name='ytdTotalAmount']").blur(function(){
			jQuery(this).formatMoney();
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
			var totalAmount = jQuery("input[name='totalAmount']").val();
			if(Number(thisValue.replace(/,/g,""))>Number(totalAmount.replace(/,/g,""))){
				alert("当前年金额不能大于申请总资源!!");
				jQuery(this).val(totalAmount);
			}
		});
		
		
		var validator=jQuery("#dailyApportion").validate({
			 rules:{
				 projectLevel1Code:{required:true},
		 		 projectLevel2Code:{required:true},
		 		 projectLevel3Code:{required:true},
		 		 subjectName:{required:true},
		 		 provToCompType:{required:true}
			 },
			 messages:{
				 
			 }
		});
		//下一步
		jQuery("#add").click(function(){
			
			if(!validator.form()){
	         	  validator.focusInvalid();
	        	 	return false;
	        }
			var totalAmount = jQuery("input[name='totalAmount']").val();
			if(Number(totalAmount.replace(/,/g,""))<=0){
				alert("申请资源必须大于0！！");
				return false;
			}
			
			if("provToComp"==dprojTypeDetail){
				var provToCompType=jQuery("select[name='provToCompType']").val();
				var isCross =jQuery("select[name='isCross']").val();
				
				if(isCross=='1'){
					var ytdTotalAmount = jQuery("input[name='ytdTotalAmount']").val();
					if(Number(ytdTotalAmount.replace(/,/g,""))<=0){
						alert("当前申请资源必须大于0！！");
						return false;
					}
				}	
				if(provToCompType=='prov'&&isCross=='0'){
					var reservedAmount = jQuery("input[name='reservedAmount']").val();
					if(Number(totalAmount.replace(/,/g,""))>Number(reservedAmount.replace(/,/g,""))){
						alert("申请的总资源大于省公司预留资源，请调整！！");
						return false;	
					}
				}else if(provToCompType=='prov'&&isCross=='1'){
					var reservedAmount = jQuery("input[name='reservedAmount']").val();
					var ytdTotalAmount = jQuery("input[name='ytdTotalAmount']").val();
					if(Number(ytdTotalAmount.replace(/,/g,""))>Number(reservedAmount.replace(/,/g,""))){
						alert("申请的当前年资源大于省公司预留资源，请调整！！");
						return false;	
					}
				}
			}	
			jQuery("#dailyApportion").submit();
		});
		
		//展示预留资源
		jQuery("select[name='provToCompType']").change(function(){
			var thisValue =jQuery(this).val();
			if(thisValue=='prov'){
				jQuery("#reserved").show();
			}else{
				jQuery("#reserved").hide();
			}
		});
		
		jQuery("select[name='isCross']").change(function(){
			var thisValue= jQuery(this).val();
			if(thisValue=='1'){
				jQuery("#aheadTh").show();
				jQuery("input[name='ytdTotalAmount']").show();
			}else{
				jQuery("#aheadTh").hide();
				jQuery("input[name='ytdTotalAmount']").hide();
			}
		});
	});
</script>

</head>
<body>
	<form action="<%=path %>/dailyApportion.do?method=view" method="post"
			id="dailyApportion">
			<input type="hidden" name="dprojTypeDetail" value="${dprojTypeDetail }">
		<table class="commonTable">
			<thead>
				<tr>
					<c:if test="${dprojTypeDetail eq 'provToComp' }">
						<td colspan="100%">省公司分摊分公司项目申报</td>	
					</c:if>
					<c:if test="${dprojTypeDetail eq 'compInner' }">
						<td colspan="100%">分公司内部项目申报</td>	
					</c:if>	
				</tr>
			</thead>	
		</table>
		<table class="commonList">
			<tr bordercolor="blue" bgcolor="#E4EDF9">
				<th colspan="5">项目层级</th>
			</tr>
			<tr bordercolor="blue" bgcolor="#E4EDF9">
				<th>一级</th>
				<th>二级</th>
				<th>三级</th>
				<th>四级</th>
				<th>五级</th>
			</tr>
			<tr>
				<td>
					<select id="projectLevel1Code" name="projectLevel1Code" class="projectLevel1Code" style="width: 150px;">
						<option value="">请选择...</option>
					</select>
					<font color="red">*</font>
				</td>
				<td>
					<select id="projectLevel2Code" name="projectLevel2Code" class="projectLevel2Code" style="width: 150px;">
					</select>
					<font color="red">*</font>
				</td>
				<td>
					<select id="projectLevel3Code" name="projectLevel3Code" class="projectLevel3Code" style="width: 150px;">
					</select>
					<font color="red">*</font>
				</td>
				<td>
					<select id="projectLevel4Code" name="projectLevel4Code" class="projectLevel4Code" style="width: 150px;">
					</select>
					<font color="red">*</font>
				</td>
				<td>
					<select id="projectLevel5Code" name="projectLevel5Code" class="projectLevel5Code" style="width: 150px;">
					</select>
					<font color="red">*</font>
				</td>
			</tr>
		</table>
		<br><br><br>
		<table class="commonList">
			<tr bordercolor="blue" bgcolor="#E4EDF9">
				<th width="20%">预算科目</th>
				<th width="20%">立项方式</th>
				<c:choose>
					<c:when test="${dprojTypeDetail ne 'provToComp' }">
						<th colspan="3"></th>
					</c:when>
					<c:otherwise>
						<th width="20%">是否跨年</th>
						<th colspan="2"></th>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>
					<select id="subjectCode" name="subjectCode" class="subjectCode" style="width: 150px;">
					</select><font color="red">*</font>
				</td>
				<td>
					<input type="text" id="applyType" name="applyType" value="" readonly="readonly"><font color="red">*</font>
				</td>
				<c:choose>
					<c:when test="${dprojTypeDetail ne 'provToComp' }">
						<td colspan="3">
						</td>
					</c:when>
					<c:otherwise>
						<td>
							<select id="isCross" name="isCross" style="width: 150px;">
								<option value="0">否</option>
								<option value="1">是</option>
							</select><font color="red">*</font>
						</td>
						<td colspan="2"></td>
					</c:otherwise>
				</c:choose>	
			</tr>
		</table>	
		<br><br><br>
		<table class="commonList">
			<tr bordercolor="blue" bgcolor="#E4EDF9">
				<c:if test="${dprojTypeDetail eq 'provToComp' }">
					<th width="20%">资源分摊方式</th>
					<th width="20%">申请总资源</th>	
					<th width="20%"><div id="aheadTh" style="display: none;">当前申请总资源</div></th>
					<th colspan="2"></th>
				</c:if>
				<c:if test="${dprojTypeDetail eq 'compInner' }">
					<th width="20%">申请总资源</th>	
					<th colspan="4"></th>
				</c:if>
			</tr>
			<tr>
				<c:if test="${dprojTypeDetail eq 'provToComp' }">
					<td>
						<tag:dic name="provToCompType" value="" staticDic="prov:省公司追加分公司资源;comp:分公司自行承担资源支出" showType="select" ></tag:dic><font color="red"> *</font>
					</td>
					<td>
						<input type="text" name="totalAmount" class="totalAmount" style="text-align:right"
								id="totalAmount" value=<fmt:formatNumber pattern='#,##0.00' value='0'/> /><font color="red">*</font>
					</td>
					<td>
						<input type="text" name="ytdTotalAmount" class="ytdTotalAmount" style="text-align:right;display: none;" 
								id="ytdTotalAmount" value=<fmt:formatNumber pattern='#,##0.00' value='0'/> />
					</td>
					<td colspan="2"></td>
				</c:if>
				<c:if test="${dprojTypeDetail eq 'compInner' }">
					<td>
						<input type="text" name="totalAmount" class="totalAmount" style="text-align:right"
								id="totalAmount" value=<fmt:formatNumber pattern='#,##0.00' value='0'/> /><font color="red">*</font>
					</td>
					<td colspan="4"></td>
				</c:if>	
			</tr>
			<tr>
				<td colspan="100%" id="reserved" style="display: none;" >
				<b>省公司预留资源:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="reservedAmount"  style="text-align:right"
							id=reservedAmount value=<fmt:formatNumber pattern='#,##0.00' value='${reservedAmount }'/> />
				</td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="100%" align="center">
						<button id="add" title="下一步">
							<img src="<%=request.getContextPath()%>/billow/ico12.gif"
								width="16" height="16" align="absmiddle" />
							下一步
						</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	
	<iframe src="" frameborder="0" scrolling="auto" height="300px" width="101.5%" name="detail" id="b_iframe"></iframe>
	<script type="text/javascript">
	//一级层级
	var url = '<%=path %>/budgetYearDetailTwoUp.do?method=getProjectLevel1&rand ='+Math.random();
	jQuery.getJSON(url,'' ,projectLevel1Code);
	function projectLevel1Code(data){
		var projectLevel1Code =jQuery("select[name='projectLevel1Code']");
		projectLevel1Code.empty();
		if(data.length>0){
			projectLevel1Code.append('<option value="">请选择...</option>');
			jQuery.each(data[0],function(i,obj){
				if(null!=obj[0] && ""!=obj[0]){
					projectLevel1Code.append('<option value="'+obj[0]+":"+obj[1]+'">'+obj[1]+'</option>');
				}				
			});
		}
	}
	//二级层级
	jQuery(".projectLevel1Code").change(function(){
		cleandata();
		var projectLevel1Code = jQuery(this).find("option:selected").val().split(":")[0]; //取一级项目层级编码
		if(projectLevel1Code==""){
			alert("一级层级不能为空！");
			return false;
		}
		var url = '<%=path %>/budgetYearDetailTwoUp.do?method=getProjectLevel2&projectLevel1Code='+projectLevel1Code+'&rand ='+Math.random();
		var projectLevel2Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel2Code']");
		projectLevel2Code.empty();
		jQuery.getJSON(url,'',function(data){
			if(data.length>0){
				projectLevel2Code.append('<option value="">请选择...</option>');
				jQuery.each(data[0],function(i,obj){
					if(null!=obj[0] && ""!=obj[0]){
						projectLevel2Code.append('<option value="'+obj[0]+":"+obj[1]+'">'+obj[1]+'</option>');
					}
				});
			}
		}); 	
		//当已选择了后边的列表，改变改层级是后边的都要清空
		jQuery(this).parent("td").parent("tr").find("select[name='projectLevel3Code']").empty();
		jQuery(this).parent("td").parent("tr").find("select[name='projectLevel4Code']").empty();
		jQuery(this).parent("td").parent("tr").find("select[name='projectLevel5Code']").empty();	
		jQuery(this).parent("td").parent("tr").find("select[name='subjectCode']").empty();
	});
	//获得三级项目层级
	jQuery(".projectLevel2Code").change(function(){
		cleandata();
		var projectLevel1Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel1Code']").find("option:selected").val().split(":")[0]; //一级编码
		var projectLevel2Code = jQuery(this).find("option:selected").val().split(":")[0]; //二级编码
		if(projectLevel1Code==""){
			alert("一级层级不能为空！");
			return false;
		}
		if(projectLevel2Code==""){
			alert("二级层级不能为空！");
			return false;
		}
		var url = '<%=path %>/budgetYearDetailTwoUp.do?method=getProjectLevel3&projectLevel1Code='+projectLevel1Code+'&projectLevel2Code='+projectLevel2Code+'&rand ='+Math.random();
		var projectLevel3Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel3Code']");
		projectLevel3Code.empty();
		jQuery.getJSON(url,'',function(data){
			if(data.length>0){
				projectLevel3Code.append('<option value="">请选择...</option>');
				jQuery.each(data[0],function(i,obj){
					if(null!=obj[0] && ""!=obj[0]){
						projectLevel3Code.append('<option value="'+obj[0]+":"+obj[1]+'">'+obj[1]+'</option>');
					}				
				});
			}
		});	
		//当已选择了后边层级，改变改层级是后边的都要清空
		jQuery(this).parent("td").parent("tr").find("select[name='projectLevel4Code']").empty();
		jQuery(this).parent("td").parent("tr").find("select[name='projectLevel5Code']").empty();
		jQuery(this).parent("td").parent("tr").find("select[name='subjectCode']").empty();
	});
	//获得四级项目层级
	jQuery(".projectLevel3Code").change(function(){
		cleandata();
		var projectLevel1Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel1Code']").find("option:selected").val().split(":")[0]; //一级编码
		var projectLevel2Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel2Code']").find("option:selected").val().split(":")[0]; //二级编码
		var projectLevel3Code = jQuery(this).find("option:selected").val().split(":")[0]; //三级编码
		var dom = jQuery(this);
		if(projectLevel1Code==""){
			alert("一级层级不能为空！");
			return false;
		}
		if(projectLevel2Code==""){
			alert("二级层级不能为空！");
			return false;
		}
		if(projectLevel3Code ==""){
			alert("三级层级不能为空！");
			return false;
		}	
		var url = '<%=path %>/budgetYearDetailTwoUp.do?method=getProjectLevel4&projectLevel1Code='+projectLevel1Code+'&projectLevel2Code='+projectLevel2Code+
				'&projectLevel3Code='+projectLevel3Code+'&rand ='+Math.random();
		var projectLevel4Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel4Code']");
		projectLevel4Code.empty();
		jQuery.getJSON(url,'',function(data){
			if(data.length>0){
				projectLevel4Code.append('<option value="">请选择...</option>');
				jQuery.each(data[0],function(i,obj){
					if(null!=obj[0] && ""!=obj[0]){
						projectLevel4Code.append('<option value="'+obj[0]+":"+obj[1]+'">'+obj[1]+'</option>');
					}else if(data[0].length==1&&(null==obj[0]||""==obj[0])){
						projectLevel4Code.empty();
						subjectCode(dom); //获得预算科目
					}				
				});
			}
		});	
		//当已选择了后边层级，改变改层级是后边的都要清空
		jQuery(this).parent("td").parent("tr").find("select[name='projectLevel5Code']").empty();
		jQuery(this).parent("td").parent("tr").find("select[name='subjectCode']").empty();
	});
	//获得四级项目层级
	jQuery(".projectLevel4Code").change(function(){
		cleandata();
		var projectLevel1Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel1Code']").find("option:selected").val().split(":")[0]; //一级编码
		var projectLevel2Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel2Code']").find("option:selected").val().split(":")[0]; //二级编码
		var projectLevel3Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel3Code']").find("option:selected").val().split(":")[0]; //三级编码	
		var projectLevel4Code = jQuery(this).find("option:selected").val().split(":")[0]; //四级项目编码
		var dom = jQuery(this);
		if(projectLevel1Code==""){
			alert("一级层级不能为空！");
			return false;
		}
		if(projectLevel2Code==""){
			alert("二级层级不能为空！");
			return false;
		}
		if(projectLevel3Code ==""){
			alert("三级层级不能为空！");
			return false;
		}
		if(projectLevel4Code ==""){
			alert("四级层级不能为空！");
			return false;		
		}	
		var url = '<%=path %>/budgetYearDetailTwoUp.do?method=getProjectLevel5&projectLevel1Code='+projectLevel1Code+'&projectLevel2Code='+projectLevel2Code+
				'&projectLevel3Code='+projectLevel3Code+'&projectLevel4Code='+projectLevel4Code+'&rand ='+Math.random();
		var projectLevel5Code = jQuery(this).parent("td").parent("tr").find("select[name='projectLevel5Code']");
		projectLevel5Code.empty();
		jQuery.getJSON(url,'',function(data){
			if(data.length>0){
				projectLevel5Code.append('<option value="">请选择...</option>');
				jQuery.each(data[0],function(i,obj){
					if(null!=obj[0] && ""!=obj[0]){
						projectLevel5Code.append('<option value="'+obj[0]+":"+obj[1]+'">'+obj[1]+'</option>');					
					}else if(data[0].length==1&&(null==obj[0]||""==obj[0])){
						projectLevel5Code.empty();
						subjectCode(dom); //获得预算科目
					}
				});
			}
		});	
		//当已选择了后边层级，改变改层级是后边的都要清空
		jQuery(this).parent("td").parent("tr").find("select[name='subjectCode']").empty();
	});
	//获得四级项目层级
	jQuery(".projectLevel5Code").change(function(){
		var dom = jQuery(this);
		subjectCode(dom);
	});
	
	//获得预算科目
	function subjectCode(dom){
		var projectLevel1Code = dom.parent("td").parent("tr").find("select[name='projectLevel1Code']").find("option:selected").val().split(":")[0]; //一级编码
		var projectLevel2Code = dom.parent("td").parent("tr").find("select[name='projectLevel2Code']").find("option:selected").val().split(":")[0]; //二级编码
		var projectLevel3Code = dom.parent("td").parent("tr").find("select[name='projectLevel3Code']").find("option:selected").val().split(":")[0]; //三级编码	
		var projectLevel4Code = dom.parent("td").parent("tr").find("select[name='projectLevel4Code']").find("option:selected").val(); //四级编码	
		var projectLevel5Code = dom.parent("td").parent("tr").find("select[name='projectLevel5Code']").find("option:selected").val(); //五级编码	
		if(projectLevel1Code==""){
			alert("一级层级不能为空！");
			return false;
		}
		if(projectLevel2Code==""){
			alert("二级层级不能为空！");
			return false;
		}
		if(projectLevel3Code ==""){
			alert("三级层级不能为空！");
			return false;
		}
		//如果四级或者五层级为空 ，获得的值为undefind，将其置为空
		if(projectLevel4Code==undefined){
			projectLevel4Code = "";
		}else{
			projectLevel4Code=projectLevel4Code.split(":")[0];
		}
		if(projectLevel5Code==undefined){
			projectLevel5Code = "";
		}else{
			projectLevel5Code=projectLevel5Code.split(":")[0];
		}
		
		var subjectCode = jQuery("select[name='subjectCode']");
		subjectCode.empty();
		var url = '<%=path %>/budgetYearDetailTwoUp.do?method=getSubject&dprojTypeDetail=<%=dprojTypeDetail%>&projectLevel1Code='+projectLevel1Code+'&projectLevel2Code='+projectLevel2Code+
			'&projectLevel3Code='+projectLevel3Code+'&projectLevel4Code='+projectLevel4Code+'&projectLevel5Code='+projectLevel5Code+'&rand ='+Math.random();
		jQuery.getJSON(url,'',function(data){		
			if(data.length>0){
					subjectCode.append('<option value="">请选择...</option>');
			 
				jQuery.each(data[0],function(i,obj){
					if(null!=obj[0] && ""!=obj[0]){
						subjectCode.append('<option value="'+obj[0]+":"+obj[1]+'">'+obj[1]+'</option>');	
						if(data[0].length==1){
							autoShow(obj[0]); 
							$("#subjectCode option[value='']").remove();
						}
					}
				});	
			}
		});
	}
	
	function autoShow(code){
		document.getElementById("b_iframe").src='';
		var projectLevel1Code = jQuery("select[name='projectLevel1Code']").find("option:selected").val().split(":")[0]; //一级编码
		var projectLevel2Code = jQuery("select[name='projectLevel2Code']").find("option:selected").val().split(":")[0]; //二级编码
		var projectLevel3Code = jQuery("select[name='projectLevel3Code']").find("option:selected").val().split(":")[0]; //三级编码	
		var projectLevel4Code = jQuery("select[name='projectLevel4Code']").find("option:selected").val(); //四级编码	
		var projectLevel5Code = jQuery("select[name='projectLevel5Code']").find("option:selected").val(); //五级编码
		var subjectCode = code;
		if(projectLevel1Code==""){
			alert("一级层级不能为空！");
			return false;
		}
		if(projectLevel2Code==""){
			alert("二级层级不能为空！");
			return false;
		}
		if(projectLevel3Code ==""){
			alert("三级层级不能为空！");
			return false;
		}
		//如果四级或者五层级为空 ，获得的值为undefind，将其置为空
		if(projectLevel4Code==undefined){
			projectLevel4Code = "";
		}else{
			projectLevel4Code=projectLevel4Code.split(":")[0];
		}
		if(projectLevel5Code==undefined){
			projectLevel5Code = "";
		}else{
			projectLevel5Code=projectLevel5Code.split(":")[0];
		}
		if(subjectCode ==undefined){
			subjectCode = "";
		}else{
			subjectCode =subjectCode.split(":")[0];
		}
		
		if(subjectCode != ""){
			var url = '<%=path %>/budgetYearDetailTwoUp.do?method=getApplyType&dprojTypeDetail=<%=dprojTypeDetail%>&projectLevel1Code='+projectLevel1Code+'&projectLevel2Code='+projectLevel2Code+
			'&projectLevel3Code='+projectLevel3Code+'&projectLevel4Code='+projectLevel4Code+'&projectLevel5Code='+projectLevel5Code+'&subjectCode='+subjectCode+'&rand ='+Math.random();
			jQuery.getJSON(url,'',function(data){
				jQuery("input[name='applyType']").val(data.applyType);
			});

		}
	}
	
	jQuery(".subjectCode").change(function(){
		document.getElementById("b_iframe").src='';
		var projectLevel1Code = jQuery("select[name='projectLevel1Code']").find("option:selected").val().split(":")[0]; //一级编码
		var projectLevel2Code = jQuery("select[name='projectLevel2Code']").find("option:selected").val().split(":")[0]; //二级编码
		var projectLevel3Code = jQuery("select[name='projectLevel3Code']").find("option:selected").val().split(":")[0]; //三级编码	
		var projectLevel4Code = jQuery("select[name='projectLevel4Code']").find("option:selected").val(); //四级编码	
		var projectLevel5Code = jQuery("select[name='projectLevel5Code']").find("option:selected").val(); //五级编码
		var subjectCode = jQuery(this).find("option:selected").val();
		if(projectLevel1Code==""){
			alert("一级层级不能为空！");
			return false;
		}
		if(projectLevel2Code==""){
			alert("二级层级不能为空！");
			return false;
		}
		if(projectLevel3Code ==""){
			alert("三级层级不能为空！");
			return false;
		}
		//如果四级或者五层级为空 ，获得的值为undefind，将其置为空
		if(projectLevel4Code==undefined){
			projectLevel4Code = "";
		}else{
			projectLevel4Code=projectLevel4Code.split(":")[0];
		}
		if(projectLevel5Code==undefined){
			projectLevel5Code = "";
		}else{
			projectLevel5Code=projectLevel5Code.split(":")[0];
		}
		if(subjectCode ==undefined){
			subjectCode = "";
		}else{
			subjectCode =subjectCode.split(":")[0];
		}
		
		if(subjectCode != ""){
			var url = '<%=path %>/budgetYearDetailTwoUp.do?method=getApplyType&dprojTypeDetail=<%=dprojTypeDetail%>&projectLevel1Code='+projectLevel1Code+'&projectLevel2Code='+projectLevel2Code+
			'&projectLevel3Code='+projectLevel3Code+'&projectLevel4Code='+projectLevel4Code+'&projectLevel5Code='+projectLevel5Code+'&subjectCode='+subjectCode+'&rand ='+Math.random();
			jQuery.getJSON(url,'',function(data){
				jQuery("input[name='applyType']").val(data.applyType);
			});

		}
	});
	//科目改变数据清空
	function cleandata(){
		jQuery("input[name='subjectCode']").val("");
		jQuery("input[name='subjectName']").val("");
		jQuery("input[name='applyType']").val("");
	}
	</script>	
		
</body>
</html>
