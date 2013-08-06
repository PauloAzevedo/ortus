package br.com.ortus.daosSistema;


import br.com.ortus.configuracaoPersistencia.HibernateConfiguracao;
import br.com.ortus.configuracaoPersistencia.TransactionManager;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


/**
 *
 * @author Paulo Azevedo
 */
public class BaseDao<T> extends HibernateConfiguracao implements Dao<T>{
    
    Session session = null;
    protected Class classe = null;
    
    public BaseDao(Class classe){
        this.classe = classe;
        this.session = TransactionManager.getCurrentSession();
    }  
    
    @Override
    public void persistir(Object objeto) { 
        session = TransactionManager.getCurrentSession();        
        session.saveOrUpdate(objeto);
    }

    @Override
    public void remover(Object objeto) {
        session = TransactionManager.getCurrentSession();
        session.delete(objeto);        
    }

    @Override
    public T obterPorId(int id) {
        Object objeto = new Object();
        session = TransactionManager.getCurrentSession();
        
        objeto = (T) session.createQuery("FROM "+ classe.getSimpleName() +" WHERE id='"+id+"'").uniqueResult();
        
        return (T) objeto;
    }

    @Override
    public List<T> obterLista(String filtro) {
        if(filtro == null || filtro.isEmpty()){
            return obterLista();
        }        
        List<T> objetos = new ArrayList<T>();
        session = TransactionManager.getCurrentSession();   
        
        objetos = session.createQuery("FROM "+ classe.getSimpleName() +" WHERE " + filtro).list();
        return objetos;
    }
    
    
    public List<T> obterListaFiltroCompleto(String filtro) {
        if(filtro == null || filtro.isEmpty()){
            return obterLista();
        }        
        List<T> objetos = new ArrayList<T>();
        session = TransactionManager.getCurrentSession();   
        
        objetos = session.createQuery(filtro).list();
        return objetos;
    }

    @Override
    public List<T> obterLista() {
        List<T> objetos = new ArrayList<T>();
        session = TransactionManager.getCurrentSession();        
        
        objetos = session.createQuery("FROM "+ classe.getSimpleName()).list();        
        return objetos;
    }

    
    
}
