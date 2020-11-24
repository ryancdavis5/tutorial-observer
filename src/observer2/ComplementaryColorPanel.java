package observer2;

import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class ComplementaryColorPanel extends ColorPanel {

    public ComplementaryColorPanel(Color initialColor, JSlider saturation, JSlider hue, JSlider brightness) {
        super(initialColor, saturation, hue, brightness);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (hue != null && saturation != null && brightness  != null) {
            float newSaturation = (float) saturation.getValue() / 100;
            float newHue = (float) hue.getValue() / 100;
            float newBrightness = (float) brightness.getValue() / 100;
            float complementaryHue = newHue - (float) 0.5;
            if (complementaryHue < 0) {
                complementaryHue = complementaryHue + 1;
            }
            Color color = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
            this.setColor(color);
        }
    }
}