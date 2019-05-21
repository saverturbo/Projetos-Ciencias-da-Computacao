<?php

require_once 'ConexaoBancoDados.php';
require_once 'Funcoes.php';

$db = new ConexaoBancoDados();
$connection = $db->getConnection();

$statement = $connection->prepare('select * from curriculos where id = ?');
$statement->bind_param('i', $_GET['id']);
$statement->execute();

$result = $statement->get_result();

$dados = $result->fetch_assoc();

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
		<input type="hidden" name="curriculo_pessoa_id" value="<?php echo $dados['id'] ?>">
		
		<p>
			<fieldset>
				<legend class="text-secondary">Dados pessoais</legend>
				<p>
					<div class="field">
						<label>Nome</label>
						<input type="text" name="curriculo_pessoa_nome" placeholder="Ex: João Silva" value="<?php echo $dados['nome'] ?>" required>
					</div>
					<div class="field">
						<label>Idade</label>
						<input type="number" name="curriculo_pessoa_idade" placeholder="Ex: 20" min="18" max="99" step="1" value="18" value="<?php echo $dados['idade'] ?>" required>
					</div>
					<div class="field">
						<label>E-mail</label>
						<input type="text" name="curriculo_pessoa_email" placeholder="Ex: joaosilva@outlook.com" value="<?php echo $dados['email'] ?>" required>
					</div>
					<div class="field">
						<label>Endereço</label>
						<input type="text" name="curriculo_pessoa_endereco" placeholder="Ex: Rua Tal, Número tal. Bairro Tal" value="<?php echo $dados['endereco'] ?>" required>
					</div>
					<div class="field">
						<label>Estado</label>
						<select name="curriculo_pessoa_estado">
							<option value="AC" <?php if($dados['estado'] === 'AC') echo "selected='selected'" ?> >Acre</option>
							<option value="AL" <?php if($dados['estado'] === 'AL') echo "selected='selected'" ?> >Alagoas</option>
							<option value="AP" <?php if($dados['estado'] === 'AP') echo "selected='selected'" ?> >Amapá</option>
							<option value="AM" <?php if($dados['estado'] === 'AM') echo "selected='selected'" ?> >Amazonas</option>
							<option value="BA" <?php if($dados['estado'] === 'BA') echo "selected='selected'" ?> >Bahia</option>
							<option value="CE" <?php if($dados['estado'] === 'CE') echo "selected='selected'" ?> >Ceará</option>
							<option value="DF" <?php if($dados['estado'] === 'DF') echo "selected='selected'" ?> >Distrito Federal</option>
							<option value="ES" <?php if($dados['estado'] === 'ES') echo "selected='selected'" ?> >Espírito Santo</option>
							<option value="GO" <?php if($dados['estado'] === 'GO') echo "selected='selected'" ?> >Goiás</option>
							<option value="MA" <?php if($dados['estado'] === 'MA') echo "selected='selected'" ?> >Maranhão</option>
							<option value="MT" <?php if($dados['estado'] === 'MT') echo "selected='selected'" ?> >Mato Grosso</option>
							<option value="MS" <?php if($dados['estado'] === 'MS') echo "selected='selected'" ?> >Mato Grosso do Sul</option>
							<option value="MG" <?php if($dados['estado'] === 'MG') echo "selected='selected'" ?> >Minas Gerais</option>
							<option value="PA" <?php if($dados['estado'] === 'PA') echo "selected='selected'" ?> >Pará</option>
							<option value="PB" <?php if($dados['estado'] === 'PB') echo "selected='selected'" ?> >Paraíba</option>
							<option value="PR" <?php if($dados['estado'] === 'PR') echo "selected='selected'" ?> >Paraná</option>
							<option value="PE" <?php if($dados['estado'] === 'PE') echo "selected='selected'" ?> >Pernambuco</option>
							<option value="PI" <?php if($dados['estado'] === 'PI') echo "selected='selected'" ?> >Piauí</option>
							<option value="RJ" <?php if($dados['estado'] === 'RJ') echo "selected='selected'" ?> >Rio de Janeiro</option>
							<option value="RN" <?php if($dados['estado'] === 'RN') echo "selected='selected'" ?> >Rio Grande do Norte</option>
							<option value="RS" <?php if($dados['estado'] === 'RS') echo "selected='selected'" ?> >Rio Grande do Sul</option>
							<option value="RO" <?php if($dados['estado'] === 'RO') echo "selected='selected'" ?> >Rondônia</option>
							<option value="RR" <?php if($dados['estado'] === 'RR') echo "selected='selected'" ?> >Roraima</option>
							<option value="SC" <?php if($dados['estado'] === 'SC') echo "selected='selected'" ?> >Santa Catarina</option>
							<option value="SP" <?php if($dados['estado'] === 'SP') echo "selected='selected'" ?> >São Paulo</option>
							<option value="SE" <?php if($dados['estado'] === 'SE') echo "selected='selected'" ?> >Sergie</option>
							<option value="TO" <?php if($dados['estado'] === 'TO') echo "selected='selected'" ?> >Tocatins</option>
						</select>
					</div>
					<div class="field">
						<label>Cidade</label>
						<input type="text" name="curriculo_pessoa_cidade" value="<?php echo $dados['cidade'] ?>" required>
					</div>
					<div class="field">
						<label>Escolaridade</label>
						<div class="radios">
							<input type="radio" name="curriculo_pessoa_escolaridade" value="fundamental" <?php if($dados['escolaridade'] === 'fundamental') echo "checked='checked'" ?>> Fundamental
							<input type="radio" name="curriculo_pessoa_escolaridade" value="medio" <?php if($dados['escolaridade'] === 'medio') echo "checked='checked'" ?>> Médio
							<input type="radio" name="curriculo_pessoa_escolaridade" value="superior" <?php if($dados['escolaridade'] === 'superior') echo "checked='checked'" ?>> Superior
						</div>
					</div>
					<div class="field">
						<label>Formação</label>
						<input type="text" name="curriculo_pessoa_formacao" placeholder="Ex: Administração" value="<?php echo $dados['formacao'] ?>" required>
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
					<input type="text" name="curriculo_pessoa_empresa_nome" value="<?php echo $dados['ultima_experiencia_empresa'] ?>">
				</div>
				<div class="field">
					<label>Duração</label>
					<input type="text" name="curriculo_pessoa_empresa_tempo" placeholder="Ex: 3 anos" value="<?php echo $dados['ultima_experiencia_tempo'] ?>">
				</div>
			</fieldset>
		</p>
		<p>
			<fieldset>
				<legend class="text-secondary">Cursos profissionalizantes</legend>
				<p><i>Digite os cursos profissionalizantes completados</i></p>
				<div class="field">
					<label>Cursos</label>
					<input type="text" name="curriculo_pessoa_cursos"value="<?php echo $dados['cursos'] ?>">
				</div>
			</fieldset>
		</p>
		<div class="buttons">
			<button class="button blue" type="submit">Atualizar</button>
			<a href="/sistema_curriculos/excluir_curriculo.php?id=<?php echo $dados['id'] ?>" class='button red'>Excluir</a>
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