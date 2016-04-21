<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="shortcut icon" href="favicon.ico">
     <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css?v=4.1.0" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/toastr/toastr.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
       <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>调任登记 </h5>
                        <div class="ibox-tools">
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-12 b-r">
		                           <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/leave/create" method="post">
		                           	<table class='table table-bordered'>
		                           		<thead>
		                           		<tr style="text-align: center;" ><td colspan="6" ><h3>调任单<h3></h3></td></tr>
		                           		</thead>
		                           		<tbody>
		                           			<tr>
		                           				<td>姓名</td>
		                           				<td> <input name='name' type="text" class="form-control"></td>
		                           				
		                           				<td>工号</td>
		                           				<td> <input name='user.username' type="text" class="form-control"></td>
		                           				
		                           				<td>签发日期</td>
		                           				<td> 
							                        <input name='signDate' type="text" class="form-control  input-group date" >
		                           				</td>
		                           			</tr>
		                           			
		                           			
		                           			<tr>
		                           				<td>原职称</td>
		                           				<td > 
		                           				  <select name='dept' class="form-control">
		                           						<option value='普工'>普工</option>
		                           						<option value='副科'>副科</option>
		                           						<option value='科长'>科长</option>
		                           						<option value='副部长'>副部长</option>
		                           						<option value='部长'>部长</option>
		                           						<option value='经理'>经理</option>
		                           						<option value='总经理'>总经理</option>
		                           					</select>
		                           				</td>
		                           				<td>原部门</td>
		                           				<td colspan="3"> 
		                           				    <select name='leavel' class="form-control">
		                           						<option value='财务部'>财务部</option>
		                           						<option value='人力资源部'>人力资源部</option>
		                           						<option value='行政管理部'>行政管理部</option>
		                           						<option value='市场部'>市场部</option>
		                           						<option value='项目部'>项目部</option>
		                           						<option value='产品部'>产品部</option>
		                           					</select>
		                           				</td>
		                           			</tr>
		                           			
		                           			<tr>
		                           				<td>调任后职务</td>
		                           				<td > 
		                           				<select name='todept' class="form-control">
		                           						<option value='普工'>普工</option>
		                           						<option value='副科'>副科</option>
		                           						<option value='科长'>科长</option>
		                           						<option value='副部长'>副部长</option>
		                           						<option value='部长'>部长</option>
		                           						<option value='经理'>经理</option>
		                           						<option value='总经理'>总经理</option>
		                           					</select>
		                           				</td>
		                           				<td>调任后职称</td>
		                           				<td colspan="3">
		                           				
		                           				 <select name='tolevel' class="form-control">
		                           						<option value='财务部'>财务部</option>
		                           						<option value='人力资源部'>人力资源部</option>
		                           						<option value='行政管理部'>行政管理部</option>
		                           						<option value='市场部'>市场部</option>
		                           						<option value='项目部'>项目部</option>
		                           						<option value='产品部'>产品部</option>
		                           					</select>
		                           				</td>
		                           			</tr>
		                           			<tr>
		                           				<td>调任原因</td>
		                           				<td colspan="5"> 
		                           					<textarea name='reason' rows="4" cols="" style="width: 80%"></textarea>
		                           				</td>
		                           			</tr>
		                           			<tr>
		                           				<td>提示</td>
		                           				<td colspan="5"> 
		                           					 <h4>提示</h4>
		                               					 <ol>
									    					<li>调任单必须填写完整</li>
									    					<li>必须主管签收后才能生效</li>
									    				</ol>
		                           				</td>
		                           			</tr>
		                           			<tr>
		                           				<td colspan="6"> 
		                           					 <div class="col-sm-4 col-sm-offset-2">
		                                  			  		<button class="btn btn-primary" type="submit">保存内容</button>
		                                   				    <button class="btn btn-white" type="submit">取消</button>
		                               				 </div>
		                           				</td>
		                           			</tr>
		                           		</tbody>
		                           	</table> 
		                           	</form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        
   </div>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/datapicker/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/toastr/toastr.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/common.js?v=1.0.0"></script>
    
    <script>
		$.common.setContextPath('${pageContext.request.contextPath}');
		<c:if test="${state=='success'}">
	  		  toastr.success('${tip}');
	    </c:if>
		
		function xzqhsq_change(id,obj){
			$.ajax({
    			type : "get",
    			url : $.common.getContextPath() + "/admin/code/xzqhxq?sq="+$(obj).val(),
    			dataType : "json",
    			success : function(json) {
    				if(json.state=='success'){
    					$("select[name='"+id+"']").empty();
    					$("select[name='"+id+"']").append("<option value=''>--请选择地市--</option>");
    					$(  json.data).each(function( index ) {
    						$("select[name='"+id+"']").append("<option value='"+ json.data[index].dm+"'>"+ json.data[index].name+"</option>");
    						  console.log( index + ": " + json.data[index].name);
    						});
    				}else{
    				}
    			}
    		});	
		}
		function init_xzqhsq(){
	    	$.ajax({
    			type : "get",
    			url : $.common.getContextPath() + "/admin/code/xzqhsq",
    			dataType : "json",
    			success : function(json) {
    				if(json.state=='success'){
    					$(  json.data).each(function( index ) {
    						$("select[name='sqdz'] , select[name='sqyydz']").append("<option value='"+ json.data[index].dm+"'>"+ json.data[index].name+"</option>");
    						  console.log( index + ": " + json.data[index].name);
    						});
    				}else{
    				}
    			}
    		});	
	    }
        $(document).ready(function(){
        	$(".input-group.date").datepicker({
        		language:  'zh-CN',
    	        weekStart: 1,
    	        todayBtn:  1,
    	        format:'yyyy-mm-dd',
    			autoclose: 1,
    			todayHighlight: 1,
    			startView: 2,
    			minView: 2,
    			forceParse: 0
        		});
        });
    </script>
</body>

</html>
