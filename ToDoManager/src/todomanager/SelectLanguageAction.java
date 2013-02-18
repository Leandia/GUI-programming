package todomanager;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;

/**
 * Not sure this is how you should use actions but it works..
 * @author Kristian
 */
public class SelectLanguageAction extends AbstractAction {
    
    private String selectedLanguage;
    private JComboBox select;
    
    public SelectLanguageAction(JComboBox selection, String string){
        this.selectedLanguage = string;
        this.select = selection;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
         setSelectedLanguage();
         TODOManager.manager.UpdateLanguage(selectedLanguage); }

    private void setSelectedLanguage() {
        this.selectedLanguage = this.select.getSelectedItem().toString();
    }
        
}
