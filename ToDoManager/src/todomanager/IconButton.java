package todomanager;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Kristian
 */
public class IconButton extends JButton{
    
    private File picture;
    private Image icon;
    
    public IconButton(AbstractAction action,String path){
        super(action);
        picture = new File(path);
        this.setLayout(null);
        this.setSize(20,20);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        
        try{
            icon = ImageIO.read(picture);           
        }
        catch(IOException e){
            System.err.println("Image not found");
        }
        
        //Resize the image to fit the button
        Image newImg = icon.getScaledInstance((int)this.getSize().getWidth(),
        (int)this.getSize().getHeight(), java.awt.Image.SCALE_SMOOTH);
        
        this.setIcon(new ImageIcon(newImg));                
    }
}
