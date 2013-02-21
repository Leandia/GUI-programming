/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Emil
 */
public class QuitAction extends AbstractAction {
        public QuitAction(String text,String desc) {
            super(text);
            putValue(SHORT_DESCRIPTION, desc);
            }
        public void actionPerformed(ActionEvent e) {
            System.err.println("Quit!");
            System.exit(0);
        }
    }
