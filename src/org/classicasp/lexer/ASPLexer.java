/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classicasp.lexer;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.classicasp.jcclexer.JavaCharStream;
import org.classicasp.jcclexer.JavaParserTokenManager;
import org.classicasp.jcclexer.Token;

/**
 *
 * @author mobrien
 */
class ASPLexer implements Lexer<ASPTokenId>
{
    private LexerRestartInfo<ASPTokenId> info;
    private JavaParserTokenManager javaParserTokenManager;
    
    ASPLexer(LexerRestartInfo<ASPTokenId> info)
    {
        this.info = info;
        JavaCharStream stream = new JavaCharStream(info.input());
        javaParserTokenManager = new JavaParserTokenManager(stream);
    }
    
    @Override
    public org.netbeans.api.lexer.Token<ASPTokenId> nextToken()
    {
        Token token = javaParserTokenManager.getNextToken();
        if(info.input().readLength() < 1)
        {
            return null;
        }
        
        return info.tokenFactory().createToken(ASPLanguageHierarchy.getToken(token.kind));
    }
    
    @Override
    public Object state()
    {
        return null;
    }
    
    @Override
    public void release()
    {
    }
}
