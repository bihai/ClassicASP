package org.classicasp;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;
import org.classicasp.lexer.ASPTokenId;
import org.classicasp.parser.ASPParser;


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
    
    @Override
    public Parser getParser()
    {
        return new ASPParser();
    }
}
