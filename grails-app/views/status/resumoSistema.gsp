<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="default.title.page.resumoSistema" /></title>
</head>
<body>
<div id="resumo-content" class="content scaffold-list" role="main">
    <label for="status-message">Status do Sistema:</label>
    <g:if test="${necessarioColeta == true}">
        <textField id ="status-message"><g:message code="message.title.statusGeral.positive" /></textField>
    </g:if>
    <g:else>
        <textField id ="status-message"><g:message code="message.title.statusGeral.negative" /></textField>
    </g:else>

    <g:if test="${laboratorios != []}">
        <table id="table-residuos">
            <thead>
            <tr>
                <th>Departamento</th>
                <th>Resíduo</th>
                <th>Peso (Kg)</th>
            </tr>
            </thead>

            <tbody>
            <g:each in="${laboratorios}" var ="lab">
               <tr>
                   <th rowspan="${lab.residuos.size()}">${lab.nomeLaboratorio}</th>
                   <g:each in="${lab.residuos}" var ="residuo" status="i">
                       <g:if test="${i!=0}">
                           <tr>
                               <td>${residuo.nome}</td>
                               <td>${residuo.peso}</td>
                           </tr>
                       </g:if>
                       <g:else>
                           <td><a>${residuo.nome}</a></td>
                           <td><a>${residuo.peso}</a></td>
                       </g:else>

                   </g:each>
               </tr>
            </g:each>
            </tbody>
        </table>
    </g:if>
    <g:else>
        <label id="errorMessage"><g:message code="message.title.resumoSistema.naoPossuiLab" /></label>
    </g:else>


    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
</div>
</body>
</html>