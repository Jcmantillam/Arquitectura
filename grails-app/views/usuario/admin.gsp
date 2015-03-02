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
            <title> Bienvenido ${flash.messageB} </title> 
            <style type="text/css">
                    label{
                        float:left;
                        height:5em;
                        margin:3px;
                        padding;3px;
                        width:5em;
                    }
            </style>
	</head>
    <body>
        <br>
        <font> Bienvenido Admin. ${flash.messageB} </font>
        <br>
        <g:form controller="Usuario" action="MostrarInfo">
            <label>&nbsp;</label><input type="submit" value="Mostrar Datos"/>
        </g:form>
        <br>
        <g:form controller="Usuario">
            <p> Información de viajes</p>
            <center>
                <!--Aqui consultas de los viajes creados, planeado para el sprint 3-->
            </center>
        </g:form>
        <br>
        <center>
        <g:form controller="pasaje" action="crear">
            <label>&nbsp;</label><input type="submit" value="Crear viajes"/>
        </g:form>
        <br>
        <g:form controller="Usuario" action="listado">
            <label>&nbsp;</label><input type="submit" value="Lista de usuarios">
        </g:form>
        <br>
        </center>
        <g:form controller="Usuario" action="Salir">
            <center>
                <label>&nbsp;</label><input type="submit" value="Salir"/>
            </center>
        </g:form>
    </body>
</html>
