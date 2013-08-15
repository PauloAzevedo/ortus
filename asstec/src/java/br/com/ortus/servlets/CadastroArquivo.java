/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.servlets;

import br.com.ortus.beans.Arquivo;
import br.com.ortus.beans.Tipo;
import br.com.ortus.beans.Usuario;
import br.com.ortus.conexao.TransactionManager;
import br.com.ortus.daos.DaoArquivo;
import br.com.ortus.daos.DaoTipo;
import br.com.ortus.utils.PDFManager;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo Azevedo
 */
@WebServlet(name = "CadastroArquivo", urlPatterns = {"/CadastroArquivo"})
public class CadastroArquivo extends HttpServlet {

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
            //String caminho = request.getParameter("arquivo_Z");
            String tipo = request.getParameter("tipo_Z");

            File file = new File(request.getParameter("arquivo_Z"));

            File file2 = new File(file.getPath());

            boolean atributosOK = verificarAtributos(id, nome, file, tipo);

            if (atributosOK) {
                Arquivo arquivoObj = new Arquivo();
                if (id.length() != 0) {
                    arquivoObj.setId(Long.parseLong(id));
                }
                arquivoObj.setNome(nome);

                arquivoObj.setArquivo(file);
                //System.out.println("Caminho:"+file.getAbsolutePath());
                //byte[] fileByte = PDFManager.getPDFManager().fileToByte(file2);
                //arquivoObj.setArquivoByte(fileByte);


                Tipo tipoObj = resgatarTipo(tipo);

                arquivoObj.setTipo(tipoObj);


                Arquivo arquivoPersistido = persistirArquivo(arquivoObj);

                if (arquivoPersistido != null) {
                    //request.getSession().setAttribute("arquivoPersistido", arquivoPersistido);
                    request.getSession().setAttribute("tipo_Z", arquivoPersistido.getTipo().getTipo());
                    request.getSession().removeAttribute("listaArquivos");
                    response.sendRedirect("ListarArquivos");
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

    private boolean verificarAtributos(String id, String nome, File file, String tipo) {
        return true;
    }

    private Tipo resgatarTipo(String tipo) {
        return new DaoTipo().obterPorNome(tipo);
    }

    private Arquivo persistirArquivo(Arquivo arquivoObj) {
        try {
            TransactionManager.beginTransaction();
            new DaoArquivo().persistir(arquivoObj);
            TransactionManager.commit();
            return arquivoObj;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
