package org.classicasp.lexer;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.Language;
import org.netbeans.spi.lexer.LexerRestartInfo;
import java.util.*;

/**
 *
 * @author mobrien
 */
public enum ASPTokenId implements TokenId
{
    ERROR(null, "error"),
    FLOAT_LITERAL(null, "number"),
    INT_LITERAL(null, "number"),
    OPERATOR(null, "operator"),
    SLASH(null, "operator"),
    SEMICOLON(null, "operator"),
    LBRACE(null, "operator"),
    RBRACE(null, "operator"),
    LPAREN(null, "operator"),
    RPAREN(null, "operator"),
    SL_COMMENT(null, "comment"),
    WHITESPACE(null, "whitespace"),
    IDENTIFIER(null, "identifier"),
    KEYWORD(null, "keyword"),
    ML_COMMENT_INCOMPLETE(null, "comment")
    ;
    
    private final String fixedText;
    private final String primaryCategory;
    
    private ASPTokenId(String fixedText, String primaryCategory)
    {
        this.fixedText = fixedText;
        this.primaryCategory = primaryCategory;
    }
    
    public String primaryCategory()
    {
        return primaryCategory;
    }
    
    public String fixedText()
    {
        return fixedText;
    }
    
    private static final Language<ASPTokenId> language = new ASPLanguageHierarchy()
    {
        @Override
        protected Collection<ASPTokenId> createTokenIds()
        {
            return EnumSet.allOf(ASPTokenId.class);
        }
        
        @Override
        protected Map<String,Collection<ASPTokenId>> createTokenCategories()
        {
            Map <String, Collection<ASPTokenId>> cats = new HashMap<String, Collection<ASPTokenId>>();
            // Incomplete literals
            cats.put("incomplete", EnumSet.of(ASPTokenId.ML_COMMENT_INCOMPLETE));
            // Additional literals being a lexical error
            cats.put("error", EnumSet.of(ASPTokenId.ML_COMMENT_INCOMPLETE));
            
            return cats;
        }
                
        @Override
        protected Lexer<ASPTokenId> createLexer(LexerRestartInfo<ASPTokenId> info)
        {
            return new ASPLexer(info);
        }
        
        @Override
        protected String mimeType()
        {
            return "text/x-asp";
        }
        
    }.language();
    
    public static final Language<ASPTokenId> getLanguage()
    {
        return language;
    }
}
