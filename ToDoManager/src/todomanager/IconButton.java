package todomanager;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Button class that allows for customize the icon showed, the rest of the
 * button is hidden.
 *
 * @author Kristian
 */
public class IconButton extends JButton {

    private File picture;
    private Image icon;

    
    /**
     * Constructor that also adds a action to the button, also provides a
     * file path
     * @param action
     * @param path 
     */
    public IconButton(AbstractAction action, String path) {
        //Add action to the button
        super(action);

        // Set the image to the button.
        setImage(path);
    }

    /**
     * Constructor that takes a string representation of the file path
     * @param path 
     */
    public IconButton(String path) {
        this(null, path);
    }

    /**
     * Default constructor
     */
    public IconButton() {
    }

    /**
     * Sets the icon if not set previously.
     * @param path Path to the image file
     */
    public void setImage(String path) {
        //Create a new file to retrieve the pic from
        picture = new File(path);

        //Set size and hide the usual button display
        this.setLayout(null);
        this.setSize(20, 20);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        try {
            icon = ImageIO.read(picture);
        } catch (IOException e) {
            System.err.println("Image not found");
        }

        //Resize the image to fit the button
        Image newImg = icon.getScaledInstance((int) this.getSize().getWidth(),
                (int) this.getSize().getHeight(), java.awt.Image.SCALE_SMOOTH);

        this.setIcon(new ImageIcon(newImg));
    }
}
