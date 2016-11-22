<html>
<head>
    <meta name="layout" content="main">
    <title>Registrar um novo laboratório</title>
</head>

<body>
    <div id="createnewLab-content" class="content scaffold-list" role="main">
        <g:form url="[action:'saveNameFile']" >
            <fieldset class="form">
                <label for="nomeLaboratorio">
                    <g:message code="lab.nome" default="Nome do novo Laboratório: " />
                </label>
                <g:textField name="nome" required=""/>
            </fieldset>
            <fieldset class="buttons">
                <g:submitButton name="create" value="${message(code: 'x', default: 'Salvar')}" />
            </fieldset>
        </g:form>
    </div>
</body>
</html>