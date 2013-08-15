/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.testes;

import br.com.ortus.beans.Papel;
import br.com.ortus.beans.UnidadeMedida;
import br.com.ortus.beans.Usuario;
import br.com.ortus.conexao.HibernateConfiguration;
import br.com.ortus.conexao.TransactionManager;
import br.com.ortus.daos.DaoPapel;
import br.com.ortus.daos.DaoUnidadeMedida;
import br.com.ortus.daos.DaoUsuario;
import br.com.ortus.utils.Utilidades;



/**
 *
 * @author Erick
 */
public class Teste {
    
    public static void main(String[] args) {
//        HibernateConfiguration.setBase("ortus_asstec");
//        //HibernateConfiguration.setHost("192.168.1.250:3306");
//        HibernateConfiguration.setHost("ortusservidor.no-ip.org:3306");
//        HibernateConfiguration.setPass("aluno");
//        HibernateConfiguration.setUser("root");
        HibernateConfiguration.criarSchema();
        criarUsuarioADM();
        
//        String senha = "paulo_Azevedo_74596";
//        String senha2 = new Utilidades().encripitarSenha(senha);
//        String senha3 = new Utilidades().decripitarSenha(senha2);
//        
//        System.out.println(senha + "\n" + senha2 + "\n" + senha3);
    }
    
    private static void criarUsuarioADM() {
        try{
            Papel papel = new Papel();
            papel.setNome("administrador");
            
            Usuario usuario = new Usuario();
            usuario.setNome("ADMIN");
            usuario.setCnpj("00.000.000/0001-00");
            usuario.setLogin("ortus3");
            usuario.setSenha("Ortus1245");
            usuario.setPapel(papel);
            
            UnidadeMedida unM = new UnidadeMedida();
            unM.setNome("PÇ");
            UnidadeMedida unM2 = new UnidadeMedida();
            unM2.setNome("MT");
            
            
            TransactionManager.beginTransaction();
            new DaoPapel().persistir(papel);
            new DaoUsuario().persistir(usuario);
            new DaoUnidadeMedida().persistir(unM);
            new DaoUnidadeMedida().persistir(unM2);
            TransactionManager.commit();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
