//region 页面一加载就运行的方法
$(function ()
    {
        //region 初始化软件表格信息
        ini_table();
        //endregion

        //region 增
        $('#addSoft').click(function ()
            {
                doAdd();
            }
        );
        //endregion

        //region 删
        //endregion

        //region 改
        //endregion

        //region 查
        $('#searchSoft').click(function ()
            {
                doSearch();
            }
        );
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
                ],
            onLoadSuccess: function ()
            {
                //region 加载软件打开方式信息
                //加载软件打开方式信息
                $.ajax
                (
                    {
                        url: basePath + '/softOpenWays/searchNames.com',
                        method: 'post',
                        success: function (msg)
                        {
                            //console.log(msg);
                            $('#soft_openWays2').append(msg);
                        }
                    }
                );//end ajax
                //endregion

                //region 加载软件类型下拉框信息
                $.ajax
                (
                    {
                        url: basePath + "/softType/searchNames.com",
                        method: 'POST',
                        success: function (msg)
                        {
                            $('#soft_type2').append(msg);
                        }
                    }
                );//end ajax
                //endregion
            }
        }
    );

    //设置分页控件
    var p = $('#tb_software').datagrid('getPager');
    $(p).pagination
    (
        {
            //每页显示的记录条数,默认为20
            pageSize: 20,
            //可以设置每页记录条数的列表
            pageList: [40, 80, 200],
            //页数文本框前显示的汉字
            beforePageText: '第',
            afterPageText: '页 共 {pages} 页',
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
        }
    );
}
//endregion

//region 增
function doAdd()
{
    //region 初始化对话框
    $('#dlg_addSoft').dialog
    (
        {
            title: '新增软件信息',
            width: 1800,
            height: 600,
            closed: false,
            modal: true
        }
    );
    //endregion
}
//endregion

//region 删
//endregion

//region 改
//endregion

//region 查
function doSearch()
{
    //region 接收界面控件值
    var $form = $('#queryForm');

    var nodes =
    {
        //名称
        soft_name: $form.find('input[name="soft_name"]').val(),
        //描述
        soft_description: $form.find('input[name="soft_description"]').val(),
        //是否隐藏
        soft_isHidden: $('#soft_isHidden2 option:selected')[0].innerHTML,
        //创建日期
        soft_createTime: $('#soft_createTime2').datetimebox('getValue'),
        //类型
        soft_type: $('#soft_type2 option:selected')[0].innerHTML,
        //位置
        soft_location: $form.find('input[name="soft_location"]').val(),
        //大小
        soft_size: $form.find('input[name="soft_size"]').val(),
        //打开方式
        soft_openWays: $('#soft_openWays2 option:selected')[0].innerHTML
    };
    //endregion

    //region 验证界面控件
    if (nodes.soft_name.length > 50)
    {
        showWrongMsg("软件名称长度不能超过50个字符!");
    }
    if (nodes.soft_description.length > 3000)
    {
        showWrongMsg("软件描述长度不能超过3000个字符!");
    }
    if (nodes.soft_location.length > 300)
    {
        showWrongMsg("软件描述长度不能超过300个字符!");
    }
    if (nodes.soft_size.length > 87)
    {
        showWrongMsg("软件大小不能超过87个字符!");
    }
    //endregion

    //region 将值传递到前台进行查询
    var doSearchURL = basePath + "/soft/searchSoft.com?" +
        //String
        "soft_name=" + nodes.soft_name +
        //String
        "       &&soft_description=" + nodes.soft_description +
        //Boolean
        "       &&soft_isHidden2=" + nodes.soft_isHidden +
        //Date
        "       &&soft_createTime2=" + nodes.soft_createTime +
        //SoftType
        "       &&soft_type2=" + nodes.soft_type +
        //String
        "       &&soft_location=" + nodes.soft_location +
        //String
        "       &&soft_size=" + nodes.soft_size +
        //SoftOpenWays
        "       &&soft_openWays2=" + nodes.soft_openWays +
        "       &&soft_createTime3=" + $('#soft_createTime3').datetimebox('getValue');

    $.ajax
    (
        {
            url: doSearchURL,
            method: 'POST',
            success: function (msg)
            {
                if (msg != "没有任何记录")
                {
                    window.location = basePath + "/soft/mySearchPage.com?msg=" + msg;
                }
            }
        }
    );
    //endregion
}
//endregion

//region 注释
/*
 basePath + "/soft/searchSoft.com?" +
 //String
 "soft_name=" + nodes.soft_name +
 //String
 "       &&soft_description=" + nodes.soft_description +
 //Boolean
 "       &&soft_isHidden2=" + nodes.soft_isHidden +
 //Date
 "       &&soft_createTime2=" + nodes.soft_createTime +
 //SoftType
 "       &&soft_type2=" + nodes.soft_type +
 //String
 "       &&soft_location=" + nodes.soft_location +
 //String
 "       &&soft_size=" + nodes.soft_size +
 //SoftOpenWays
 "       &&soft_openWays2=" + nodes.soft_openWays;
 */

//var params = $.param(nodes);
//endregion












