<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.model.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url var="cadastrarEmpresa" value="/gerenciador/entrada?acao=CadastrarEmpresa" />
<c:url var="mostrarEmpresa" value="/gerenciador/entrada?acao=MostrarEmpresa&id=${empresa.id}"></c:url>
<c:url var="removerEmpresa" value="/gerenciador/entrada?acao=RemoverEmpresa&id=${empresa.id}"></c:url>
<c:url var="deslogar" value="/gerenciador/entrada?acao=Logout"></c:url>

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
		<p>Empresa ${empresa.nome} cadastrada com sucesso!</p>
	</c:if>

	<ol>
		<c:forEach var="empresa" items="${empresas}">
			<li>
				${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> 
				<a href="${mostrarEmpresa }">editar</a>
				<a href="${removerEmpresa}">remover</a>
			</li>
		</c:forEach>
	</ol>

	<a href="${cadastrarEmpresa}">Cadastrar uma nova empresa</a>

</body>
</html>