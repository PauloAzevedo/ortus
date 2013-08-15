/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.login;

import br.com.ortus.beans.Usuario;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            String login = request.getParameter("login_Z");
            String senha = request.getParameter("senha_Z");
            
            boolean parametrosOK = verificarParametros(login, senha);
            
            if(parametrosOK){
                Usuario usuario = validarUsuario(login, senha);
                if(usuario!=null){                    
                    request.getSession().setAttribute("usuarioLogado", usuario);
                    response.sendRedirect("./cadTipo/");
                }else{
                    response.sendRedirect("./");
                }
            }else{
                response.sendRedirect("./");
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

    private boolean verificarParametros(String login, String senha) {
        if(login.length()!=0 && senha.length()!=0){
            return true;
        }
        return false;
    }

    private Usuario validarUsuario(String login, String senha) {
        Usuario usuarioInterno = new DaoUsuario().obterPorLogin(login);
        if(usuarioInterno!=null){
            System.out.println("Senha encriptada1:"+usuarioInterno.getSenha());
            String senhaInterna = usuarioInterno.getSenha();
            System.out.println("Senha encriptada2: "+senhaInterna);
            if(senhaInterna.equals(senha)){
                return usuarioInterno;
            }
            System.out.println("Erro senha");
            return null;
        }
        System.out.println("Erro usuario errado");
        return null;
    }

    private String decripitarSenha(String senha) {
        String senhaDecripitada = "";
        for (int i = 0; i < senha.length(); i++) {
            char carac = (char) (senha.charAt(i) / 12);
            senhaDecripitada += carac;
        }
        return senhaDecripitada;
    }
}
