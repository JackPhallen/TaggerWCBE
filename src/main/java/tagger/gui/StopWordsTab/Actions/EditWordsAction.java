package tagger.gui.StopWordsTab.Actions;

import tagger.words.Words;

public abstract class EditWordsAction extends StopWordAction {


    protected void addSelected() {
        Words words = this.getSelected();
        this.stopWords.add(words);
        this.updateList();
    }

    protected void removeSelected() {
        Words words = this.getSelected();
        this.stopWords.remove(words);
        this.updateList();
    }
}
