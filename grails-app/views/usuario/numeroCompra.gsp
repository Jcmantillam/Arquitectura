<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main"/>
        <!--Mensaje de la cabecera, colocar nombre de usuario-->
        <title> Comprar pasajes </title> 
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
            <p>Ingrese el número de pasajes para el viaje (No más de ${numero})</p>
            <br>
            <g:select name="numeroComprar" from="${1..10}" value="${numero}"
                noSelection="['':'-Seleccione una cantidad-']"/>
        </center>
    </body>
</html>
