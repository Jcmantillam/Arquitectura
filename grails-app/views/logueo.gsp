<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
        <head>
            <meta name="layout" content="main"/>
            <title>Simple login</title>
            <style type="text/css">
                    label{
                        float:left;
                        width:65px;
                    }
            </style>
	</head>
	<body>
            <g:form controller="Usuario" action="Entrar">
                    <center>
                        <font color="red" size="2"> ${flash.messageL} </font>
                        <div>
                            <p>
                                <br>Usuario:<g:textField name="nameUser"/><br>
                                Contraseña:<g:passwordField name="password"/>
                            </p>
                        </div>
                        <br>
                        <label>&nbsp;</label><input type="submit" value="Entrar"/>
                    </center>
            </g:form>
            
            <g:form controller="Usuario" action="nuevo_usuario">
                <label>&nbsp;</label><input type="submit" value="Crear usuario"/>
            </g:form>
	</body>
</html>
