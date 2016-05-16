<!DOCTYPE html>

<html>
	<head>
		<link href="/public/third-party/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="/public/styles.css" rel="stylesheet" type="text/css">
		<meta charset="utf-8"/>
		<title>Autenticação</title>
	</head>

	<body>
		<div class="container">
		    <div class="row">
		        <div class="col-sm-6 col-md-4 col-md-offset-4">
		            <div class="account-wall">
		                <form action="/rest/cliente/cadastrar" class="form-signin" method="post">
			                <input name="cpf" type="text" class="form-control" pattern="[0-9]{11}" placeholder="CPF" required autofocus>
			                <input name="password" type="password" class="form-control" placeholder="Senha" required>
			                <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar</button>
		                </form>
		            </div>
		        </div>
		    </div>
		</div>
	</body>
</html>