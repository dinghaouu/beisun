<%--
  Created by IntelliJ IDEA.
  User: DingHao
  Date: 2017/7/13
  Time: 上午10:14
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
    <title>影像管理中心</title>
    <link rel="stylesheet" href="${ctx}/static/css/main.css" />
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/main.js"></script>
</head>
<body>
欢迎登录，${userName}。 <a href="logout">注销登录</a>
</body>
</html>
