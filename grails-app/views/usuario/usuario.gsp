<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
     <head>
        <meta name="layout" content="main"/>
        <title>Terminal de Buses</title>
        <style type="text.css">
            label{
                float:left;
                width:65px;
            }
        </style>
    </head>
    <body>
        
        <g:form controller="Usuario" action='Registrarse'>
            <p>Información de tu cuenta</p>              
            <center>
            <div style="width:220px">
                <label>Nombre de usuario:</label>${session.Usuario}
                <label>Nombre: </label>${session.Nombre}<br>
                <lable>Apellidos: </label>${session.Apellido}<br>
                <label>Email: </label>${session.Correo}<br>
            </div>
            </center>
        </g:form>
        <br>    
        <g:form controller="Usuario" action="Salir">
            <center>
               <label>&nbsp;</label><input type="submit" value="Salir"/>
            </center>
        </g:form>
        <br>
        <g:form controller="Usuario" action="Atras">
            <center>
               <label>&nbsp;</label><input type="submit" value="Atras"/>
            </center>
        </g:form>
    </body>
</html>
