/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.servlets;

import br.com.ortus.beans.Tipo;
import br.com.ortus.beans.Usuario;
import br.com.ortus.conexao.TransactionManager;
import br.com.ortus.daos.DaoTipo;
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
@WebServlet(name = "CadastroTipo", urlPatterns = {"/CadastroTipo"})
public class CadastroTipo extends HttpServlet {

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
            String tipo = request.getParameter("tipo_Z");
            
            boolean atributosOK = verificarAtributos(id, tipo);
            
            if(atributosOK){
                Tipo tipoObj = new Tipo();
                if(id.length()!=0){
                    tipoObj.setId(Long.parseLong(id));
                }
                tipoObj.setTipo(tipo);
                
                Tipo tipoPersistido = persistirTipo(tipoObj);
                
                if(tipoPersistido!=null){
                    //request.getSession().setAttribute("tipoPersistido", tipoPersistido);                    
                    request.getSession().setAttribute("sucessoTipo", "sucesso");
                    request.getSession().removeAttribute("listaUsuarios");
                    response.sendRedirect("ListarTipos");
                }else{
                    request.getSession().setAttribute("erroTipo", "erro");
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

    private boolean verificarAtributos(String id, String tipo) {
        if(tipo.length()!=0){
            return true;
        }
        return false;
    }

    private Tipo persistirTipo(Tipo tipoObj) {
        try{
            TransactionManager.beginTransaction();
            new DaoTipo().persistir(tipoObj);
            TransactionManager.commit();
            return tipoObj;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
