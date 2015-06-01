<html>
<head>
    <!-- <META HTTP-EQUIV="Refresh" CONTENT="1;URL=open_postagens"> -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="resources/js/sdk_facebook.js"></script>
</head>
<body>


<div id="login_button">
    <fb:login-button id="meuface"
                     scope="public_profile,email"
                     onlogin="checkLoginState();">
    </fb:login-button>
</div>

<div id="status">
</div>

</body>
</html>