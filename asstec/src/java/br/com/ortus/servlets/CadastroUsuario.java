/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.servlets;

import br.com.ortus.beans.Papel;
import br.com.ortus.beans.Usuario;
import br.com.ortus.conexao.TransactionManager;
import br.com.ortus.daos.DaoPapel;
import br.com.ortus.daos.DaoUsuario;
import br.com.ortus.utils.Utilidades;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo
 */
@WebServlet(name = "CadastroUsuario", urlPatterns = {"/CadastroUsuario"})
public class CadastroUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String nome = (String) request.getParameter("nome_Z");
            String login = (String) request.getParameter("login_Z");
            String senha = (String) request.getParameter("senha_Z");
            String cnpj = (String) request.getParameter("cnpj_Z");
            String papel = (String) request.getParameter("papel_Z");
            
            boolean atributosOK = verificarAtributos(nome, login,senha,cnpj);
             System.out.println(senha);
            if(atributosOK){
                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setLogin(login);
                usuario.setCnpj(cnpj);
                //String novaSenha = encripitarSenha(senha);
                //System.out.println("Senha4444444444: "+ novaSenha);
                usuario.setSenha(senha);
                
                Papel papelUsuario = resgatarPapel(papel);
                
                usuario.setPapel(papelUsuario);
                
                Usuario usuarioPersistido = inserirUsuario(usuario);
                
                if(usuarioPersistido!=null){
                    request.getSession().setAttribute("usuarioPersistido", usuarioPersistido);
                    request.getSession().removeAttribute("listaUsuarios");
                    response.sendRedirect("ListarUsuarios");
                }else{
                    
                }
                
            }
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean verificarAtributos(String nome, String login, String senha, String cnpj) {
       
        return true;
    }

    private Papel resgatarPapel(String papel) {
        return new DaoPapel().obterPorNome(papel);
    }

    private Usuario inserirUsuario(Usuario usuario) {
        try{
            TransactionManager.beginTransaction();
            new DaoUsuario().persistir(usuario);
            TransactionManager.commit();
            return usuario;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    private String encripitarSenha(String senha) {
        String senhaEncripitada = "";
        for (int i = 0; i < senha.length(); i++) {
            char carac = (char) (senha.charAt(i) * 12);
            senhaEncripitada += carac;
        }
        return senhaEncripitada;
    }
}
