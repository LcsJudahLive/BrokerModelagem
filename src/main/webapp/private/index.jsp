<!DOCTYPE html>

<html>
	<head>
		<link href="/public/third-party/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="/public/styles.css" rel="stylesheet" type="text/css">
		<meta charset="utf-8"/>
		<title>Broker</title>
		<script src="/public/third-party/jquery-2.2.3.min.js"></script>
		<script src="/public/third-party/bootstrap.min.js"></script>
		<script>
		    jQuery(document).ready(function ($) {
		        $('#tabs').tab();
		    });
		</script>
	</head>

	<body>
		<div class="container">
			<div id="content">
			    <ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
			        <li class="active"><a href="#acao" data-toggle="tab">Ação</a></li>
			        <li><a href="#carteira" data-toggle="tab">Carteira</a></li>
			        <li><a href="#conta_corrente" data-toggle="tab">Conta Corrente</a></li>
			        <li><a href="#ordem" data-toggle="tab">Ordem</a></li>
			        <li><a href="#relatorio" data-toggle="tab">Relatório</a></li>
			        <li><a href="/logout"><b>Sair</b></a></li>
			    </ul>
			    <div id="my-tab-content" class="tab-content">
			        <div class="tab-pane active" id="acao">
			            <h1>Ação</h1>
						 <table class="table table-hover">
						    <thead>
						      <tr>
						        <th>Exemplo</th>
						        <th>Exemplo</th>
						        <th>Exemplo</th>
						      </tr>
						    </thead>
						    <tbody>
						      <tr>
						        <td>Exemplo</td>
						        <td>Exemplo</td>
						        <td>Exemplo</td>
						      </tr>
						      <tr>
						        <td>Exemplo</td>
						        <td>Exemplo</td>
						        <td>Exemplo</td>
						      </tr>
						    </tbody>
						  </table>
			        </div>
			        <div class="tab-pane" id="carteira">
			            <h1>Carteira</h1>
			        </div>
			        <div class="tab-pane" id="conta_corrente">
			            <h1>Conta corrente</h1>
			        </div>
			        <div class="tab-pane" id="ordem">
			            <h1>Ordem</h1>
			        </div>
			        <div class="tab-pane" id="relatorio">
			            <h1>Relatório</h1>
			        </div>
			    </div>
			</div>
		</div>
	</body>
</html>
