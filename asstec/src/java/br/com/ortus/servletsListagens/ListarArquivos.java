/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.servletsListagens;

import br.com.ortus.beans.Arquivo;
import br.com.ortus.daos.DaoArquivo;
import br.com.ortus.utils.PDFManager;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo
 */
@WebServlet(name = "ListarArquivos", urlPatterns = {"/ListarArquivos"})
public class ListarArquivos extends HttpServlet {

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
            String tipo = (String) request.getSession().getAttribute("tipo_Z");
            List listaArquivos;
            if (tipo != null) {
                listaArquivos = new DaoArquivo().listarPorTipo(tipo);
            } else {
                listaArquivos = new DaoArquivo().listar();
            }
//            Usuario user = (Usuario) listaUsuarios.get(0);
//            
//            System.out.println(user.getPapel().getNome());

            if (!listaArquivos.isEmpty()) {
                try {
                    List<String> caminhos = new ArrayList<String>();
                    for (int i = 0; i < listaArquivos.size(); i++) {
                        Arquivo nomeArquivo = (Arquivo) listaArquivos.get(i);
                        PDFManager.getPDFManager().gravarPDF(nomeArquivo.getArquivo(), "G://testeFile/", nomeArquivo.getArquivo().getPath());
                        caminhos.add("G://testeFile/" + nomeArquivo.getNome());
                    }
                    request.getSession().setAttribute("caminhos", caminhos);

                } catch (Exception ex) {
                    Logger.getLogger(ListarArquivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                request.getSession().setAttribute("listaArquivos", listaArquivos);
                response.sendRedirect("listArquivos/");
            }
//            File file = new File("G://testeFileArquivoDestino.pdf");
//            FileOutputStream fileout = new FileOutputStream(file);
//            BufferedOutputStream buffer = new BufferedOutputStream(fileout);          
//
//            InputStream input = (InputStream) listaArquivos.get(1);
//            byte[] bytes = new byte[input.available()];
//            input.read(bytes, 0, input.available());
//            buffer.write(bytes);
//            buffer.flush();
//            buffer.close();

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
    
    
    
}
