package org.classicasp;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.classicasp.lexer.ASPTokenId;

/**
 *
 * @author mobrien
 */
@LanguageRegistration(mimeType = "text/x-asp")
public class ASPLanguage extends DefaultLanguageConfig
{
    @Override
    public Language getLexerLanguage()
    {
        return ASPTokenId.getLanguage();
    }
    
    @Override
    public String getDisplayName()
    {
        return "ASP";
    }
}
