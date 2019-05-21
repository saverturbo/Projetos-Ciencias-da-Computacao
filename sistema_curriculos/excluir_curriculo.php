<?php 

require_once 'ConexaoBancoDados.php';
require_once 'Funcoes.php';

$db = new ConexaoBancoDados();
$connection = $db->getConnection();

if(!isset($_GET['id'])) {
	header('Location:/sistema_curriculos/listar_curriculos.php');
} else {
	$statement = $connection->prepare('delete from curriculos where id = ?');
	$statement->bind_param('i', $_GET['id']);
	$statement->execute();
	
	criarMensagemFlash('sucesso_exclusao', 'Currículo excluído com sucesso.');
	header('Location:/sistema_curriculos/listar_curriculos.php');
}



 ?>