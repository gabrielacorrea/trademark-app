<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/universal-template.css" rel="stylesheet">
    <script type="text/javascript" src="resources/js/html5shiv.min.js"></script>
    <script type="text/javascript" src="resources/js/respond.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            if ($('#isSaved').val() == "true") {
                alert("Imagem salva com sucesso!");
            }
        });

        $(document).submit(function () {
            var validate = true;
            if (!$('#upload').val()) {
                validate = false;
                alert("Escolha uma imagem!");
            } else if (invalidExtension($('#upload').val())) {
                validate = false;
                alert("Ops!... tipo de arquivo invalido.");
                $('#upload').val("");
            } else if ($('#upload')[0].files[0].size > 2097152) {
                validate = false;
                alert("Excedeu tamanho maximo permitido(2mb).");
                $('#upload').val("");
            }

            return validate;
        });


        function invalidExtension(file) {
            var ext = file.replace(/^.*\./, '');
            var valid = true;
            console.log(ext);
            switch (ext) {
                case "jpeg" :
                    valid = false;
                    break;
                case "jpg" :
                    valid = false;
                    break;
                case "png" :
                    valid = false;
                    break;
                default:
                    valid = true;

            }
            return valid;
        }
    </script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="trademark.html">TradeMark</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="login.html">Home</a></li>
                <li><a href="aboutus.html">Sobre nós</a></li>
                <li><a href="contact.html">Contate-nos</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<div class="container">

    <div class="universal-template postagem">
        <input type="hidden" value="<s:property value='saved'/>" id="isSaved">

        <s:form action="save_postagem" enctype="multipart/form-data">
            <h2 class="form-contact-heading">Postar uma oferta</h2>

            <div>
                <h4 class="form-postagem">Escolha uma imagem:</h4>
                <input type="file" class="form-postagem" name="upload" id="upload"/>
            </div>
            <br/>
            <h4 class="form-postagem">Escolha uma marca:</h4>
            <select name="marcaSelecionada" class="form-postagem">
                <option>Selecione...</option>
                <s:iterator value="listaMarcas">
                    <option><s:property value="nome"/></option>
                </s:iterator>
            </select>
            <br/>
            <br/>
            <input type="submit" name="sendFile" value="Enviar">
        </s:form>
    </div>

</div>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>