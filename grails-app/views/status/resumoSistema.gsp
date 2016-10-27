<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'residuo.label', default: 'Residuo')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="resumo-content" class="content scaffold-list" role="main">
    <label for="status-message">Status do Sistema:</label>
    <textField id ="status-message">${statusGeral}</textField>
    <!-- Falta a Lista dos Residuos aqui-->

    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
</div>
</body>
</html>