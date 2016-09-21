<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="/WEB-INF/include_easyui.jsp"></jsp:include>
    <script type="text/javascript" src="<c:url value="/resources/js/qin.doMainView.js"/> "></script>
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
            <a class="easyui-linkbutton c1" data-options="iconCls:'icon-add'" style="width:150px"
               id="addSoft" name="addSoft">
                新增软件信息
            </a>
            <br><br>
            <a class="easyui-linkbutton c2" data-options="iconCls:'icon-cut'" style="width:150px"
               id="delSoft" name="deleteSoft">
                删除软件信息
            </a>
            <br><br>
            <a class="easyui-linkbutton c3" data-options="iconCls:'icon-edit'" style="width:150px"
               id="updSoft" name="updateSoft">
                修改软件信息
            </a>
            <br><br>
            <a class="easyui-linkbutton c4" data-options="iconCls:'icon-search'" style="width:150px"
               id="searchSoft" name="searchSoft">
                查询软件信息
            </a>
        </div>
        <div data-options="region:'center',title:'主菜单'" style="padding:5px;background:#eee;">
            <table id="tb_software"></table>
            <br>

            <!--
            <div>
                <style type="text/css">
                    /*表示是搜索页面的样式*/
                    .s_titleFont
                    {
                        font-family: 微软雅黑;
                        font-size: 60px;
                        color: black;
                        font-weight: bold;
                    }

                    /*标题样式(第二行)*/
                    .s_rownum2
                    {
                        font-family: 微软雅黑;
                        font-size: 16px;
                        color: #039;
                    }

                    /*表格中内容样式*/
                    .s_content
                    {
                        font-family: 微软雅黑;
                        font-size: 16px;
                        color: #C09;
                    }
                </style>

                <table width="1750" border="4" bordercolor="#66FF99">
                    <tr>
                        <td colspan="9" align="center" class="s_titleFont">软件详细信息:</td>
                    </tr>
                    <tr class="s_rownum2" align="center">
                        <td>编号</td>
                        <td>名称</td>
                        <td>描述</td>
                        <td>是否隐藏</td>
                        <td>创建时间</td>
                        <td>类型编号+类型名称</td>
                        <td>位置</td>
                        <td>大小(MB)</td>
                        <td>打开方式编号+名称</td>
                    </tr>
                    <tr class="s_content" align="center">
                        <td>1</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
            -->

            <div id="div_mySearch">
                <%
                    String msg = request.getParameter("msg");

                    out.println
                            (
                                    new StringBuilder()
                                            .append("<table class=\"easyui-datagrid\" style=\"width:1750;height:250px\"\n")
                                            .append("    data-options=\"fitColumns:true,singleSelect:true,rownumbers:true\">")
                                            .append(msg)
                                            .append("</table>")
                                            .toString()
                            );
                %>
            </div>

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
                    <!--
                    <select id="soft_isHidden" class="easyui-combobox" name="soft_isHidden" style="width:200px;">
                        <option value="true">是</option>
                        <option value="false">否</option>
                    </select>
                    -->
                    <!-- boolean -->
                    <select id="soft_isHidden2" name="soft_isHidden2" class="easyui-combobox" style="width:200px;">
                        <option value="true">是</option>
                        <option value="false">否</option>
                    </select>
                </td>
                <td>下拉框</td>
            </tr>
            <tr>
                <td>软件创建时间</td>
                <td align="center">
                    <!--
                    <input id="soft_createTime" name="soft_createTime" type="text" class="easyui-datebox"
                           required="required" style="width: 160px;">
                    -->
                    从
                    <input id="soft_createTime2" name="soft_createTime2" type="text" class="easyui-datebox"
                           required="required" style="width: 160px;">
                    到&nbsp;&nbsp;
                    <input id="soft_createTime3" name="soft_createTime3" type="text" class="easyui-datebox"
                           required="required" style="width: 160px;">
                </td>
                <td>datetimebox</td>
            </tr>
            <tr>
                <td>软件类型</td>
                <td align="center">
                    <!--
                    <select id="soft_type" name="soft_type" style="width: 80%;">
                    </select>
                    -->
                    <select id="soft_type2" name="soft_type2" style="width: 80%;">
                    </select>
                </td>
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
                <td align="center">
                    <!--
                    <select id="soft_openWays" name="soft_openWays" style="width: 80%;">
                    </select>
                    -->
                    <select id="soft_openWays2" name="soft_openWays2" style="width: 80%;">
                    </select>
                </td>
                <td>下拉框(从openways表中检索)</td>
            </tr>
        </table>
    </form>

    <br><br>

</div>

</body>

</html>











































