<%-- 
    Document   : template
    Created on : 15/04/2013, 11:12:42
    Author     : Paulo Azevedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioLogado}">
    <c:redirect url="../" />
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ASSTEC Ortus</title>
        <link href="../css/stylesTemplate.css" rel="stylesheet" type="text/css">
        <script src="../js/templateJS.js" type="text/javascript" charset="utf-8"></script>

    </head>
    <body>
        <!--Página-->
        <div id="pagina">
            <!--Topo da pagina-->    
            <div id="cabecalho">
                <div id="dentroCabecalho">
                    <div id="logo">

                    </div>
                    <div id="usuario">

                    </div>
                </div>
            </div>
            <!--Fim Topo da pagina-->
            <!--Conteudo da pagina-->
            <div class="clear10">                
            </div>
            <div id="conteudo">                
                <div id="menuPrincipal">
                    <nav id="menu">
                        <ul>
                            <li class="current-menu-item"><a href="#">Home</a></li>
                            <li><a href="#">Projectos</a></li>
                            <li><a href="#">Tutoriais</a><!-- nível 1 -->
                                <ul>
                                    <li><a href="#">Fireworks</a></li>
                                    <li><a href="#">Photoshop</a></li>
                                    <li><a href="#">Programação</a><!-- nível 2 -->
                                        <ul>
                                            <li><a href="#">CSS</a></li>
                                            <li><a href="#">HTML</a></li>
                                            <li><a href="#">PHP</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="#">Contact</a></li>
                        </ul>
                    </nav>
                </div>
                <div id="conteudoReal">

                </div>

            </div>
            <!--Fim Conteudo da pagina-->
            <!--Rodapé da pagina-->
            <div class="clear10"> 
            </div>

            <div id="rodape">
                <div id="dentroRodape">
                    <div id="direitos">
                        <p>2013 - Todos os direitos reservados a <a href="http://ortus.com.br" target="_blank" title="Site comercial Ortus">Ortus Ind. e Comércio LTDA.</a></p>
                    </div>
                    <div id="autor">
                        <p>Desenvolvido por <a href="mailto:ti@ortus.com.br" title="Fale com o autor.">Paulo Azevedo.</a></p>
                    </div>
                </div>
            </div>
            <!--Fim Rodapé da pagina-->
        </div>
        <!--Fim da Página-->
    </body>
</html>
