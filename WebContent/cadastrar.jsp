<html>
<body>
<h1>Página de Cadastro</h1>

<form action="<%= response.encodeURL("autenticar") %>" method="post">
	<input type="text" name="nome" placeholder="Digite seu CPF"/></br>
	<input type="password" name="senha" placeholder="Digite sua senha"/></br>
	<input type="hidden" name="operacao" value="cadastro"><br>
	<input type="submit" value="Cadastrar">
	
</form>

</body>
</html>