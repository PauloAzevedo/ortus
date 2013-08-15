<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioLogado}">
    <c:redirect url="../" />
</c:if>
<c:if test="${usuarioLogado.getPapel().getNome() == 'administrador'}">
    <div id="menuPrincipal">
        <nav id="menu">
            <ul>
                <li class="current-menu-item"><a href="#">Home</a></li>
                <li><a href="#">Usuarios</a><!-- nível 1 -->
                    <ul>
                        <li><a href="../ListarUsuarios">Listar</a></li>   
                        <li><a href="../ListarPapeisParaCadastro">Cadastrar</a></li>                        
                    </ul>
                </li>
                <li><a href="#">Arquivos</a><!-- nível 1 -->
                    <ul>
                        <li><a href="../ListarArquivos">Listar</a></li> 
                        <li><a href="../ListarTiposParaCadastro">Cadastrar</a></li>                        
                    </ul>
                </li>
                <li><a href="#">Produtos</a><!-- nível 1 -->
                    <ul>
                        <li><a href="../ListarProdutos">Listar</a></li> 
                        <li><a href="../ListarUnidadeMedidaParaCadastro">Cadastrar</a></li>                        
                    </ul>
                </li>
                <li><a href="#">Tipos</a><!-- nível 1 -->
                    <ul>
                        <li><a href="../ListarTipos">Listar</a></li> 
                        <li><a href="../cadTipo">Cadastrar</a></li>                        
                    </ul>
                </li>
                <li><a href="#">Papéis</a><!-- nível 1 -->
                    <ul>
                        <li><a href="../ListarPapeis">Listar</a></li>   
                        <li><a href="../cadPapel/">Cadastrar</a></li>                        
                    </ul>
                </li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </div>
</c:if>

<c:if test="${usuarioLogado.getPapel().getNome() != 'administrador'}">
    <div id="menuPrincipal">
        <nav id="menu">
            <ul>
                <li class="current-menu-item"><a href="#">Home</a></li>
                <li><a href="#">Usuarios</a><!-- nível 1 -->
                    <ul>
                        <li><a href="../ListarUsuarios">Listar</a></li>                   
                    </ul>
                </li>
                <li><a href="#">Arquivos</a><!-- nível 1 -->
                    <ul>
                        <li><a href="../ListarArquivos">Listar</a></li>                       
                    </ul>
                </li>
                <li><a href="#">Tipos</a><!-- nível 1 -->
                    <ul>
                        <li><a href="../ListarTipos">Listar</a></li>                       
                    </ul>
                </li>
                <li><a href="#">Papéis</a><!-- nível 1 -->
                    <ul>
                        <li><a href="../ListarPapeis">Listar</a></li>                       
                    </ul>
                </li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </div>
</c:if>


