/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classicasp.parser;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;


/**
 *
 * @author mobrien
 */
public class ASPParser extends Parser
{
    private Snapshot snapshot;
    private JavaParser javaParser;
    
    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event)
    {
        this.snapshot = snapshot;
        Reader reader = new StringReader(snapshot.getText().toString());
        javaParser = new JavaParser(reader);
        try
        {
            javaParser.CompilationUnit();
        }
        catch(org.classicasp.jccparser.ParseException ex)
        {
            Logger.getLogger(ASPParser.class.getName()).log (Level.WARNING, null, ex);
        }
    }
    
    @Override
    public Result getResult(Task task)
    {
        return new ASPParserResult(snapshot, javaParser);
    }
    
    @Override
    public void cancel(){}
    
    @Override
    public void addChangeListener(ChangeListener changeListener)
    {
        
    }
    
    @Override
    public void removeChangeListener(ChangeListener changeListener)
    {
    }
    
    public static class ASPParserResult extends Result
    {
        private JavaParser javaParser;
        private boolean valid = true;
        
        ASPParserResult (Snapshot snapshot, JavaParser javaParser)
        {
            super(snapshot);
            this.javaParser = javaParser;
        }
        
        public JavaParser getJavaParser() throws org.netbeans.modules.parsing.spi.ParseException
        {
            if(!valid) throw new org.netbeans.modules.parsing.spi.ParseException();
            
            return javaParser;
        }
        
        @Override
        protected void invalidate()
        {
            valid = false;
        }
    }
            
}
