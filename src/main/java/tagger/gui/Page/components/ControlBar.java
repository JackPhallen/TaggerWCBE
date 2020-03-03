package tagger.gui.Page.components;

import tagger.gui.Properties;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ControlBar extends JPanel {

    public ControlBar() {
        this.setLayout(new BorderLayout());
        this.setBorder(new EtchedBorder());
        this.setPreferredSize(new Dimension(100, Properties.CONTROL_HEIGHT));
        JLabel label = new JLabel("TEST");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add( label, BorderLayout.WEST );
    }
}
