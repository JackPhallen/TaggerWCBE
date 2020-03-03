package tagger.gui.TokenizerTab;

import tagger.gui.Page.components.ButtonPanel;
import tagger.gui.Properties;

import javax.swing.*;
import java.awt.*;

/**
 * Component containing high hand buttons on TokenizerPage
 */
public class TokenButtonPanel extends ButtonPanel {

    public TokenButtonPanel() {
        this.add( this.buildClearButton() );
        this.add( this.buildSpinner() );
    }

    private JButton buildClearButton() {
        JButton button = new JButton("Clear Input");
        TokenizeMediator.getInstance().setClearTextButton( button );
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }



    /**
     * Create spinner to set threshold of tokenizer
     * @return threshold spinner instance
     */
    private JPanel buildSpinner() {
        JLabel label = new JLabel("Set Threshold:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(label);
        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(null);
        spinnerPanel.setPreferredSize( new Dimension(30, 30) );
        JSpinner spinner = new JSpinner(
                new SpinnerNumberModel(0, 0, 20, 1)
        );
        TokenizeMediator.getInstance().setThresholdSpinner( spinner );
        spinner.setBounds(5, 0, Properties.BUTTON_PANEL_WIDTH - 10, 30);
        spinnerPanel.add( spinner );
        return spinnerPanel;
    }
}
