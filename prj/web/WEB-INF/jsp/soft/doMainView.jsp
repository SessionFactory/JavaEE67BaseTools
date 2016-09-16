<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="/WEB-INF/include_easyui.jsp"></jsp:include>
    <script type="text/javascript" src="<c:url value="/resources/js/qin.doMainView,.js"/> "></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/qin.doMainView.css"/> ">
</head>

<body class="easyui-layout">
<div data-options="region:'west',title:'导航菜单',split:true" style="width:310px;">
    <jsp:include page="/WEB-INF/jsp/navigator.jsp"></jsp:include>
</div>
<div data-options="region:'center',title:'用户'"
     style="padding:5px;background:#eee;height: 3000px;">
    <div class="easyui-layout" style="width: 100%; height: 100%">
        <div data-options="region:'west',title:'导航',split:true" style="width:200px;">
        </div>
        <div data-options="region:'center',title:'主菜单'"
             style="padding:5px;background:#eee;">
            <table id="tb_software"></table>
        </div>
    </div>
</div>

<!-- 工具栏(搜索框) -->
<div id="top_soft">
    <form id="queryForm" name="queryForm" method="post">
        <table width="1700" border="10" style="font-family:微软雅黑;" bordercolor="#CC3366">
            <tr>
                <td>字段</td>
                <td>控件</td>
                <td>说明</td>
            </tr>
            <tr>
                <td>软件名称</td>
                <td>
                    <input type="text" class="form-control" placeholder="软件名称" id="soft_name" name="soft_name">
                </td>
                <td>只能以英文字母或中文开头, 不能以中文开头</td>
            </tr>
            <tr>
                <td>软件描述</td>
                <td>
                    <input type="text" class="form-control" placeholder="软件描述" id="soft_description" name="soft_description">
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>软件是否隐藏</td>
                <td align="center">
                    <select id="soft_isHidden" class="easyui-combobox" name="soft_isHidden" style="width:200px;">
                        <option value="true">是</option>
                        <option value="false">否</option>
                    </select>
                </td>
                <td>下拉框</td>
            </tr>
            <tr>
                <td>软件创建时间</td>
                <td align="center">
                    <input id="soft_createTime" name="soft_createTime" type="text" class="easyui-datebox"
                           required="required" style="width: 160px;">
                </td>
                <td>datetimebox</td>
            </tr>
            <tr>
                <td>软件类型</td>
                <td>&nbsp;</td>
                <td>下拉框(从type表中检索)</td>
            </tr>
            <tr>
                <td>软件位置</td>
                <td>
                    <input type="text" class="form-control" placeholder="软件位置" id="soft_location" name="soft_location">
                </td>
                <td>只能以中文或英文开头</td>
            </tr>
            <tr>
                <td>软件大小</td>
                <td>
                    <input type="text" placeholder="软件大小" id="soft_size" name="soft_size" class="form-control">MB
                </td>
                <td>只能是数字</td>
            </tr>
            <tr>
                <td>软件打开方式</td>
                <td>&nbsp;</td>
                <td>下拉框(从openways表中检索)</td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    btn_to_search
                </td>
            </tr>
        </table>
    </form>

    <br><br>

</div>
<!-- 工具栏 -->

</body>

</html>
































