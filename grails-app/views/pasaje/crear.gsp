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
        <g:form controller="Pasaje" action='crear'>
            <center>
                <p>Completa el formulario de registro que aparece a continuación:</p><br>
                
            </center>
            <center>
            <div style="width:220px">
                <label>Codigo Pasaje:</label><input type="text" name="id"/>
                <label>Origen:</label><input type="text" name="origen"/>
                <lable>Destino:</label><input type="text" name="destino"/>
                <label>Empresa:</label> <input type="text" name="empresa"/>
                <label>Placa:</label> <input type="text" name="placa"/>
                <label>Asiento:</label> <input type="text" name="asiento"/>
                <label>Fecha:</label> <g:datePicker name="fecha" value="${new Date()}" relativeYears="[-2..7]"/>
                <label>Precio:</label> <input type="text" name="precio"/><br>
                <input type="submit" value="Guardar Pasaje"/>
            </div>
            </center>
        </g:form>
        <br>
        
    </body>
</html>
