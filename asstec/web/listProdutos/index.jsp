<%-- 
    Document   : index
    Created on : 26/04/2013, 19:41:17
    Author     : a1028367
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

                    <div class="counteudo"> 

                        
                             <form id="form_listagem" action="#" method="post">

                <table cellpadding="0" cellspacing="0" border="0" class="display" id="listagem">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Cód. Ortus</th>
                            <th>Nome</th>
                            <th>Descrição</th>
                            <th>Unidade</th>  
                            <th>Valor</th>
                            <th>Imagem</th> 
                        </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="produto" items="${listaProdutos}" varStatus="status">                         
                        <tr>
                            <td>${produto.getId()}</td>
                            <td>${produto.getCodigoOrtus()}</td>  
                            <td>${produto.getNome()}</td>
                            <td>${produto.getDescricao()}</td>
                            <td>${produto.getUnidMedida().getNome()}</td>
                            <td>${produto.getValor()}</td>
                            <td><img id="imagem" src="../imagens/pagina/image.png"/></td>
                        </tr>

                    </c:forEach>



                    </tbody>
                    <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Cód. Ortus</th>
                            <th>Nome</th>
                            <th>Descrição</th>
                            <th>Unidade</th>  
                            <th>Valor</th>  
                            <th>Imagem</th> 
                        </tr>
                    </tfoot>
                </table>
            </form>

                    </div>

                </div>
            </div>
            <!--Fim Conteudo da pagina-->
            <jsp:include page="../estrutura/rodape.jsp" flush="true"/>
        </div>
    </body>
</html>

