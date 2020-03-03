package tagger.gui.Actions;

import tagger.gui.AppMediator;
import tagger.token.Tagger;

import javax.swing.*;

/**
 * Abstract action that provides access to tagger and mediator
 */
public abstract class AppAction extends AbstractAction {

    protected Tagger tagger = Tagger.getInstance();
    protected AppMediator mediator = AppMediator.getInstance();


}
