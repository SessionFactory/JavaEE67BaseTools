//region 加载软件打开方式信息
function iniSoftOpenWaysInfo()
{
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
}
//endregion

//region 加载软件类型下拉框信息
function iniSoftTypeInfo()
{
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
}
//endregion