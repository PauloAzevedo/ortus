package br.com.ortus.daos;

import br.com.ortus.beans.Arquivo;
import java.util.List;

/**
 *
 * @author a1028367
 */
public class DaoArquivo extends DaoGenerics<Arquivo> {
    public DaoArquivo() {
        super.alvo = Arquivo.class;
    }

    public List listarPorTipo(String tipo) {        
        String query = " e WHERE e.tipo.tipo ='" + tipo + "' ";
        List<Arquivo> arquivos = new DaoArquivo().listar2(query);
        return arquivos;
    }
}
