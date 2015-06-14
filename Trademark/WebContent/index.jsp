<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>TradeMark - Login</title>
    <script src="resources/js/sdk_facebook.js"></script>
</head>

<body style="margin: 35px 15px;">
<s:include value="header.jsp"></s:include>
<div class="container">

    <div class="universal-template">
        <h1>Bem-vindo ao Trademark</h1>

        <div id="login_button">
            <fb:login-button id="meuface"
                             scope="public_profile,email"
                             onlogin="checkLoginState();">
            </fb:login-button>
        </div>

        <div id="status">
        </div>
    </div>

</div>
</body>
</html>