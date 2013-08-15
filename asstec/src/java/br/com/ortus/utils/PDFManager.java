/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ehrickwilliam
 */
public class PDFManager {

    private static PDFManager pdfManager;
   

    private PDFManager() {
    }

    public static PDFManager getPDFManager() {
        if (pdfManager == null) {
            pdfManager = new PDFManager();
        }
        return pdfManager;

    }

    public boolean gravarPDF(File arquivo, String diretorio, String titulo) {
        OutputStream out;
        try {
            out = new FileOutputStream(diretorio + "/" + titulo + ".pdf");
            out.write(fileToByte(arquivo));
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public byte[] fileToByte(File arquivo)  {
        FileInputStream fis = null;  
        try {
            fis = new FileInputStream(arquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        byte[] buffer = new byte[8192];  
        int bytesRead = 0;  
        try {
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {  
                baos.write(buffer, 0, bytesRead);  
            }
        } catch (IOException ex) {
            Logger.getLogger(PDFManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return baos.toByteArray();  
    }
//    public static byte[] getFileBytes(File file) throws IOException {
//        ByteArrayOutputStream ous = null;
//        InputStream ios = null;
//        try {
//            byte[] buffer = new byte[4096];
//            ous = new ByteArrayOutputStream();
//            ios = new FileInputStream(file);
//            int read = 0;
//            while ((read = ios.read(buffer)) != -1) {
//                ous.write(buffer, 0, read);
//            }
//        } finally {
//            try {
//                if (ous != null) {
//                    ous.close();
//                }
//            } catch (IOException e) {
//                // swallow, since not that important
//            }
//            try {
//                if (ios != null) {
//                    ios.close();
//                }
//            } catch (IOException e) {
//                // swallow, since not that important
//            }
//        }
//        return ous.toByteArray();
//    }

    public boolean gravarPDF(byte[] arquivoByte, String diretorio, String titulo) {
        OutputStream out;
        try {
            out = new FileOutputStream(diretorio + "/" + titulo + ".pdf");
            out.write(arquivoByte);
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
