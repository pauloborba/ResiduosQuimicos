
<%@ page import="residuosquimicos.Laboratorio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'laboratorio.label', default: 'Laboratorio')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-laboratorio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-laboratorio" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nomeCentro" title="${message(code: 'laboratorio.nomeCentro.label', default: 'Nome Centro')}" />
					
						<g:sortableColumn property="nomeDepartamento" title="${message(code: 'laboratorio.nomeDepartamento.label', default: 'Nome Departamento')}" />
					
						<g:sortableColumn property="nomeLaboratorio" title="${message(code: 'laboratorio.nomeLaboratorio.label', default: 'Nome Laboratorio')}" />
					
						<g:sortableColumn property="responsavel" title="${message(code: 'laboratorio.responsavel.label', default: 'Responsavel')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${laboratorioInstanceList}" status="i" var="laboratorioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${laboratorioInstance.id}">${fieldValue(bean: laboratorioInstance, field: "nomeCentro")}</g:link></td>
					
						<td>${fieldValue(bean: laboratorioInstance, field: "nomeDepartamento")}</td>
					
						<td>${fieldValue(bean: laboratorioInstance, field: "nomeLaboratorio")}</td>
					
						<td>${fieldValue(bean: laboratorioInstance, field: "responsavel")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${laboratorioInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
