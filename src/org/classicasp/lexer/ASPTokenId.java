/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classicasp.lexer;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.Language;

/**
 *
 * @author mobrien
 */
public class ASPTokenId implements TokenId
{
    private final String name;
    private final String primaryCategory;
    private final int id;
    
    ASPTokenId(String name, String primaryCategory, int id)
    {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }
    
    @Override
    public String primaryCategory()
    {
        return primaryCategory;
    }
    
    @Override
    public int ordinal()
    {
        return id;
    }
    
    @Override
    public String name()
    {
        return name;
    }
    
    public static Language<ASPTokenId>getLanguage()
    {
        return new ASPLanguageHierarchy().language();
    }
}
