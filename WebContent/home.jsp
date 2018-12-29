<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="cadastrarEmpresa" value="entrada?acao=CadastrarEmpresa" />
<c:url var="listarEmpresas" value="entrada?acao=ListarEmpresas" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Sistema de gerencia de empresas</title>
</head>

<body>

	<p>Estas são as coisas que você pode fazer:</p>

	<ul>
		<li><a href="${listarEmpresas}"> Listar empresas</a></li>
		<li><a href="${cadastrarEmpresa}"> Cadastrar nova empresa</a></li>
	</ul>

</body>

</html>