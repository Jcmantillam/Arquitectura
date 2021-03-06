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
        <title> Comprar pasajes </title> 
        <style type="text/css">
            label{
                float:left;
                width:65px;
            }
        </style>
    </head>
    <body>
        <p> Compra de boletos de ${session.Nombre} ${session.Apellido}</p>
        <center>
            <p>Ingrese el número de pasajes para el viaje (Observe el limite)</p>
            <br>
            <table>
                <tr>
                    <td><strong>Origen</strong></td>
                    <td><strong>Destino</strong></td>
                    <td><strong>Lugares</strong></td>
                </tr>
                <g:each in="${numero}" var="disponibles">
                    <tr>
                        <td> ${disponibles.origen} </td>
                        <td> ${disponibles.destino} </td>
                        <td> ${disponibles.asiento} </td>
                    </tr>
                </g:each>
            </table>
            <p>Seleccione la matrícula del autobús en el cual desea hacer la reserva:</p>
            
        </center>
        <g:form controller="Usuario" action="confirmarCompra">
            <br>
                <g:select id="mySelect" name="getPasaje" from="${numero}" 
                    optionKey="bus" optionValue="bus" 
                    noSelection="['null':'-Elija el bus-']"
                    value="Pasaje.bus"/>
                <br><br>
            <label>¿Cuantos pasajes desea?:</label><input type="text" name="numPasajes">
            <input type="submit" value="Comprar"> 
        </g:form>
    </body>
</html>
