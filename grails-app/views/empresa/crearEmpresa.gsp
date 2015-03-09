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
         <g:form controller="Empresa" action='crearEmpresa'>
            <center>
                <div style="width:220px">
                    <label> ID Empresa:     </label><input type="text" name="idemp">
                    <label> Nombre Empresa: </label><input type="text" name="nmemp">
                    <input type="submit" value="Crear"> 
                </div>
            </center>
        </g:form>
    </body>
</html>
