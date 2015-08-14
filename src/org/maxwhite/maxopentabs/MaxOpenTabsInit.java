/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maxwhite.maxopentabs;
import org.netbeans.api.editor.EditorRegistry;
import org.openide.modules.ModuleInstall;
import org.openide.windows.OnShowing;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author mabe
 */
@OnShowing
public class MaxOpenTabsInit extends ModuleInstall implements Runnable {

    @Override
    public void run() {
       WindowManager wm = WindowManager.getDefault();
       TopComponent.Registry reg = TopComponent.getRegistry();
       MaxOpenTabsPropertyChangeListener pl = new MaxOpenTabsPropertyChangeListener();
       EditorRegistry.addPropertyChangeListener(pl);
    }
    
}
