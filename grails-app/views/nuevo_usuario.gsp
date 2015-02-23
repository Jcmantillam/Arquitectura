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
            <center>
                <p>Completa el formulario de registro que aparece a continuación:</p><br>
                <font color="red" size=2> ${flash.message1}</font> 
                <font color="red" size=2> ${flash.message2}</font>
                <font color="red" size=2> ${flash.message3}</font>
                <font color="red" size=2> ${flash.message4}</font>
                <font color="red" size=2> ${flash.message5}</font>
            </center>
            <center>
            <div style="width:220px">
                <label>Username:</label><input type="text" name="nameUser"/>
                <label>Nombre:</label><input type="text" name="name"/>
                <lable>Apellidos</label><input type="text" name="lastname">
                <label>Email:</label> <input type="text" name="email"/>
                <label>Contraseña:</label> <input type="password" name="password"/><br>
                <input type="submit" value="Registrarse"/>
            </div>
            </center>
        </g:form>
        <br>
        <g:form controller="Usuario" action='Volver'>
           <center>
            <div style="width:220px">
                <label>&nbsp;</label><input type="submit" value="Volver"/>
            </div>
            </center>
        </g:form>
    </body>
</html>
