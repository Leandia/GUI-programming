package todomanager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

/**
 * Theme for the ToDoManager
 *
 * @author Daniel
 */
public class Theme extends DefaultMetalTheme {

    // Menu text color
    private ColorUIResource primary1 = new ColorUIResource(Color.decode("#000000"));
    // scrollbar and menu select color
    private ColorUIResource primary2 = new ColorUIResource(Color.decode("#72B7F0"));
    // List select
    private ColorUIResource primary3 = new ColorUIResource(Color.decode("#B1BDC4"));
    // Border color
    private ColorUIResource secondary1 = new ColorUIResource(Color.decode("#B1BDC4"));
    // unselected tab
    private ColorUIResource secondary2 = new ColorUIResource(Color.decode("#FFEC7C"));
    // Background
    private ColorUIResource secondary3 = new ColorUIResource(Color.decode("#D9CFAD"));
    // menu background
    private ColorUIResource background = new ColorUIResource(Color.decode("#EFD993"));
    // get white
    private ColorUIResource white = new ColorUIResource(Color.decode("#B8A562"));
    // Font1
    private FontUIResource font1 = new FontUIResource(Font.MONOSPACED, Font.HANGING_BASELINE, 18);
    // Font2
    private FontUIResource font2 = new FontUIResource(Font.SANS_SERIF, Font.CENTER_BASELINE, 12);

    public Theme() {
        super();
    }

    /**
     * Menu text color, primary1.
     *
     * @return
     */
    @Override
    protected ColorUIResource getPrimary1() {
        return primary1;
    }

    /**
     * Scrollbar and menu select color, primary2.
     *
     * @return
     */
    @Override
    protected ColorUIResource getPrimary2() {
        return primary2;
    }

    /**
     * The color of a selected item in the list, primary3.
     *
     * @return
     */
    @Override
    protected ColorUIResource getPrimary3() {
        return primary3;
    }

    /**
     * Color of borders, secondary 1.
     *
     * @return
     */
    @Override
    protected ColorUIResource getSecondary1() {
        return secondary1;
    }

    /**
     * Color of unselected tabs, secondary 2.
     *
     * @return
     */
    @Override
    protected ColorUIResource getSecondary2() {
        return secondary2;
    }

    /**
     * Window background, secondary 3.
     *
     * @return
     */
    @Override
    protected ColorUIResource getSecondary3() {
        return secondary3;
    }

    /**
     * Menu and textField background.
     *
     * @return
     */
    @Override
    public ColorUIResource getWindowBackground() {
        return background;
    }

    /**
     * Get set white color.
     *
     * @return
     */
    @Override
    protected ColorUIResource getWhite() {
        return white;
    }

    /**
     * Return white color.
     *
     * @return
     */
    @Override
    public ColorUIResource getMenuBackground() {
        return getWhite();
    }

    /**
     * The user text input font.
     *
     * @return
     */
    @Override
    public FontUIResource getUserTextFont() {
        return font2;
    }

    @Override
    public FontUIResource getSystemTextFont() {
        return font1;
    }

    @Override
    public FontUIResource getSubTextFont() {
        return font2;
    }
    
    @Override
    public FontUIResource getWindowTitleFont() {
        return font1;
    }
    
    /**
     * The font in the tabs, on the panels and in the warning popups.
     * @return 
     */
    @Override
    public FontUIResource getControlTextFont() {
        return font2;
    }
}
