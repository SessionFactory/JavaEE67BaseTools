<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="aa" class="easyui-accordion" style="width:300px;height:200px;">
    <div title="用户管理" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
    </div>
    <div title="软件管理" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
        <a href="/j6/soft/doMainView.com" class="easyui-linkbutton c1" style="width:120px" id="btn_showSoft" name="btn_showSoft">
            查看软件信息
        </a>
    </div>
</div>