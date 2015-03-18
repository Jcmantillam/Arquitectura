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
        <title> Bienvenido ${flash.messageB} </title> 
        <style type="text/css">
            label{
                float:left;
                width:65px;
            }
        </style>
    </head>
    <body>
        <br>
        <font> Bienvenido ${flash.messageB} </font>
        <br>
        <g:form controller="Usuario" action="MostrarInfo">
            <label>&nbsp;</label><input type="submit" value="Mostrar Datos"/>
        </g:form>
        <br>
        <g:form controller="Usuario" >
            <p>Información de tiquetes</p>
            <center>
                <!--Aqui consultas de los tiquetes comprados, planeado para el sprint 3-->
                <div style="width:220px">
            </center>
        </g:form>
        
        <br>
        <table>
            <tr>
                <td>
                    <g:form controller="Usuario" action="Comprar">
                        <label>&nbsp;</label><input type="submit" value="Comprar pasaje nuevo"/>
                    </g:form>
                </td>
                <td>
                    <g:form controller="Usuario" action="Lista_Tiquetes">
                        <label>&nbsp;</label><input type="submit" value="Cambiar pasaje"/>
                    </g:form>
                </td>
                <td>
                    <g:form controller="Usuario" action="Imprimir">
                        <label>&nbsp;</label><input type="submit" value="Imprimir pasaje"/>
                    </g:form>
                </td>
            </tr>
        </table>
        <br>
        <g:form controller="Usuario" action="ConsultCancelar">
            <center>
                <label>&nbsp;</label><input type="submit" value="Cancelar pasaje"/>
            </center>
        </g:form>
        <br>
        <br>
        <g:form controller="Usuario" action="Salir">
            <center>
                <label>&nbsp;</label><input type="submit" value="Salir"/>
            </center>
        </g:form>
    </body>
</html>
