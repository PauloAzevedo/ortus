<%-- 
    Document   : index
    Created on : 11/04/2013, 12:53:24
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<title>Sistema de Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="css/logar.css" rel="stylesheet" type="text/css">
<script src="js/logar.js" type="text/javascript"></script>
</head>

<body class="geral">
    
    

    

    
    <form id="loginOficial" method="post" action="Login">
        <p>Login</p>
        <input type="text" name="login_Z" title="Informe o login."/>
        <p>Senha</p>
        <input type="password" name="senha_Z" title="Informe a senha."/> 
        <input type="submit" value="Acessar" title="Clique para acessar o portal."/>
    </form>
    
    
    
    <a href="cadUsuario/" title="cadastro de usuario">Cad Usuario</a>
    </br>
    <a href="cadTipo/" title="cadastro de tipo">Cad Tipo</a>
    </br>
    <a href="cadPapel/" title="cadastro de papel">Cad Papel</a>
    </br>
    <a href="cadArquivo/" title="cadastro de arquivo">Cad Arquivo</a>

</body>
</html>
