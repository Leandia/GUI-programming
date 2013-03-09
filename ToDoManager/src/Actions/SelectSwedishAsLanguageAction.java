/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.TODOManager;

/**
 * Action for selecting Swedish as language
 * @author Kristian
 */
public class SelectSwedishAsLanguageAction extends AbstractAction{
         
        /**
         * Hard coded representation of the language
         */
         private final String swe = "Swedish";
         
         public SelectSwedishAsLanguageAction(String text){
             super(text);
         }

        @Override
        public void actionPerformed(ActionEvent ae) {
            TODOManager.savedSettings.setSelectedLanguage(swe);
            TODOManager.manager.UpdateLanguage(swe);
        }
     }
