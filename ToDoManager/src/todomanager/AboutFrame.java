package todomanager;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Creates a window that displays info about the application.
 * @author Kristian
 */
public class AboutFrame extends JFrame{

    private final String[] authors = {"Kristian Johansson","Vita Ivanova", "Kristoffer Wass", "Emil Björling", "Daniel Gustavsson"};
    private final String text = "Authors: ";
    /**
     *
     */
    public AboutFrame() {
        super("About");
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(200,200));
        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
        pane.add(new JLabel(text));
        
        for(int i=0;i<this.authors.length;i++){
            pane.add(new JLabel(this.authors[i]));
        }
        setResizable(false);
        pack();
    }
    
}
