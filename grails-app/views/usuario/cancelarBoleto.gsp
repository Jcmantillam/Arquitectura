<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main"/>
            <title> Comprar Boleto </title> 
            <style type="text/css">
                label{
                    float:left;
                    width:65px;
                }
            </style>
            <script languaje="javascript">
                function prueba(form){
                    if(window.confirm('Se cancelarán los pasajes seleccionados')==true)
                        form.reset();
                }
            </script>

    </head>
    <body>
        <p> Cancelación de boletos de ${session.Nombre} ${session.Apellido}</p>
        <center>
            <p> Seleccione el viaje que desea cancelar:</p>
            <br>
            <g:form controller="Usuario" action="Cancelar">
                <g:select name="cancelMod" from="${comprados}" optionKey="id" optionValue="origen - destino"
                        noSelection="['null':'-Elija el viaje a quitar-']"/>
                <br><br>
                <label>&nbsp;</label><g:actionSubmit type="submit" value="Cancelar" 
                    onclick="return confirm('Se eliminará el viaje seleccionado ¿Continuar?')"/>
            </g:form>
        </center>
    </body>
</html>
