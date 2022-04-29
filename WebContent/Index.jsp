<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="CalculoFolha">
	
		<pre>
			<label>Informe o Salário:</label>
			<input type="text" name="salarioBruto"/>
			
			
			
			<label>Quantos dependente você possui?</label>
			<input type="text" name="qtdeDependentes"/>
			
			
			<input type="submit" value="Calcular"/>
		
		</pre>	
	</form>

</body>
</html>