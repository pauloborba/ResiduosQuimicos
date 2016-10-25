
<%@ page import="residuosquimicos.Laboratorio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'laboratorio.label', default: 'Laboratorio')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-laboratorio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-laboratorio" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list laboratorio">
			
				<g:if test="${laboratorioInstance?.nomeCentro}">
				<li class="fieldcontain">
					<span id="nomeCentro-label" class="property-label"><g:message code="laboratorio.nomeCentro.label" default="Nome Centro" /></span>
					
						<span class="property-value" aria-labelledby="nomeCentro-label"><g:fieldValue bean="${laboratorioInstance}" field="nomeCentro"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${laboratorioInstance?.nomeDepartamento}">
				<li class="fieldcontain">
					<span id="nomeDepartamento-label" class="property-label"><g:message code="laboratorio.nomeDepartamento.label" default="Nome Departamento" /></span>
					
						<span class="property-value" aria-labelledby="nomeDepartamento-label"><g:fieldValue bean="${laboratorioInstance}" field="nomeDepartamento"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${laboratorioInstance?.nomeLaboratorio}">
				<li class="fieldcontain">
					<span id="nomeLaboratorio-label" class="property-label"><g:message code="laboratorio.nomeLaboratorio.label" default="Nome Laboratorio" /></span>
					
						<span class="property-value" aria-labelledby="nomeLaboratorio-label"><g:fieldValue bean="${laboratorioInstance}" field="nomeLaboratorio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${laboratorioInstance?.responsavel}">
				<li class="fieldcontain">
					<span id="responsavel-label" class="property-label"><g:message code="laboratorio.responsavel.label" default="Responsavel" /></span>
					
						<span class="property-value" aria-labelledby="responsavel-label"><g:fieldValue bean="${laboratorioInstance}" field="responsavel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${laboratorioInstance?.residuos}">
				<li class="fieldcontain">
					<span id="residuos-label" class="property-label"><g:message code="laboratorio.residuos.label" default="Residuos" /></span>
					
						<g:each in="${laboratorioInstance.residuos}" var="r">
						<span class="property-value" aria-labelledby="residuos-label"><g:link controller="residuo" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:laboratorioInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${laboratorioInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
