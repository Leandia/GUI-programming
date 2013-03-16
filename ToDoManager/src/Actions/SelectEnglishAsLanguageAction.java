package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.TODOManager;

/**
 * Action for selecting English as language
 * @author Kristian
 */
public class SelectEnglishAsLanguageAction extends AbstractAction{
         
        /**
         * Hard coded representation of the language
         */
         private final String eng = "English";
         
         public SelectEnglishAsLanguageAction(String text){
             super(text);
         }

        @Override
        public void actionPerformed(ActionEvent ae) {
            TODOManager.savedSettings.setSelectedLanguage(eng);
            TODOManager.manager.UpdateLanguage(eng);
        }
    
}
