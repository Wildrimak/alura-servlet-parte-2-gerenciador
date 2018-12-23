<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url var="linkListarEmpresas" value="/listarEmpresas" />
<c:url var="linkAlterarEmpresa" value="/alterarEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar nova empresa</title>
</head>

<body>

	<form action="${linkAlterarEmpresa}" method="post">

		Nome: <input type="text" name="nome" value="${nome}">
		Data: <input type="text" name="data" value="<fmt:formatDate value="${dataAbertura}" pattern="dd/MM/yyyy"/>">
		<input type="hidden" name="id" value="${id}">
		<input type="submit" value="Alterar">

	</form>

</body>
</html>