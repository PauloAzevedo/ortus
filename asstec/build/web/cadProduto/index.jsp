<%-- 
    Document   : index
    Created on : 24/04/2013, 15:05:22
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
                        <form method="post"id ="cadProduto" name="cadProduto" action="../CadastroProduto">
                            
                            <input type="hidden" name="id_Z" size="6"/>
                            <h4>Codigo Ortus:</h4>
                            <input type="text" name="codigoOrtus_Z" size="50"/>
                            <h4>Nome:</h4>
                            <input type="text" name="nome_Z" size="50"/>  
                            <h4>Descrição:</h4>
                            <input type="text" name="descricao_Z" size="150"/>  
                            <h4>Unidade de Medida:</h4>
                            <select name="unidade_Z">
                                <c:forEach var="unidade" items="${listaUnidades}" varStatus="status"> 
                                    <option value="${unidade.getNome()}">${unidade.getNome()}</option>  
                                </c:forEach>              
                            </select>  
                            <h4>Valor de venda R$:</h4>
                            <input type="text" name="valor_Z" size="50"/>
                            <h4>Busque a imagem:</h4>
                            <input type="file" name="foto_Z" />
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

