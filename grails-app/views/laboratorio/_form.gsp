<%@ page import="residuosquimicos.Laboratorio" %>



<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'nomeCentro', 'error')} required">
	<label for="nomeCentro">
		<g:message code="laboratorio.nomeCentro.label" default="Nome Centro" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="nomeCentro" from="${residuosquimicos.NomesDeCentros?.values()}" keys="${residuosquimicos.NomesDeCentros.values()*.name()}" required="" value="${laboratorioInstance?.nomeCentro?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'nomeDepartamento', 'error')} required">
	<label for="nomeDepartamento">
		<g:message code="laboratorio.nomeDepartamento.label" default="Nome Departamento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="nomeDepartamento" from="${residuosquimicos.NomesDeDepartamentos?.values()}" keys="${residuosquimicos.NomesDeDepartamentos.values()*.name()}" required="" value="${laboratorioInstance?.nomeDepartamento?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'nomeLaboratorio', 'error')} required">
	<label for="nomeLaboratorio">
		<g:message code="laboratorio.nomeLaboratorio.label" default="Nome Laboratorio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="nomeLaboratorio" from="${residuosquimicos.NomesDeLaboratorios?.values()}" keys="${residuosquimicos.NomesDeLaboratorios.values()*.name()}" required="" value="${laboratorioInstance?.nomeLaboratorio?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'solicitante', 'error')} ">
	<label for="solicitante">
		<g:message code="laboratorio.solicitante.label" default="Solicitante" />
		
	</label>
	<g:select id="solicitante" name="solicitante.id" from="${residuosquimicos.Usuario.list()}" optionKey="id" value="${laboratorioInstance?.solicitante?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'responsavel', 'error')} ">
	<label for="responsavel">
		<g:message code="laboratorio.responsavel.label" default="Responsavel" />
		
	</label>
	<g:select id="responsavel" name="responsavel.id" from="${residuosquimicos.Usuario.list()}" optionKey="id" value="${laboratorioInstance?.responsavel?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'residuos', 'error')} ">
	<label for="residuos">
		<g:message code="laboratorio.residuos.label" default="Residuos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${laboratorioInstance?.residuos?}" var="r">
    <li><g:link controller="residuo" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="residuo" action="create" params="['laboratorio.id': laboratorioInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'residuo.label', default: 'Residuo')])}</g:link>
</li>
</ul>


</div>

