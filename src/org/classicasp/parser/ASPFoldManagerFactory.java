package org.classicasp.parser;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.fold.FoldManager;
import org.netbeans.spi.editor.fold.FoldManagerFactory;

/**
 *
 * @author mobrien
 */
@MimeRegistration(mimeType="text/x-asp", service=FoldManagerFactory.class)
public class ASPFoldManagerFactory implements FoldManagerFactory
{
    @Override
    public FoldManager createFoldManager() 
    {
        return new ASPFoldManager();
    }
}
