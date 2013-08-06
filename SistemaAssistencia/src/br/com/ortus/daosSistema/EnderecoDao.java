/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daosSistema;


import br.com.ortus.beans.Endereco;
import br.com.ortus.configuracaoPersistencia.HibernateConfiguracao;
import org.hibernate.Session;

/**
 *
 * @author a1028367
 */
public class EnderecoDao extends BaseDao<Endereco> {
    
    public EnderecoDao(){
        super(Endereco.class);
    }
 
    public Endereco obterEnderecoPorCep(String cep) {
        Endereco endereco = new Endereco();
        Session sessao = HibernateConfiguracao.openConect();        
        sessao.beginTransaction();
        endereco = (Endereco) sessao.createQuery("FROM Endereco WHERE cep='"+cep+"'").uniqueResult();
        sessao.close();
        return endereco;
    }

    
}
