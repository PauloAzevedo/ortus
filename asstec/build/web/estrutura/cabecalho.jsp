<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioLogado}">
    <c:redirect url="../" />
</c:if>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="agora" class="java.util.Date"/>



<!--Topo da pagina-->    
<div id="cabecalho">
    <div id="dentroCabecalho">
        <div id="logo">

        </div>
        <div id="usuario">
            <div id="dentroUsuario">
                <div class="texto_usuario">
                    <div id="esquerda">Olá ${usuarioLogado.getNome().toLowerCase()}
                    </div>
                    <div id="direita">
                        <form method="post" action="../Logout">
                            <input id="logout" type="submit" title="Sair do Portal." value=""/>
                        </form>
                    </div>
                </div>
                <div class="clear10"></div>
                <div class="data"><fmt:formatDate value="${agora}" dateStyle="full"/></div>
            </div>
        </div>
    </div>
</div>
<!--Fim Topo da pagina-->
