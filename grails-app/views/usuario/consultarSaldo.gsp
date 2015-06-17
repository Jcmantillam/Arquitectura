<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main"/>
            <title>Consulta de saldo</title>
            <style type="text/css">
                    label{
                        float:left;
                        width:65px;
                    }
            </style>
            <meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
            <title>Terminal de Transportes</title>
            <link rel="stylesheet" type="text/css" href="tcal.css" />
            <script type="text/javascript" src="tcal.js"></script> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <center>
            <h1>Su saldo es de: $<font color="black" size="5"> ${flash.messageCon} </font></h1>
        </center>
        <g:form controller="Usuario" action="Atras">
            <center>
               <label>&nbsp;</label><input type="submit" value="Atrás"/>
            </center>
        </g:form>
    </body>
</html>
