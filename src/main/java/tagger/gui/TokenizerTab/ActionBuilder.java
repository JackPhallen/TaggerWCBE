package tagger.gui.TokenizerTab;


import tagger.gui.TokenizerTab.Actions.*;

import java.awt.event.ActionEvent;

public class ActionBuilder {

    public static void buildActions() {
        TokenizeMediator mediator = TokenizeMediator.getInstance();

        mediator.getNextButton().addActionListener(new TokenNavAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.next(e);
            }
        });
        mediator.getBackButton().addActionListener(new TokenNavAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.back(e);
            }
        });

        mediator.getClearTextButton().addActionListener(new TokenizeAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.mediator.getInputPage().setText("");
            }
        });

        mediator.getThresholdSpinner().addChangeListener( new ThresholdAction() );
        mediator.getInputPage().setActionListener( new TextAreaAction() );
        mediator.getUploadButton().addActionListener( new TagUploadAction() );
        mediator.getDeselectButton().addActionListener(new TokenizeAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.mediator.getTagPage().deselectAll();
            }
        });
    }
}
