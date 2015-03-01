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
		<g:datePicker name="myDate" value="${new Date()}" relativeYears="[-2..7]"/>
	</center>
</body>
</html>
