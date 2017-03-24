<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!<br/>
	
	<c:if test="${not empty usuarioLogado}">
		Logado como ${usuarioLogado.email} <br/>
	</c:if>
	
	<form action="fazTudo?tarefa=NovaEmpresa" method="post">
		Nome: <input type="text" name="nome" /><br />
		<input type="submit" value="Enviar" />
	</form>
	
	<form action="login" method="post">
		Email: <input type="text" name="email" />
		Senha: <input type="password" name="senha" />
		<input type="submit" value="Login" />
	</form>
	<!-- é possivel passar o parametro já dentro da action, mas não é uma boa prática-->
	<!-- <form action="fazTudo?tarefa=Logout" method="post"> -->
	
	<form action="fazTudo" method="post">
		<input type="hidden" for="fazTudo" value="Logout">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>