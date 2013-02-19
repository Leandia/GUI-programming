/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author EIS i7 Gamer
 */
public class LeftAction extends AbstractAction {
        public LeftAction(String text,String desc) {
            super(text);
            putValue(SHORT_DESCRIPTION, desc);
            }
        public void actionPerformed(ActionEvent e) {
            System.err.println("Quit!");
            System.exit(0);
        }
    }
