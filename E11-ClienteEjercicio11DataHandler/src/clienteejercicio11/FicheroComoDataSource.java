/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clienteejercicio11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;

/**
 *
 * @author aad
 */
public class FicheroComoDataSource implements DataSource {
    private File m_oFile;
    private String m_sContentType;
    
    public FicheroComoDataSource(String sContentType, File oFichero) {
        this.m_oFile = oFichero;
        this.m_sContentType = sContentType;
    }


    public InputStream getInputStream() throws IOException {
        return new FileInputStream(m_oFile);
    }


    public OutputStream getOutputStream() throws IOException {
        return new FileOutputStream(m_oFile);
    }


    public String getContentType() {
        return m_sContentType;
    }


    public String getName() {
        return this.getClass().getName();
    }

}
