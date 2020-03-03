package tagger.gui.StopWordsTab.Actions;

import tagger.gui.StopWordsTab.StopMediator;
import tagger.token.Tagger;
import tagger.words.StopWords;
import tagger.words.Words;

import javax.swing.*;

public abstract class StopWordAction extends AbstractAction {

    protected StopMediator mediator = StopMediator.getInstance();

    protected StopWords stopWords = Tagger.getInstance().getStopWords();

    protected Words getSelected() {
        return this.mediator.getWordList().getSelected();
    }

    protected void updateList() {
        this.mediator.getWordList().setWords( this.stopWords );
    }

}
