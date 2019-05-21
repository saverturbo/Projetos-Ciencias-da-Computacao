<?php

require_once 'Funcoes.php';

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
	<a href="/sistema_curriculos/cadastrar_curriculo.php" class="item active">Cadastrar</a>
	<a href="/sistema_curriculos/listar_curriculos.php" class="item">Ver lista</a>

	<div class="right">
		<a href="/sistema_curriculos/sobre.php" class="item">Sobre</a>
	</div>
</div>

<!-- Conteúdo da página. -->
<div class="container">

	<h2>Cadastro de currículo</h2>
	<p>Preencha todos os campos abaixo.</p>

	<?php

	if(temMensagemFlash('erro_cadastro')) {
		$mensagem = mensagemFlash('erro_cadastro');
		echo "
		<div class='error'>

			<p>$mensagem</p>
		</div>
		";
		limparMensagemFlash('erro_cadastro');
	} else if(temMensagemFlash('sucesso_cadastro')) {
		$mensagem = mensagemFlash('sucesso_cadastro');
		echo "
		<div class='success'>

			<p>$mensagem</p>
		</div>
		";
		limparMensagemFlash('sucesso_cadastro');	
	}

	 ?>

	<form method="POST" action="/sistema_curriculos/salvar_curriculo.php">
		
		<p>
			<fieldset>
				<legend class="text-secondary">Dados pessoais</legend>
				<p>
					<div class="field">
						<label>Nome</label>
						<input type="text" name="curriculo_pessoa_nome" placeholder="Ex: João Silva" required>
					</div>
					<div class="field">
						<label>Idade</label>
						<input type="number" name="curriculo_pessoa_idade" placeholder="Ex: 20" min="18" max="99" step="1" value="18" required>
					</div>
					<div class="field">
						<label>E-mail</label>
						<input type="text" name="curriculo_pessoa_email" placeholder="Ex: joaosilva@outlook.com" required>
					</div>
					<div class="field">
						<label>Endereço</label>
						<input type="text" name="curriculo_pessoa_endereco" placeholder="Ex: Rua Tal, Número tal. Bairro Tal" required>
					</div>
					<div class="field">
						<label>Estado</label>
						<select name="curriculo_pessoa_estado">
							<option value="AC">Acre</option>
							<option value="AL">Alagoas</option>
							<option value="Amapá">AP</option>
							<option value="AM">Amazonas</option>
							<option value="BA">Bahia</option>
							<option value="CE">Ceará</option>
							<option value="DF">Distrito Federal</option>
							<option value="ES">Espírito Santo</option>
							<option value="GO">Goiás</option>
							<option value="MA">Maranhão</option>
							<option value="MT">Mato Grosso</option>
							<option value="MS">Mato Grosso do Sul</option>
							<option value="MG">Minas Gerais</option>
							<option value="PA">Pará</option>
							<option value="PB">Paraíba</option>
							<option value="PR">Paraná</option>
							<option value="PE">Pernambuco</option>
							<option value="PI">Piauí</option>
							<option value="RJ">Rio de Janeiro</option>
							<option value="RN">Rio Grande do Norte</option>
							<option value="RS">Rio Grande do Sul</option>
							<option value="RO">Rondônia</option>
							<option value="RR">Roraima</option>
							<option value="SC">Santa Catarina</option>
							<option value="SP">São Paulo</option>
							<option value="SE">Sergie</option>
							<option value="TO">Tocatins</option>
						</select>
					</div>
					<div class="field">
						<label>Cidade</label>
						<input type="text" name="curriculo_pessoa_cidade" required>
					</div>
					<div class="field">
						<label>Escolaridade</label>
						<div class="radios">
							<input type="radio" name="curriculo_pessoa_escolaridade" value="fundamental" checked="checked"> Fundamental
							<input type="radio" name="curriculo_pessoa_escolaridade" value="medio"> Médio
							<input type="radio" name="curriculo_pessoa_escolaridade" value="superior"> Superior
						</div>
					</div>
					<div class="field">
						<label>Formação</label>
						<input type="text" name="curriculo_pessoa_formacao" placeholder="Ex: Administração" required>
					</div>
				</p>
			</fieldset>
		</p>
		<p>
			<fieldset>
				<legend class="text-secondary">Experiências profissionais</legend>
				<p><i>Com base na última experiência profissional</i></p>
				<div class="field">
					<label>Nome empresa</label>
					<input type="text" name="curriculo_pessoa_empresa_nome">
				</div>
				<div class="field">
					<label>Duração</label>
					<input type="text" name="curriculo_pessoa_empresa_tempo" placeholder="Ex: 3 anos">
				</div>
			</fieldset>
		</p>
		<p>
			<fieldset>
				<legend class="text-secondary">Cursos profissionalizantes</legend>
				<p><i>Digite os cursos profissionalizantes completados</i></p>
				<div class="field">
					<label>Cursos</label>
					<input type="text" name="curriculo_pessoa_cursos">
				</div>
			</fieldset>
		</p>
		<div class="buttons">
			<button class="button green" type="submit">Cadastrar</button>
		</div>

	</form>

</div>
	
</body>
</html>

<?php 

if($_SERVER['REQUEST_METHOD'] === 'POST') {
	if(isset($_POST) && count($_POST) > 5) {

	$nome = $_POST['curriculo_pessoa_nome'];

	echo $nome;

	} else {
		criarMensagemFlash('erro_cadastro', 'Preencha todos os campos!');
	}
}

?>