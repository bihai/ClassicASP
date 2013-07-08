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
    private static List<ASPTokenId> tokens;
    private static Map<Integer, ASPTokenId> idToToken;
    
    private static void init()
    {
        tokens = Arrays.<ASPTokenId>asList(new ASPTokenId[]{
            new ASPTokenId("EOF", "whitespace", 0),
            new ASPTokenId("WHITESPACE", "whitespace", 1),
            new ASPTokenId("SINGLE_LINE_COMMENT", "comment", 4)
        });
        
        idToToken = new HashMap<Integer, ASPTokenId>();
        for(ASPTokenId token : tokens)
        {
            idToToken.put(token.ordinal(), token);
        }
    }
    
    static synchronized ASPTokenId getToken(int id)
    {
        if(idToToken == null)
            init();
        
        return idToToken.get(id);
    }
    
    @Override
    protected synchronized Collection<ASPTokenId> createTokenIds()
    {
        if(tokens == null)
            init();
        
        return tokens;
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
