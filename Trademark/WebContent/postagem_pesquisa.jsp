<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="header.jsp"></s:include>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Trademark</title>
</head>

<body style="margin: 35px 15px;">

<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">
                <small>Postagens</small>
            </h1>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <s:form action="search_postagens" method="teste">
                <label>Marca:</label>
                <select name="marcaSelecionada">
                    <option value="-1">Selecione...</option>
                    <s:iterator value="listaMarcas">
                        <option value="<s:property value="id" />"><s:property value="nome"/></option>
                    </s:iterator>
                </select><br/>
                <label>Tipo:</label>
                <select name="tipoSelecionado">
                    <option value="-1">Selecione...</option>
                    <s:iterator value="listaTipoVestuario">
                        <option value="<s:property value="id" />"><s:property value="tipo"/></option>
                    </s:iterator>
                </select><br/>
                <label>Loja:</label>
                <select name="lojaSelecionada">
                    <option value="-1">Selecione...</option>
                    <s:iterator value="listaLojas">
                        <option value="<s:property value="id" />"><s:property value="nome"/></option>
                    </s:iterator>
                </select><br/>
                <input type="submit" value="Pesquisar"/>
            </s:form>
        </div>
    </div>

    <s:iterator value="postagens">
        <div class="row">
            <div class="col-md-7">
                <a href="#" class="thumbnail">
                    <img class="img-responsive img-rounded" src="<s:url action="ImageAction">
            <s:param name="imagePath">
            <s:property value="imgPath"/>
            </s:param></s:url>"/>
                </a>
            </div>
            <div class="col-md-5">
                <h3><s:property value="tipoVestuario"/> - <s:property value="marca"/></h3>
                <h4>Pode ser encontrado em <s:property value="loja"/></h4>
                <p>Postado em <s:property value="dataFormatada"/> por <s:property value="postadoPor"/></p>
                <p><s:property value="descricao"/></p>
            </div>
        </div>
    </s:iterator>
</div>
</body>
</html>