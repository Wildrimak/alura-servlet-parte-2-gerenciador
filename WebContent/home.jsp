<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="linkListarEmpresas" value="/listarEmpresas" />
<c:url var="linkCadastrarEmpresa" value="/cadastrarEmpresa" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Sistema de gerencia de empresas</title>
</head>

<body>

	<p>Bem Vindo Wildrimak!!</p>
	<p>Aqui é a raiz de todas as coisas</p>
	<p>Estas são as coisas que você pode fazer:</p>

	<ul>
		<li><a href="${linkListarEmpresas}"> Listar empresas</a></li>
		<li><a href="${linkCadastrarEmpresa}"> Cadastrar nova empresa</a></li>
	</ul>

</body>

</html>