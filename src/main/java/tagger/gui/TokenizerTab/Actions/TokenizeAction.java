package tagger.gui.TokenizerTab.Actions;

import tagger.gui.TokenizerTab.TokenizeMediator;

import javax.swing.*;

/**
 * Abstract action with functionality used throughout TokenizerPage
 */
public abstract class TokenizeAction extends AbstractAction {

    protected TokenizeMediator mediator = TokenizeMediator.getInstance();

    protected void enableNext(boolean doEnable) {
        this.mediator.getNextButton().setEnabled(doEnable);
    }

    protected void enableBack(boolean doEnable) {
        this.mediator.getBackButton().setEnabled(doEnable);
    }

    protected boolean isTagPage() {
        return this.mediator.getCardNavigator().getIndex() == 1;
    }

}
