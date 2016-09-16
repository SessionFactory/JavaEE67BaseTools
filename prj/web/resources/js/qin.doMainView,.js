//region 页面一加载就运行的方法
$(function ()
    {
        //region 初始化软件表格信息
        ini_table();
        //endregion
    }
);
//endregion

//region 初始化软件表格信息
function ini_table()
{
    $('#tb_software').datagrid
    (
        {
            toolbar: '#top_soft',
            title: '软件详细信息',
            url: basePath + "/soft/searchAll.com",
            rownumbers: true,
            width: 1750,
            height: 768,
            pagination: true,
            columns://
                [
                    [
                        {field: 'soft_name', title: '名称', width: 200, align: 'center'},
                        {field: 'soft_description', title: '描述', width: 300, align: 'center'},
                        {field: 'soft_isHidden', title: '是否隐藏', width: 100, align: 'center'},
                        {field: 'soft_createTime', title: '创建时间', width: 200, align: 'center'},
                        {field: 'soft_type', title: '类型', width: 200, align: 'center'},
                        {field: 'soft_location', title: '位置', width: 200, align: 'center'},
                        {field: 'soft_size', title: '大小', width: 200, align: 'center'},
                        {field: 'soft_openWays', title: '打开方式', width: 300, align: 'center'}
                    ]
                ]
        }
    );
}
//endregion






















