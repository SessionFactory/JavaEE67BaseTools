<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<head>
    <title>新增软件信息</title>
    <jsp:include page="/WEB-INF/include_easyui.jsp"></jsp:include>
    <script type="text/javascript" src="<c:url value="/resources/js/qin.iniSelect.js"/> "></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/qin.doMainView.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/qin.doAdd.css"/> ">

    <script type="text/javascript" src="<c:url value="/resources/js/soft/qin.doAdd.js"/> "></script>
</head>

<body class="easyui-layout">
<div data-options="region:'west',title:'导航菜单',split:true" style="width:310px;">
    <jsp:include page="/WEB-INF/jsp/navigator.jsp"></jsp:include>
</div>
<div data-options="region:'center',title:'用户'"
     style="padding:5px;background:#eee;height: 3000px;">
    <%--<form id="addFrm" name="addFrm" action="/j6/soft/addSoft.com">--%>
    <table width="1750" border="10" bordercolor="#CC3366">
        <tr>
            <td colspan="3" class="add_titleFont" align="center">添加软件信息</td>
        </tr>
        <tr align="center">
            <td width="300" class="row_titleFont">字段</td>
            <td class="row_titleFont">
                控件
            </td>
            <td class="row_titleFont" width="400">
                说明
            </td>
        </tr>
        <tr align="center">
            <td width="300" class="row_titleFont">名称</td>
            <td>
                <input type="text" id="soft_name" name="soft_name" placeholder="软件名称" class="form-control2">
            </td>
            <td class="tb_description" width="400">
                1.软件名称不能为空!<br>
                2.长度不能超过50个字符!<br>
                3.只能以中文和英文开头!例如eclipse, IE, 谷歌浏览器等等<br>
                4.不能以数字开头!<br>
                5.软件名称长度必须大于或等于2个字符
            </td>
        </tr>
        <tr align="center">
            <td class="row_titleFont">描述</td>
            <td>
                <input type="text" id="soft_description" name="soft_description" placeholder="软件描述"
                       class="form-control2">
            </td>
            <td class="tb_description">
                1.软件描述可以为空!<br>
                2.软件描述长度不能超过3000个字!<br>
            </td>
        </tr>
        <tr align="center">
            <td class="row_titleFont">是否隐藏</td>
            <td>
                <select id="soft_isHidden2" name="soft_isHidden2" class="easyui-combobox" style="width:200px;">
                    <option value="1">是</option>
                    <option>否</option>
                </select>
            </td>
            <td class="tb_description">
                从下拉框中选择!<br>
                是为1, 否为0<br>
            </td>
        </tr>
        <tr align="center">
            <td class="row_titleFont">创建时间</td>
            <td class="tb_content">
                <input id="soft_createTime2" name="soft_createTime2" type="text" class="easyui-datebox"
                       required="required" style="width: 160px;">
            </td>
            <td class="tb_description">
                软件创建时间不能为空!
            </td>
        </tr>
        <tr align="center">
            <td class="row_titleFont">类型名称</td>
            <td>
                <select id="soft_type2" name="soft_type2" style="width: 80%;">
                </select>
            </td>
            <td class="tb_description">
                从下拉框中选择!
            </td>
        </tr>
        <tr align="center">
            <td class="row_titleFont">位置</td>
            <td>
                <input type="text" class="form-control2" placeholder="软件位置" id="soft_location" name="soft_location">
            </td>
            <td class="tb_description">
                1.软件位置不能为空!<br>
                2.长度不能超过300个字符!<br>
                3.必须以中文或英文开头!不能以英文开头!
            </td>
        </tr>
        <tr align="center">
            <td class="row_titleFont">大小</td>
            <td class="tb_content">
                <input type="text" placeholder="软件大小" id="soft_size" name="soft_size" class="form-control2">MB
            </td>
            <td class="tb_description">
                1.软件大小不能为空!<br>
                2.长度不能超过90个字符!<br>
                3.软件大小必须全部是数字!
            </td>
        </tr>
        <tr align="center">
            <td class="row_titleFont">打开方式</td>
            <td>
                <select id="soft_openWays2" name="soft_openWays2" style="width: 80%;">
                </select>
            </td>
            <td class="tb_description">
                从下拉框中选择!
            </td>
        </tr>
        <tr align="center">
            <td colspan="3">
                <!-- <a href="/j6/soft/addSoft.com" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a> -->
                <a class="easyui-linkbutton c3" data-options="iconCls:'icon-add'" style=" font-family: 微软雅黑;"
                   id="btn_add" name="btn_add">新增</a>
            </td>
        </tr>
    </table>
    <%--</form>--%>
</div>
</body>