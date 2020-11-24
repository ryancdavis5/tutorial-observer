package observer2;

import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class OriginalColorPanel extends ColorPanel {

    public OriginalColorPanel(Color initialColor, JSlider saturation, JSlider hue, JSlider brightness) {
        super(initialColor, saturation, hue, brightness);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (hue != null && saturation != null && brightness != null) {
            float newSaturation = (float) saturation.getValue() / 100;
            float newHue = (float) hue.getValue() / 100;
            float newBrightness = (float) brightness.getValue() / 100;
            Color color = Color.getHSBColor(newHue, newSaturation, newBrightness);
            this.setColor(color);
        }

    }


}