<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioLogado}">
    <c:redirect url="../" />
</c:if>
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
