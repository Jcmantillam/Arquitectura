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
        <font color="red" size="2"> ${flash.message} </font>
            <center>
                <p>Completa el formulario de registro que aparece a continuación:</p><br>
                
            </center>
            <g:form controller="Pasaje" action='crear'>
            <center>
            <div style="width:220px">
                <label>Origen:</label><g:textField name="origen"/>
                <label>Destino:</label><g:textField type="text" name="destino"/>
                <label>ID bus:</label> <br> <g:select name="bus" 
                    from="${flotas.Bus.list()}" optionKey="placaBus" optionValue="placaBus" 
                    noSelection="['':'-Elija la placa-']"/>
                <br>
                <label>Número de asiento:</label> <g:textField type="text" name="asiento"/>
                <label>Fecha:</label> <g:datePicker name="fecha" value="${new Date()}" relativeYears="[0..7]"/>
                <br>
                <label>Precio:</label> <g:textField type="text" name="precio"/><br>
                <br>
                <input type="submit" value="Guardar Pasajes"/>
            </div>
            </center>
            </g:form>
        <br>
        <g:form controller="Usuario" action="Atras">
            <center>
               <label>&nbsp;</label><input type="submit" value="Atrás"/>
            </center>
        </g:form>
        
    </body>
</html>
