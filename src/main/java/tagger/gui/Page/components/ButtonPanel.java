package tagger.gui.Page.components;

import tagger.gui.Properties;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ButtonPanel extends JPanel {

    public ButtonPanel() {
        this.setBorder(new CompoundBorder(
                new EtchedBorder(),
                new EmptyBorder( Properties.CONTROL_HEIGHT, 0, 0, 0))
                );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize( new Dimension(Properties.BUTTON_PANEL_WIDTH, 100));
    }
}
