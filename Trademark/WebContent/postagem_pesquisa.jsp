<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="header.jsp"></s:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Trademark</title>
</head>
<body style="margin: 75px 15px;">
<h1>Postagens</h1>

<div class="container">
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
    <s:iterator value="postagens">
        <div class="jumbotron" style="width: 40%;">
            <b>Postado em:</b>
            <s:property value="dataFormatada"/>
            <b>- Por:</b>
            <s:property value="postadoPor"/>
            <br/> <b>Marca: </b>
            <s:property value="marca"/>
            /
            <s:property value="tipoVestuario"/>
            - <b>Loja:</b>
            <s:property value="loja"/>
            <br/> <b>Descricao:</b>

            <p style="font-size: 12px;">
                <s:property value="descricao"/>
            </p>
            <img
                    src="<s:url action="ImageAction">
									<s:param name="imagePath"><s:property value="imgPath"/></s:param></s:url>"
                    style="width: 100px; height: 100px"/>
        </div>
    </s:iterator>
</div>
</body>
</html>