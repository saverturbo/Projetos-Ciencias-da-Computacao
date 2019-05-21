<?php 

session_start();

function criarMensagemFlash($id, $mensagem) {
	$_SESSION[$id] = $mensagem;
}

function temMensagemFlash($id) {
	return isset($_SESSION[$id]);
}

function limparMensagemFlash($id) {
	unset($_SESSION[$id]);
}

function mensagemFlash($id) {
	return $_SESSION[$id];
}