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
            <title> Pasajes de ${session.Nombre} ${session.Apellido} </title> 
            <style type="text/css">
                label{
                    float:left;
                    width:65px;
                }
            </style>
    </head>
    <body>
        <br>
        <font> Pasajes de ${session.Nombre} ${session.Apellido} </font>
        <br>
        <center>
            <p> Seleccione el viaje que desea cambiar:</p>
            <br>
            <g:form controller="Usuario" action="Modificar">
                <g:select name="selectMod" from="${comprados}" optionKey="id" optionValue="origen - destino"
                        noSelection="['null':'-Elija el viaje a cambiar-']"/>
                <br><br>
                <label>&nbsp;</label><input type="submit" value="Modificar"/>
            </g:form>
        </center>
    </body>
</html>
