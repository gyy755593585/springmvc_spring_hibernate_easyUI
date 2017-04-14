<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>用户管理</title>

</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div>
		<table class="easyui-datagrid" id="dataGrid"
			data-options="singleSelect:true,
       collapsible:true,
       pagination:true,
       url:'${path}/user/list',
       rownumbers : true,
       method:'get',
       pageSize:20,
      ">
			<thead>
				<tr>
					<th data-options="field:'id'">ID</th>
					<th data-options="field:'username',width:200">用户名</th>
					<th data-options="field:'password',width:200">密码</th>
					
				</tr>
			</thead>
		</table>
	</div>
	<div id="toolbar" style="display: none;"></div>
</body>
</html>