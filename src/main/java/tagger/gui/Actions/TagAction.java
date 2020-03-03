package tagger.gui.Actions;

import tagger.gui.TokenizerTab.TokenizeMediator;
import tagger.token.TokenList;

import java.awt.event.ActionEvent;

/**
 * Action that runs the tagger
 */
public class TagAction extends AppAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tagger.tag();
        TokenList tokens = this.tagger.getTokens();
        TokenizeMediator.getInstance().getTagPage().setTokens( tokens );
    }

}
