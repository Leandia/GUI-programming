package CustomComponents;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Panel for displaying an image. It draws the image straight on the panel, 
 * below any items added to the panel.
 * @author Daniel
 */
public class ImagePanel extends JPanel {

    private BufferedImage image = null;

    public ImagePanel() {
    }

    /**
     * Method to set the image to be drawn on the panel.
     * @param address A valid address to an image.
     */
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
