<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
	<meta name="layout" content="main"/>
            <title> Comprar Boleto </title> 
            <style type="text/css">
                label{
                    float:left;
                    width:65px;
                }
            </style>
    </head>
    <body>
        <p> Compra de boletos de ${session.Nombre} ${session.Apellido}</p>
	<center>
            <g:form controller="Usuario" action="comprarPasajes">
                <br>
                <g:select id="mySelect" name="sPasaje" from="${flotas.Pasaje.list()}" 
                    optionKey="id" optionValue="origenAndDestino" 
                    noSelection="['null':'-Elija el viaje a comprar-']"
                    value="bus"/>
                <br><br>
                <label>&nbsp;</label><input type="submit" value="Comprar"/>
            </g:form>
	</center>
    </body>
</html>
