/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.configuracaoPersistencia;


import br.com.ortus.beans.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Paulo
 */
public abstract class HibernateConfiguracao {

    private static AnnotationConfiguration cfg;
    private static SessionFactory sessionFactory;
    
    private static String usuarioBase = "root";// seu nome de usuario da base de dados aqui
    private static String senhaBase = "aluno";// sua seha de usuario da base de dados aqui
    private static String baseDados = "astec";// o nome da sua base de dados aqui
    private static String host = "192.168.1.251:3306";

    public static Session openConect() {
        if (cfg == null) {
            cfg = new AnnotationConfiguration();
            cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            cfg.setProperty("hibernate.connection.username", usuarioBase);
            cfg.setProperty("hibernate.connection.password", senhaBase);
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://"+host +"/"+baseDados);
            //cfg.setProperty("hibernate.connection.url", "jdbc:mysql://ortusservidor.no-ip.org:3306/"+baseDados);
            
            //cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/"+baseDados);
            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.connection.autocommit", "true");

            cfg.addAnnotatedClass(Cidade.class);
            cfg.addAnnotatedClass(Endereco.class);
            cfg.addAnnotatedClass(Usuario.class);
            cfg.addAnnotatedClass(Cliente.class);
            cfg.addAnnotatedClass(Componente.class);
            cfg.addAnnotatedClass(Equipamento.class);
            cfg.addAnnotatedClass(Estado.class);
            cfg.addAnnotatedClass(Pais.class);
            cfg.addAnnotatedClass(Assistencia.class);
            cfg.addAnnotatedClass(MoldeComponente.class);
            cfg.addAnnotatedClass(Atendimento.class);
            cfg.addAnnotatedClass(TabelaTroca.class);
            cfg.addAnnotatedClass(PedidosReservados.class);
            cfg.addAnnotatedClass(Estoque.class);
            
            cfg.addAnnotatedClass(ControleAcesso.class);
            
            cfg.addAnnotatedClass(Log.class);
            
            
            
            sessionFactory = cfg.buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

    public static void criarSchema() {
        openConect().close();
        org.hibernate.tool.hbm2ddl.SchemaExport schemaEx = new SchemaExport(cfg);
        schemaEx.create(true, true);
    }
    
    public static List<Object> runHQLQuery(String hql){
        Session session = TransactionManager.getCurrentSession();
        return session.createQuery(hql).list();
    }

    public static String getSenhaBase() {
        return senhaBase;
    }

    public static void setSenhaBase(String senhaBase) {
        HibernateConfiguracao.senhaBase = senhaBase;
    }

    public static String getUsuarioBase() {
        return usuarioBase;
    }

    public static void setUsuarioBase(String usuarioBase) {
        HibernateConfiguracao.usuarioBase = usuarioBase;
    }

    public static String getBaseDados() {
        return baseDados;
    }

    public static void setBaseDados(String baseDados) {
        HibernateConfiguracao.baseDados = baseDados;
    }
    
    
    public static ArrayList<Class> getEntityClasses() {
        ArrayList<Class> classes = new ArrayList<Class>();

        if (cfg == null) {
            openConect();
        }
        
        Iterator i = cfg.getClassMappings();
        while(i.hasNext()) {
            classes.add(((PersistentClass)i.next()).getMappedClass());
        }
        return classes;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        HibernateConfiguracao.host = host;
    }
    
    
    
    
    
}
