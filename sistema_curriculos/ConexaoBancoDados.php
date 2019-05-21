<?php

class ConexaoBancoDados {

	private $host = 'localhost';
	private $banco = 'sistema_curriculos';
	private $usuario = 'root';
	private $senha = '';

	private $connection = null;

	/* Cria a conexão com o banco de dados. */
	public function __construct() {
		$this->connection = new mysqli($this->host, $this->usuario, $this->senha, $this->banco);
		$this->connection->set_charset('utf8');

		$this->initialize();
	}

	/* Verifica se foi conectado com sucesso ao banco de dados. */
	public function isConnected() {
		if($this->connection->connect_error) {
			return false;
		}

		return true;
	}

	/* Retorna o objeto de conexão da classe 'mysqli'. */
	public function getConnection() {
		return $this->connection;
	}

	/* Cria as tabelas caso não existirem. */
	public function initialize() {
		$this->getConnection()->query('create table if not exists curriculos (id integer primary key auto_increment, nome varchar(150), idade char(2), email varchar(150), endereco varchar(150), estado varchar(50), cidade varchar(50), escolaridade varchar(50), formacao varchar(50), ultima_experiencia_empresa varchar(100), ultima_experiencia_tempo varchar(50), cursos varchar(200));');
	}
}

 ?>