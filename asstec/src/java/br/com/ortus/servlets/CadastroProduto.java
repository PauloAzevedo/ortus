/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.servlets;

import br.com.ortus.beans.Produto;
import br.com.ortus.beans.UnidadeMedida;
import br.com.ortus.conexao.TransactionManager;
import br.com.ortus.daos.DaoProduto;
import br.com.ortus.daos.DaoUnidadeMedida;
import java.io.File;
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
@WebServlet(name = "CadastroProduto", urlPatterns = {"/CadastroProduto"})
public class CadastroProduto extends HttpServlet {

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
           
            
            String id = request.getParameter("id_Z");
            String codigoOrtus = request.getParameter("codigoOrtus_Z");
            String nome = request.getParameter("nome_Z");
            String descricao = request.getParameter("descricao_Z");            
            String unidadeMedida = request.getParameter("unidade_Z");            
            String valor = request.getParameter("valor_Z");
            
            File foto = new File(request.getParameter("foto_Z"));
            
            
            boolean atributosOK = verificarAtributos(id, nome, codigoOrtus,descricao, unidadeMedida, valor);
            
            if(atributosOK){
                Produto arquivoObj = new Produto();
                if(id.length()!=0){
                    arquivoObj.setId(Long.parseLong(id));
                }
                arquivoObj.setNome(nome);
                
                arquivoObj.setCodigoOrtus(codigoOrtus);
                
                arquivoObj.setDescrição(descricao);
                
                arquivoObj.setFoto(foto);
                
                double valorConvertido = converterValorString(valor);
                
                arquivoObj.setValor(valorConvertido);
                
                UnidadeMedida unidadeObj = resgatarUnidadeMedida(unidadeMedida);
                
                arquivoObj.setUnidMedida(unidadeObj);
                
                
                Produto produtoPersistido = persistirProduto(arquivoObj);
                
                if(produtoPersistido!=null){
                    //request.getSession().setAttribute("arquivoPersistido", arquivoPersistido);
                    
                    request.getSession().removeAttribute("listaArquivos");
                    response.sendRedirect("ListarProdutos");
                }else{
                    System.out.println("Erro no cadastro!");
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

    private boolean verificarAtributos(String id, String nome, String codigoOrtus, String descricao, String unidadeMedida, String valor) {
        return true;
    }

    private UnidadeMedida resgatarUnidadeMedida(String unidadeMedida) {
        return new DaoUnidadeMedida().obterPorNome(unidadeMedida);
    }

    private Produto persistirProduto(Produto arquivoObj) {
        try{
            TransactionManager.beginTransaction();
            new DaoProduto().persistir(arquivoObj);
            TransactionManager.commit();
            return arquivoObj;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    private double converterValorString(String valor) {
        try{
            double valorConvertido = Double.parseDouble(valor);
            return valorConvertido;
        }catch(Exception e){
            System.out.println("Erro na conversão do valor de dinheiro!");
            return 0.0;
        }
    }
}
