/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.servlets;

import br.com.ortus.beans.Papel;
import br.com.ortus.conexao.TransactionManager;
import br.com.ortus.daos.DaoPapel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo Azevedo
 */
@WebServlet(name = "CadastroPapel", urlPatterns = {"/CadastroPapel"})
public class CadastroPapel extends HttpServlet {

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
            //Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

            String id = request.getParameter("id_Z");
            String nome = request.getParameter("nome_Z");

            boolean atributosOK = verificarAtributos(id, nome);

            if (atributosOK) {
                Papel papelObj = new Papel();
                if (id.length() != 0) {
                    papelObj.setId(Long.parseLong(id));
                }
                papelObj.setNome(nome);

                Papel papelPersistido = persistirPapel(papelObj);

                if (papelPersistido != null) {
                    //request.getSession().setAttribute("papelPersistido", papelPersistido);
                    request.getSession().removeAttribute("listaPapeis");
                    response.sendRedirect("ListarPapeis");
                } else {
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

    private boolean verificarAtributos(String id, String nome) {
        if(nome.length()!=0){
            return true;
        }
        return false;
    }

    private Papel persistirPapel(Papel papelObj) {
        try{
            TransactionManager.beginTransaction();
            new DaoPapel().persistir(papelObj);
            TransactionManager.commit();
            return papelObj;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
