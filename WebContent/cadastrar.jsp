<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="start.css">
</head>
<body>
<h1>Página de Cadastro</h1>

<a href="index.html">Voltar para Login</a>

<form action="<%= response.encodeURL("autenticar") %>" method="post">
	<input type="text" name="nome" placeholder="Digite seu CPF"/></br>
	<input type="password" name="senha" placeholder="Digite sua senha"/></br>
	<input type="hidden" name="operacao" value="cadastro"><br>
	<input type="submit" value="Cadastrar">
	
</form>

</body>
</html>