<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Listado de usuarios</title>
        <style type="text.css">
            label{
                float:left;
                width:65px;
            }
        </style>
    </head>
    <body>
        <g:form style="padding-right:30px">
            <table>
            <tr>
                    <td><strong>Nombre</strong></td>
                    <td><strong>Apellido</strong></td>
                    <td><strong>Correo</strong></td>
            </tr>
            <g:each in="${usuarios}" var="persona">
                    <tr>
                            <td> ${persona.nombre} </td>
                            <td> ${persona.apellido} </td>
                            <td> ${persona.correo} </td>
                    </tr>
            </g:each>
            </table>
        </g:form>
        <br>
        <g:form controller="Usuario" action="Atras">
            <center>
               <label>&nbsp;</label><input type="submit" value="Atrás"/>
            </center>
        </g:form>
    </body>
</html>
