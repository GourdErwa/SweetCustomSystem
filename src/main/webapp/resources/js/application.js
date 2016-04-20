//dom加载中设置了disabled属性后显示的图标
var load_icon = "<i class='icon-spinner icon-spin'></i>";


/**
 * 注册click的回车按钮事件
 * @param inputId 注册的按钮id
 * @param actionId 触发的click事件
 */
function register_Click(buttonId, actionId) {

    $("#" + buttonId).bind("keypress", function (e) {
        var code = (e.keyCode ? e.keyCode : e.which);
        if (code == 13) {
            $("#" + actionId).click();
        }
    });

}


//校验邮箱格式
function isEmail(emailName) {
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (filter.test(emailName)) return false;
    return true;
}

//校验密码：只能输入6-20个字母、数字、下划线
function isPasswd(password) {
    var patrn = /^(\w){6,20}$/;
    if (patrn.test(password)) return false;
    return true;
}

/**
 * dom不可用，显示加载中
 * @param id 多个或者单个 dom-ID
 * @param isDisabled    是否显示
 * @param msg           附加的信息
 */
function obj2Disabled(id, isDisabled, msg) {
    var obj = $(id);
    if (isDisabled) {
        obj.html(msg + load_icon);
        obj.addClass("disabled");
    } else {
        obj.html(msg);
        obj.removeClass("disabled");
    }
}
//cookie 保存设置
var option_cookie = {expires: 15, path: '/'};

//对cookie 进行保存-获取-删除 封装
var COOKIE_UTIL = new function () {
    this.savaCookie = function (the_cookie, the_value, option) {
        $.cookie(the_cookie, the_value, option_cookie);
    };
    this.getCookie = function (the_cookie) {
        return $.cookie(the_cookie);
    };
    this.delCookie = function (the_cookie) {
        $.cookie(the_cookie, null, option_cookie);
    };
};

/**
 * 注销事件
 * @param url
 */
function login_Out(url) {
    COOKIE_UTIL.delCookie("_xybb_auth_record");
    window.location.href = url;
}