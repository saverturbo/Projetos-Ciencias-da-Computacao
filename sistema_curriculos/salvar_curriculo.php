<?php 

require_once 'ConexaoBancoDados.php';
require_once 'Funcoes.php';

$db = new ConexaoBancoDados();
$connection = $db->getConnection();

if(!isset($_POST['curriculo_pessoa_id'])) {
	$statement = $connection->prepare('insert into curriculos values (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)');
	$statement->bind_param('sssssssssss',
	$_POST['curriculo_pessoa_nome'],
	$_POST['curriculo_pessoa_idade'],
	$_POST['curriculo_pessoa_email'],
	$_POST['curriculo_pessoa_endereco'],
	$_POST['curriculo_pessoa_estado'],
	$_POST['curriculo_pessoa_cidade'],
	$_POST['curriculo_pessoa_escolaridade'],
	$_POST['curriculo_pessoa_formacao'],
	$_POST['curriculo_pessoa_empresa_nome'],
	$_POST['curriculo_pessoa_empresa_tempo'],
	$_POST['curriculo_pessoa_cursos']);
	$statement->execute();
	
	criarMensagemFlash('sucesso_cadastro', 'Currículo cadastrado com sucesso.');
	header('Location:/sistema_curriculos/cadastrar_curriculo.php');
} else {
	$statement = $connection->prepare('update curriculos set nome = ?, idade = ?, email = ?, endereco = ?, estado = ?, cidade = ?, escolaridade = ?, formacao = ?,  ultima_experiencia_empresa = ?, ultima_experiencia_tempo = ?, cursos = ? where id = ?');
	$statement->bind_param('sssssssssssi',
	$_POST['curriculo_pessoa_nome'],
	$_POST['curriculo_pessoa_idade'],
	$_POST['curriculo_pessoa_email'],
	$_POST['curriculo_pessoa_endereco'],
	$_POST['curriculo_pessoa_estado'],
	$_POST['curriculo_pessoa_cidade'],
	$_POST['curriculo_pessoa_escolaridade'],
	$_POST['curriculo_pessoa_formacao'],
	$_POST['curriculo_pessoa_empresa_nome'],
	$_POST['curriculo_pessoa_empresa_tempo'],
	$_POST['curriculo_pessoa_cursos'],
	$_POST['curriculo_pessoa_id']);

	$statement->execute();
	
	criarMensagemFlash('sucesso_atualizacao', 'Currículo atualizado com sucesso.');
	header('Location:/sistema_curriculos/listar_curriculos.php');
}



 ?>