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
            new ASPTokenId("SINGLE_LINE_COMMENT", "comment", 4),
            new ASPTokenId("FORMAL_COMMENT", "comment", 5),
            new ASPTokenId("MULTI_LINE_COMMENT", "comment", 6),
            new ASPTokenId("ABSTRACT", "keyword", 8),
            new ASPTokenId("ASSERT", "keyword", 9),
            new ASPTokenId("BOOLEAN", "keyword", 10),
            new ASPTokenId("BREAK", "keyword", 11),
            new ASPTokenId("BYTE", "keyword", 12),
            new ASPTokenId("CASE", "keyword", 13),
            new ASPTokenId("CATCH", "keyword", 14),
            new ASPTokenId("CHAR", "keyword", 15),
            new ASPTokenId("CLASS", "keyword", 16),
            new ASPTokenId("CONST", "keyword", 17),
            new ASPTokenId("CONTINUE", "keyword", 18),
            new ASPTokenId("_DEFAULT", "keyword", 19),
            new ASPTokenId("DO", "keyword", 20),
            new ASPTokenId("DOUBLE", "keyword", 21),
            new ASPTokenId("ELSE", "keyword", 22),
            new ASPTokenId("ENUM", "keyword", 23),
            new ASPTokenId("EXTENDS", "keyword", 24),
            new ASPTokenId("FALSE", "keyword", 25),
            new ASPTokenId("FINAL", "keyword", 26),
            new ASPTokenId("FINALLY", "keyword", 27),
            new ASPTokenId("FLOAT", "keyword", 28),
            new ASPTokenId("FOR", "keyword", 29),
            new ASPTokenId("GOTO", "keyword", 30),
            new ASPTokenId("IF", "keyword", 31),
            new ASPTokenId("IMPLEMENTS", "keyword", 32),
            new ASPTokenId("IMPORT", "keyword", 33),
            new ASPTokenId("INSTANCEOF", "keyword", 34),
            new ASPTokenId("INT", "keyword", 35),
            new ASPTokenId("INTERFACE", "keyword", 36),
            new ASPTokenId("LONG", "keyword", 37),
            new ASPTokenId("NATIVE", "keyword", 38),
            new ASPTokenId("NEW", "keyword", 39),
            new ASPTokenId("NULL", "keyword", 40),
            new ASPTokenId("PACKAGE", "keyword", 41),
            new ASPTokenId("PRIVATE", "keyword", 42),
            new ASPTokenId("PROTECTED", "keyword", 43),
            new ASPTokenId("PUBLIC", "keyword", 44),
            new ASPTokenId("RETURN", "keyword", 45),
            new ASPTokenId("SHORT", "keyword", 46),
            new ASPTokenId("STATIC", "keyword", 47),
            new ASPTokenId("STRICTFP", "keyword", 48),
            new ASPTokenId("SUPER", "keyword", 49),
            new ASPTokenId("SWITCH", "keyword", 50),
            new ASPTokenId("SYNCHRONIZED", "keyword", 51),
            new ASPTokenId("THIS", "keyword", 52),
            new ASPTokenId("THROW", "keyword", 53),
            new ASPTokenId("THROWS", "keyword", 54),
            new ASPTokenId("TRANSIENT", "keyword", 55),
            new ASPTokenId("TRUE", "keyword", 56),
            new ASPTokenId("TRY", "keyword", 57),
            new ASPTokenId("VOID", "keyword", 58),
            new ASPTokenId("VOLATILE", "keyword", 59),
            new ASPTokenId("WHILE", "keyword", 60),
            new ASPTokenId("INTEGER_LITERAL", "literal", 61),
            new ASPTokenId("DECIMAL_LITERAL", "literal", 62),
            new ASPTokenId("HEX_LITERAL", "literal", 63),
            new ASPTokenId("OCTAL_LITERAL", "literal", 64),
            new ASPTokenId("FLOATING_POINT_LITERAL", "literal", 65),
            new ASPTokenId("DECIMAL_FLOATING_POINT_LITERAL", "literal", 66),
            new ASPTokenId("DECIMAL_EXPONENT", "number", 67),
            new ASPTokenId("HEXADECIMAL_FLOATING_POINT_LITERAL", "literal", 68),
            new ASPTokenId("HEXADECIMAL_EXPONENT", "number", 69),
            new ASPTokenId("CHARACTER_LITERAL", "literal", 70),
            new ASPTokenId("STRING_LITERAL", "literal", 71),
            new ASPTokenId("IDENTIFIER", "identifier", 72),
            new ASPTokenId("LETTER", "literal", 73),
            new ASPTokenId("PART_LETTER", "literal", 74),
            new ASPTokenId("LPAREN", "operator", 75),
            new ASPTokenId("RPAREN", "operator", 76),
            new ASPTokenId("LBRACE", "operator", 77),
            new ASPTokenId("RBRACE", "operator", 78),
            new ASPTokenId("LBRACKET", "operator", 79),
            new ASPTokenId("RBRACKET", "operator", 80),
            new ASPTokenId("SEMICOLON", "operator", 81),
            new ASPTokenId("COMMA", "operator", 82),
            new ASPTokenId("DOT", "operator", 83),
            new ASPTokenId("AT", "operator", 84),
            new ASPTokenId("ASSIGN", "operator", 85),
            new ASPTokenId("LT", "operator", 86),
            new ASPTokenId("BANG", "operator", 87),
            new ASPTokenId("TILDE", "operator", 88),
            new ASPTokenId("HOOK", "operator", 89),
            new ASPTokenId("COLON", "operator", 90),
            new ASPTokenId("EQ", "operator", 91),
            new ASPTokenId("LE", "operator", 92),
            new ASPTokenId("GE", "operator", 93),
            new ASPTokenId("NE", "operator", 94),
            new ASPTokenId("SC_OR", "operator", 95),
            new ASPTokenId("SC_AND", "operator", 96),
            new ASPTokenId("INCR", "operator", 97),
            new ASPTokenId("DECR", "operator", 98),
            new ASPTokenId("PLUS", "operator", 99),
            new ASPTokenId("MINUS", "operator", 100),
            new ASPTokenId("STAR", "operator", 101),
            new ASPTokenId("SLASH", "operator", 102),
            new ASPTokenId("BIT_AND", "operator", 103),
            new ASPTokenId("BIT_OR", "operator", 104),
            new ASPTokenId("XOR", "operator", 105),
            new ASPTokenId("REM", "operator", 106),
            new ASPTokenId("LSHIFT", "operator", 107),
            new ASPTokenId("PLUSASSIGN", "operator", 108),
            new ASPTokenId("MINUSASSIGN", "operator", 109),
            new ASPTokenId("STARASSIGN", "operator", 110),
            new ASPTokenId("SLASHASSIGN", "operator", 111),
            new ASPTokenId("ANDASSIGN", "operator", 112),
            new ASPTokenId("ORASSIGN", "operator", 113),
            new ASPTokenId("XORASSIGN", "operator", 114),
            new ASPTokenId("REMASSIGN", "operator", 115),
            new ASPTokenId("LSHIFTASSIGN", "operator", 116),
            new ASPTokenId("RSIGNEDSHIFTASSIGN", "operator", 117),
            new ASPTokenId("RUNSIGNEDSHIFTASSIGN", "operator", 118),
            new ASPTokenId("ELLIPSIS", "operator", 119),
            new ASPTokenId("RUNSIGNEDSHIFT", "operator", 120),
            new ASPTokenId("RSIGNEDSHIFT", "operator", 121),
            new ASPTokenId("GT", "operator", 122)
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
