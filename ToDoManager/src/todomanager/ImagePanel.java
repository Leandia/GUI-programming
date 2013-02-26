package todomanager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class ImagePanel extends JPanel {

    private BufferedImage image = null;

    public ImagePanel() {
    }

    public void setPicture(String address) {
        try {
            image = ImageIO.read(new File(address));
        } catch (IOException ex) {
            System.err.println("Image not found");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.image != null) {
            g.drawImage(image, 25, 5, null);
        }
    }
}
