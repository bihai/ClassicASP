/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classicasp.lexer;

import java.util.*;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author mobrien
 */
public class ASPLanguageHierarchy extends LanguageHierarchy<ASPTokenId>
{
    @Override
    protected synchronized Collection<ASPTokenId> createTokenIds()
    {
        return Arrays.asList(ASPTokenId.values());
    }
    
    @Override
    protected synchronized Lexer<ASPTokenId> createLexer(LexerRestartInfo<ASPTokenId> info)
    {
        return new ASPLexer(info);
    }
    
    @Override
    protected String mimeType()
    {
        return "text/x-asp";
    }
}
