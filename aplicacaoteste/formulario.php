<?php require_once("conexao.php") ?>
<!DOCTYPE html>
<html>
<head>
	<title>Cadastro de Usuario</title>
	
</head>
<body>
	<h2>Cadastro de Usuário</h2>
	<form method="POST">
		<table>
			<tr>
				<td><label> Nome: </label></td>
				<td><input type="txt" name="nome" required="true"></td>
			<tr>
				<td><label> E-mail: </label></td>
				<td><input type="txt" name="email"></td>
			</tr>
				<td><label> Senha: </label></td>
				<td><input type="password" name="senha" required="true"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="salvar"></td>
			</tr>

		</table>
	</form>
	<?php
		
		$strSQL = "insert into usuario (nome,email,senha) values('" . $_POST['nome'] . "','". $_POST['email'] . "','" . md5($_POST['senha']) . "')" ;

		if($bd->query($strSQL))
			echo "<p>Cadastro salvo!</p>";
		else
			echo "<p>Erro ao salvar</p>";
	?>

</body>
</html>
