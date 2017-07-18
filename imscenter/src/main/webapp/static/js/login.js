/**
 * Created by DingHao on 2017/7/12.
 */
String.prototype.trim = function() {
    var str = this,
        whitespace = ' \n\r\t\f\x0b\xa0\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u200b\u2028\u2029\u3000';
    for (var i = 0,
             len = str.length; i < len; i++) {
        if (whitespace.indexOf(str.charAt(i)) === -1) {
            str = str.substring(i);
            break;
        }
    }
    for (i = str.length - 1; i >= 0; i--) {
        if (whitespace.indexOf(str.charAt(i)) === -1) {
            str = str.substring(0, i + 1);
            break;
        }
    }
    return whitespace.indexOf(str.charAt(0)) === -1 ? str: '';
};

function checkInfo(){
    var errorInfo0 = "用户名或密码不能为空";
    var userName=document.getElementById("userName").value;
    var password=document.getElementById("password").value;
    var info=document.getElementById("info");
    if (userName.trim() == "" || password.trim() == ""){
        info.innerHTML = errorInfo0;
        return false;
    }
    return true;
};

function changeCode() {
    var imgNode = document.getElementById("vimg");
    //重新加载验证码，达到刷新的目的
    imgNode.src = "vms/AuthImageServlet?t=" + Math.random();// 防止浏览器缓存的问题     
};

