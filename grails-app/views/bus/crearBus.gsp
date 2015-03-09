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
        <center>
                <font size="2" color="blue"><p>Completa el formulario de registro que aparece a continuación:</p></font><br>
                <font color="red" size=2> ${flash.messagePL}</font> 
                <font color="red" size=2> ${flash.messageNM}</font>
                <font color="red" size=2> ${flash.messageCO}</font>
                <font color="red" size=2> ${flash.messageBT}</font>
                <font color="red" size=2> ${flash.messageID}</font>
                
        </center>
         <g:form controller="Bus" action='crearBus'>
            <center>
                <div style="width:220px">
                    <label> codigo de Bus:     </label><input type="text" name="id">
                    <label> placa Bus:         </label><input type="text" name="placa">
                    <label> ID empresa:        </label><input type="text" name="idemp">
                    <label> numero Sillas:     </label><input type="text" name="num">
                    <label> conductor asignado:</label><input type="text" name="cond">
                    <label> tipo de bus:       </label><input type="text" name="btipo">
                    <input type="submit" value="Crear"> 
                </div>
            </center>
        </g:form>
    </body>
</html>
