package tagger.gui.StopWordsTab;

import tagger.gui.Page.components.ButtonPanel;
import tagger.gui.StopWordsTab.Actions.EditWordsAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StopButtonPanel extends ButtonPanel {

    public StopButtonPanel() {
        this.add( this.buildDeleteButton() );
        this.add( this.buildImportButton() );
    }

    private JButton buildDeleteButton() {
        StopMediator mediator = StopMediator.getInstance();
        JButton button = new JButton("Delete Selected");
        mediator.setDeleteButton( button );
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(new EditWordsAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.removeSelected();
            }
        });
        return button;
    }

    private JButton buildImportButton() {
        JButton button = new JButton("Import File");
        button.setEnabled(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }


}
