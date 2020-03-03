package tagger.gui.TokenizerTab.Actions;

import tagger.gui.Actions.AppAction;

import java.awt.event.ActionEvent;

/**
 * Action to be called when Text area is updated
 */
public class TextAreaAction extends TokenizeAction {


    @Override
    public void actionPerformed(ActionEvent e) {
        String text = this.mediator.getInputPage().getText();
        this.enableNext( text.length() > 0 );

        (new AppAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.tagger.setText( text );
            }
        }).actionPerformed(e);

    }

}
