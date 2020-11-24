package observer3;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener {
    public ComplementaryColorPanel(Color initialColor){
        super(initialColor);
        DisplayColors.originalColorPanel.addPropertyChangeListener(this);

    }

    public void update(float newHue, float newSaturation, float newBrightness){
        float complementaryHue = newHue - (float) 0.5;
        if (complementaryHue < 0) {
            complementaryHue += 1;
        }
        Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
        this.setColor(complementaryColor);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Color originalColor = DisplayColors.originalColorPanel.getColor();
        float[] hsb = Color.RGBtoHSB(originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue(), null);
        update(hsb[0], hsb[1], hsb[2]);
    }

}