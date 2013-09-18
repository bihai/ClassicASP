/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classicasp.lexer;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author mobrien
 */
class ASPLexer implements Lexer<ASPTokenId>
{
    private LexerRestartInfo<ASPTokenId> info;
    private LexerInput input;
    
    ASPLexer(LexerRestartInfo<ASPTokenId> info)
    {
        this.info = info;
        this.input = info.input();
    }
    
    @Override
    public Token<ASPTokenId> nextToken()
    {
        while(true)
        {
            int ch = input.read();
            switch(ch)
            {
                default:
                    return token(ASPTokenId.WHITESPACE);
            }
        }
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
    
    private Token<ASPTokenId> token(ASPTokenId id)
    {
        return info.tokenFactory().createToken(id);
    }
}
