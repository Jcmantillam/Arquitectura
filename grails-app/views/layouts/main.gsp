<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'icon_t.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'icon_t.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'icon_t.png')}">
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>
                        
            <table width="770" bgcolor="#001d7e">
            <tr>
                <td></td>
            </tr>           
            <tr>
                <td width="208"><strong><img src="http://localhost:8080/Flotas/assets/logo2.png" width="163" height="43" alt="term" /></strong></td>
                <td width="200"></td>
                <td width="366"><p>
                                <font size="1" color="white">Usuario:<g:textField name="nameUser" size="10" />
                                Contraseña:<g:passwordField name="password" size="10" /></font>
                                
                                <font size="1"><input type="button" name="Boton1" value="Ingresar" OnClick="tu_funcion_o_url_o_accion();"></font></p></td>
            </tr>
            </table>
            <!--<div id="grailsLogo" role="banner"><a><asset:image src="logo2.png" alt="Grails"/></a></div>-->
                <g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>
