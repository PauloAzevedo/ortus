<%-- 
    Document   : index
    Created on : 12/04/2013, 15:37:00
    Author     : Paulo Azevedo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioLogado}">
    <c:redirect url="../" />
</c:if><!DOCTYPE html>
<html>
    <jsp:include page="../estrutura/head.jsp" flush="true" />
    <body>

        <div id="pagina">
            <!--Topo da pagina-->  
            <jsp:include page="../estrutura/cabecalho.jsp" flush="true" />
            <!--Fim Topo da pagina-->
            <!--Conteudo da pagina-->
            <div class="clear10">                
            </div>
            <div id="conteudo">  

                <jsp:include page="../estrutura/menuPrincipal.jsp" flush="true" />

                <div class="clear40">                    
                </div>

                <div id="conteudoReal">

                    <div class="clear30">
                    </div>

                    <div id="formulario">
                        <form method="post"id ="cadTipo" name="cadTipo" action="../CadastroTipo">

                            <input type="hidden" name="id_Z" size="6"/>
                            <h4>Tipo:</h4>
                            <input type="text" name="tipo_Z" size="50"/>  
                            </br></br>
                            <input id="botao" type="submit" value="Cadastrar"/>
                        </form>
                    </div>
                    <div class="clear40">                        
                    </div>  


                </div>
            </div>
            <!--Fim Conteudo da pagina-->
            <jsp:include page="../estrutura/rodape.jsp" flush="true"/>
        </div>
    </body>
</html>