package observer2;

import javax.swing.*;
import java.awt.*;

public class DisplayColors {

    public static void main(String[] args) {
        SwingFacade.launch(new DisplayColors().mainPanel(), "Compute Complementary Colors");
    }

    protected ColorPanel originalColorPanel;
    protected ColorPanel complementaryColorPanel;

    protected JSlider hueSlider;
    protected JSlider saturationSlider;
    protected JSlider brightnessSlider;

    protected JLabel hueValueLabel;
    protected JLabel saturationValueLabel;
    protected JLabel brightnessValueLabel;

    protected JPanel colorsPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));
        originalColorPanel = new OriginalColorPanel(Color.getHSBColor(0, (float) .5, (float) .5), saturationSlider, hueSlider, brightnessSlider);
        originalColorPanel.setPreferredSize(new Dimension(300, 200));
        p.add(SwingFacade.createTitledPanel("Original Color", originalColorPanel));
        complementaryColorPanel = new ComplementaryColorPanel(Color.getHSBColor((float) .5, (float) .5, (float) .5), saturationSlider, hueSlider, brightnessSlider);
        complementaryColorPanel.setPreferredSize(new Dimension(300, 200));
        p.add(SwingFacade.createTitledPanel("Complementary Color", complementaryColorPanel));

        return p;
    }

    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        JPanel subP = new JPanel();
        subP.setLayout(new GridLayout(3, 1));
        hueSlider = slider();
        subP.add(sliderBox("H", hueSlider, hueValueLabel));
        saturationSlider = slider();
        saturationSlider.setValue(50);
        subP.add(sliderBox("S", saturationSlider, saturationValueLabel));
        brightnessSlider = slider();
        brightnessSlider.setValue(50);
        subP.add(sliderBox("B", brightnessSlider, brightnessValueLabel));
        p.add(subP);
        JPanel colorsPanel = colorsPanel();
        p.add(colorsPanel);
        return p;

    }

    private JSlider slider() {
        JSlider slider = new JSlider();
        slider.setValue(slider.getMinimum());
        return slider;
    }

    private Box sliderBox(String sliderLabel, JSlider slider, JLabel valueLabel) {
        if (valueLabel == null) {
            valueLabel = new JLabel();
            valueLabel.setFont(SwingFacade.getStandardFont());
            valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            valueLabel.setForeground(java.awt.Color.black);
        }
        Box b = Box.createHorizontalBox();
        JLabel label = new JLabel(sliderLabel);
        label.setFont(SwingFacade.getStandardFont());
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        label.setForeground(java.awt.Color.black);
        b.add(label);
        b.add(valueLabel);
        b.add(slider);
        b.setPreferredSize(new Dimension(600, 50));
        return b;
    }

}