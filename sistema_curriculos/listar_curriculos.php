<?php 

require_once 'ConexaoBancoDados.php';
require_once 'Funcoes.php';

$db = new ConexaoBancoDados();
$connection = $db->getConnection();

$result = $connection->query('select id, nome, email from curriculos order by id desc');

 ?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">

	<title>Sistema de currículos</title>

	<link rel="stylesheet" href="css/estilo.css">
</head>
<body>

<!-- Barra de navegação. -->
<div class="navbar">
	<a href="/sistema_curriculos" class="header">Cadastramento de Currículos</a>
	<a href="/sistema_curriculos" class="item">Início</a>
	<a href="/sistema_curriculos/cadastrar_curriculo.php" class="item">Cadastrar</a>
	<a href="/sistema_curriculos/listar_curriculos.php" class="item active">Ver lista</a>

	<div class="right">
		<a href="/sistema_curriculos/sobre.php" class="item">Sobre</a>
	</div>
</div>

<!-- Conteúdo da página. -->
<div class="container">

	<h2>Lista de currículos</h2>

	<?php 

	if(temMensagemFlash('sucesso_atualizacao')) {
		$mensagem = mensagemFlash('sucesso_atualizacao');
		echo "
		<div class='success'>
			<p>$mensagem</p>
		</div>
		";
		limparMensagemFlash('sucesso_atualizacao');	
	} else if(temMensagemFlash('sucesso_exclusao')) {
		$mensagem = mensagemFlash('sucesso_exclusao');
		echo "
		<div class='success'>
			<p>$mensagem</p>
		</div>
		";
		limparMensagemFlash('sucesso_exclusao');	
	}

	 ?>

	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Ação</th>
		</tr>
		<?php 

		while ($row = $result->fetch_assoc()) {
			echo "
			<tr>
				<td>{$row['id']}</td>
				<td>{$row['nome']}</td>
				<td>{$row['email']}</td>
				<td>
					<a href='/sistema_curriculos/editar_curriculo.php?id={$row['id']}' class='button blue'>Editar</a>
					<a href='/sistema_curriculos/excluir_curriculo.php?id={$row['id']}' class='button red'>Excluir</a>
				</td>
			</tr>
			";


		}


		 ?>
	</table>


</div>
	
</body>
</html>