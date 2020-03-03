package tagger.gui.TokenizerTab.Actions;

import tagger.gui.Actions.TagAction;
import tagger.gui.Page.CardNavigator;

import java.awt.event.ActionEvent;


/**
 * Action with functionality for navigation actions within TokenizerPage
 * (next and back buttons)
 */
public abstract class TokenNavAction extends TokenizeAction {

    protected CardNavigator navigator;

    public TokenNavAction() {
        super();
        this.navigator = this.mediator.getCardNavigator();
    }

    protected void next(ActionEvent e) {
        this.navigator.next();
        this.onNavigation(e);
    }

    protected void back(ActionEvent e) {
        this.navigator.back();
        this.onNavigation(e);
    }

    private void onNavigation(ActionEvent e) {
        this.updateButtons();
        if (this.navigator.getIndex() == 1) {
            new TagAction().actionPerformed(e);
        } else if (this.navigator.getIndex() == 2) {

        } else if (this.navigator.getIndex() == 3) {
            //new TagUploadAction().actionPerformed(e);
        }
    }

    private void updateButtons() {
        this.enableNext( this.navigator.canIncrement() );
        this.enableBack( this.navigator.canDecrement() );
    }




}
