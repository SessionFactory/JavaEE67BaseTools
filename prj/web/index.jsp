<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/15 9-015-15
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="WEB-INF/include_easyui.jsp"></jsp:include>
</head>

<body class="easyui-layout">
<div data-options="region:'west',title:'导航菜单',split:true" style="width:310px;">
    <jsp:include page="WEB-INF/jsp/navigator.jsp"></jsp:include>
</div>
<div data-options="region:'center',title:'主页'"
     style="padding:5px;background:#eee;height: 3000px;">
</div>
</body>

</html>
