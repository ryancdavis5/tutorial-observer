package observer2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

public abstract class ColorPanel extends JPanel implements ChangeListener {
    private Color color;
    protected JSlider brightness;
    protected JSlider hue;
    protected JSlider saturation;

    public ColorPanel(Color initialColor, JSlider saturation, JSlider hue, JSlider brightness) {
        this.color = initialColor;
        this.brightness = brightness;
        this.saturation = saturation;
        this.hue = hue;
        hue.addChangeListener(this);
        saturation.addChangeListener(this);
        brightness.addChangeListener(this);
    }

    public void setColor(Color newColor) {
        this.color = newColor;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        this.setBackground(color);
        super.paintComponent(g);
    }

    public abstract void stateChanged(ChangeEvent e);
}