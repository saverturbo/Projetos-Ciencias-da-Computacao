<!DOCTYPE html>
<html>
<head>
	<title>Numeros</title>
</head>
<body>
	
	<form action="/aplicacaoteste/numeros.php" method="POST">
		<table>
			<tr>
				<td>
					<p>Digite um numero</p>
				</td>
				<td>
					<input type="number" name="numeros">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="Salvar">
				</td>
			</tr>

	</table>
	</form>

	<?php  
		if (isset($_POST["numeros"])){
		
			echo "- ".$_POST["numeros"]. "<br>";
		
		}else{
			echo "Por favor digite os numeros". "<br>"	;	
		}
	?>

</body>
</html>

