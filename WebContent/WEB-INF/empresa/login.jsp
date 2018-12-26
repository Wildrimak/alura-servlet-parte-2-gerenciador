<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="linkLogin" value="/entrada" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>

<body>
	<p>Loge-se</p>

	<form action="${linkLogin}" method="post">
		Login: <input type="text" name="login">
		Senha: <input type="password" name="senha">
		
		<input type="hidden" name="acao" value="Login">
		<input type="submit" name="cadastrar">
	</form>

</body>
</html>