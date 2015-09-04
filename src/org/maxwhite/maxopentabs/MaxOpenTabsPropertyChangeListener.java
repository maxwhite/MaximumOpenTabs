/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maxwhite.maxopentabs;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.modules.editor.NbEditorUtilities;
import org.openide.util.NbPreferences;
import org.openide.windows.WindowManager;

/**
 *
 * @author mabe
 */
class MaxOpenTabsPropertyChangeListener implements PropertyChangeListener {
    private int MAX_OPENED_TABS;
   
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        MAX_OPENED_TABS = NbPreferences.forModule(MaximOpenTabsPanel.class).getInt(MaximOpenTabsPanel.MAX_OPEN_TABS_STORE_KEY , MaximOpenTabsPanel.MAX_OPEN_TABS_NUMBER_DEFAULT);
        if( pce.getPropertyName().equalsIgnoreCase("focusGained") ) {
            WindowManager wm  = WindowManager.getDefault();
            List<? extends JTextComponent> editorComponents =  EditorRegistry.componentList();
            while (editorComponents.size() > MAX_OPENED_TABS) {
                NbEditorUtilities.getOuterTopComponent(editorComponents.get(editorComponents.size()-1)).close();
            }
        }
    }
}
