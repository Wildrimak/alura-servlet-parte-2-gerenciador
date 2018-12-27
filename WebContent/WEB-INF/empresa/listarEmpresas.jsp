<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.model.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url var="linkCadastrarEmpresa" value="/empresa/cadastrarEmpresa.jsp" />
<c:url var="linkAlterarEmpresa" value="alterarEmpresa"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresas cadastradas</title>
</head>

<body>
	<p>Usuario logado: ${usuarioLogado.login}</p>
	<p><a href="entrada?acao=Logout"> Sair</a></p>
	
	<h1>Lista de empresas:</h1>
	
	<c:if test="${not empty empresa}">
		<p>Empresa ${empresa} cadastrada com sucesso!</p>
	</c:if>

	<ol>
		<c:forEach var="empresa" items="${empresas}">
			<li>
				${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> 
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }">edita</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }">remove</a>
			</li>
		</c:forEach>
	</ol>

	<a href="${linkCadastrarEmpresa}">Cadastrar uma nova empresa</a>

</body>
</html>