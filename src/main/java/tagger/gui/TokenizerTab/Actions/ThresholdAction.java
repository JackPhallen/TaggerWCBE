package tagger.gui.TokenizerTab.Actions;

import tagger.gui.Actions.AppAction;
import tagger.gui.Actions.TagAction;
import tagger.gui.TokenizerTab.TokenizeMediator;
import tagger.token.TokenList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;

/**
 * Action to update threshold of tagger, listens to JSpinner
 */
public class ThresholdAction extends TokenizeAction implements ChangeListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int threshold = (int) this.mediator.getThresholdSpinner().getValue();
        new AppAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.tagger.setThreshold( threshold );
            }
        };

        if (this.mediator.getCardNavigator().getIndex() == 1) {
            new TagAction();
        }
    }

    public void stateChanged(ChangeEvent e) {
        JSpinner source = (JSpinner) e.getSource();
        int threshold = (int) source.getValue();
        this.setThreshold(threshold);

        if (this.isTagPage()) {
            this.reduce();
        }
    }


    private void setThreshold(int threshold) {
        (new AppAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.tagger.setThreshold(threshold);
            }
        }).actionPerformed(null);
    }

    private void reduce() {
        (new AppAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TokenList tokens = this.tagger.reduce();
                TokenizeMediator.getInstance().getTagPage().setTokens(tokens);
            }
        }).actionPerformed(null);
    }


}
