<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/jquery-1.11.2.min.js"></script>
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
            <a class="navbar-brand" href="/Trademark">TradeMark</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="<s:url action='open_postagem'/>">Nova postagem</a></li>
                <li><a href="aboutus.html">Sobre</a></li>
                <li><a href="contact.html">Contato</a></li>
                <li></li>
                <li></li>
                <li><a href="#"><h3 id="usuario"></h3></a></li>
                <input type="hidden" name="nome" id="nome" value="">
                <input type="hidden" name="email" id="email" value="">
            </ul>
        </div>
    </div>
</nav>