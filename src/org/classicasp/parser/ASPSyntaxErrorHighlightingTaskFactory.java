/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classicasp.parser;
import java.util.Collection;
import java.util.Collections;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.TaskFactory;
/**
 *
 * @author mobrien
 */
@MimeRegistration(mimeType="text/x-asp", service=TaskFactory.class)
public class ASPSyntaxErrorHighlightingTaskFactory extends TaskFactory
{
    @Override
    public Collection create(Snapshot snapshot)
    {
        return Collections.singleton(new ASPSyntaxErrorHighlightingTask());
    }
}
