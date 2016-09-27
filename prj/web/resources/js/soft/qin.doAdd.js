//region 页面一加载就要运行的方法
$(function ()
    {
        //region 首先先将下拉框值初始化出来
        //类型
        iniSoftTypeInfo();
        //打开方式
        iniSoftOpenWaysInfo();
        //endregion

        //region 实现新增
        $('#btn_add').click(function ()
            {
                doAdd();
            }
        );
        //endregion
    }
);
//endregion

//region 增
function doAdd()
{
    var nodes = {
        soft_name: $('#soft_name').val(),
        soft_description: $('#soft_description').val(),
        //soft_isHidden2: $('#soft_isHidden2 option:selected')[0].innerHTML,
        soft_isHidden2: $('#soft_isHidden2').combobox('getValue'),
        soft_createTime2: $('#soft_createTime2').datetimebox('getValue'),
        soft_type2: $('#soft_type2 option:selected')[0].innerHTML,
        soft_location: $('#soft_location').val(),
        soft_size: $('#soft_size').val(),
        soft_openWays2: $('#soft_openWays2 option:selected')[0].innerHTML
    };

    var addURL = basePath + "/soft/addSoft.com?soft_name=" + nodes.soft_name +
        "       &&soft_description=" + nodes.soft_description +
        "       &&soft_isHidden2=" + nodes.soft_isHidden2 +
        "       &&soft_createTime2=" + nodes.soft_createTime2 +
        "       &&soft_type2=" + nodes.soft_type2 +
        "       &&soft_location=" + nodes.soft_location +
        "       &&soft_size=" + nodes.soft_size +
        "       &&soft_openWays2=" + nodes.soft_openWays2;

    $.ajax
    (
        {
            url: addURL,
            method: 'POST',
            success: function (msg)
            {
                //alert(msg);
                if (msg == "success")
                {
                    window.location = basePath + "/soft/doMainView.com";
                }
                else
                {
                    alert(msg);
                }
            }
        }
    )
}
//endregion