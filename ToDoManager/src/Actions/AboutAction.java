package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.AboutFrame;

/**
 * Creates the info window that displays some info about the application
 * @author Kristian
 */
public class AboutAction extends AbstractAction{
    private final AboutFrame frame = new AboutFrame();
    
    public AboutAction(String text){     
        super(text);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.frame.setVisible(true);
    }
    
}
