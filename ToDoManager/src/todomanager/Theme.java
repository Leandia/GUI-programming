package todomanager;

import java.awt.Color;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

/**
 *
 * @author Daniel
 */
public class Theme extends DefaultMetalTheme {

    private String p1 = "#FFFFFF";
    private ColorUIResource primary1 = new ColorUIResource(Color.decode(p1));

    public Theme() {
        super();
    }

    @Override
    protected ColorUIResource getPrimary1() {
        return primary1;
    }
    @Override
    protected ColorUIResource getPrimary2() {
        return primary1;
    }
    @Override
    protected ColorUIResource getPrimary3() {
        return primary1;
    }
    
    
}
