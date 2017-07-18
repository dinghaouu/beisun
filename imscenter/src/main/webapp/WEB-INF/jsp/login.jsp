<%--
  Created by IntelliJ IDEA.
  User: DingHao
  Date: 2017/7/12
  Time: 上午8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>
    <link rel="stylesheet" href="${ctx}/static/css/login.css" />
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/login.js"></script>
</head>
<body>
<div class="logo">管理员登陆</div>
<div class="login_form">
    <form id="Login" name="Login" method="post" onsubmit="return checkInfo();" action="login">
        <li class="login-item">
            <span>用户名：</span>
            <input type="text" id="userName" name="userName" class="login_input" >
            <span id="count-msg" class="error"></span>
        </li>
        <li class="login-item">
            <span>密　码：</span>
            <input type="password" id="password" name="password" class="login_input" >
            <span id="password-msg" class="error"></span>
        </li>
        <li class="login-sub">
            <input type="submit" name="Submit" value="登录" />
            <input type="reset" name="Reset" value="重置" />
        </li>
    </form>
    <div style="color:red; font-size: 15px;" class="verify" id="info">${message}</div>
</div>
</body>
</html>
