<%@ page import="residuosquimicos.Laboratorio" %>



<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'nomeCentro', 'error')} required">
	<label for="nomeCentro">
		<g:message code="laboratorio.nomeCentro.label" default="Nome Centro" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="nomeCentro" from="${src.groovy.CentroList?.values()}" keys="${src.groovy.CentroList.values()*.name()}" required="" value="${laboratorioInstance?.nomeCentro?.name()}"  optionKey="key" />

</div>

<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'nomeDepartamento', 'error')} required">
	<label for="nomeDepartamento">
		<g:message code="laboratorio.nomeDepartamento.label" default="Nome Departamento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="nomeDepartamento" from="${src.groovy.DepartamentoList?.values()}" keys="${src.groovy.DepartamentoList.values()*.name()}" required="" value="${laboratorioInstance?.nomeDepartamento?.name()}" optionKey="key" />

</div>

<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'nomeLaboratorio', 'error')} required">
	<label for="nomeLaboratorio">
		<g:message code="laboratorio.nomeLaboratorio.label" default="Nome Laboratorio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="nomeLaboratorio" from="${src.groovy.LaboratorioList?.values()}" keys="${src.groovy.LaboratorioList.values()*.name()}" required="" value="${laboratorioInstance?.nomeLaboratorio?.name()}" optionKey="key" />

</div>

<div class="fieldcontain ${hasErrors(bean: laboratorioInstance, field: 'responsavel', 'error')} required">
	<label for="responsavel">
		<g:message code="laboratorio.responsavel.label" default="Responsavel" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="responsavel" required="" value="${laboratorioInstance?.responsavel}"/>

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

