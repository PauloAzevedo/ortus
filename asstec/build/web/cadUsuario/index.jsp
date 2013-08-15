<%-- 
    Document   : index
    Created on : 12/04/2013, 11:19:22
    Author     : Paulo Azevedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioLogado}">
    <c:redirect url="../" />
</c:if>
<!DOCTYPE html>
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
                        <form method="post"id ="cadUsuario" name="cadUsuario" action="../CadastroUsuario">
                            <h4>Nome:</h4>
                            <input type="text" name="nome_Z" size="50"/>
                            <h4>CNPJ:</h4>
                            <input type="text" name="cnpj_Z" size="50"/>
                            <h4>Login:</h4>
                            <input type="text" name="login_Z" size="50"/>
                            <h4>Senha:</h4>
                            <input type="password" name="senha_Z" size="50"/>
                            <h4>Papel:</h4>
                            <select name="papel_Z">
                                <c:forEach var="papel" items="${listaPapeis}" varStatus="status"> 
                                    <option value="${papel.getNome()}">${papel.getNome()}</option>  
                                </c:forEach>
                            </select>
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