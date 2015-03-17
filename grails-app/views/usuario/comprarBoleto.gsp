<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<meta name="layout" content="main"/>
	<title>Comprar boleto</title>
</head>
<body>
	<center>
		<g:select name="select-pasaje.origen" from="${Pasaje.list()}" />
	</center>
</body>
</html>
