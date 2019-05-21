<?php 

//Arquivo de conexao com banco de dados



	$user = "root";
	$pswd = "";
	$host = "localhost";
	$database = "dbaula";


	$bd = new mysqli($host,$user,$pswd,$database);

	if(!$bd->connect_errno)
		echo "Conectado!";
	else 
		echo "Erro ao conectar";




?>