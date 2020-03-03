package tagger.gui.StopWordsTab;

import tagger.gui.Page.components.CardPanel;
import tagger.gui.Page.components.ControlBar;
import tagger.gui.components.CheckLists.WordCheckList;
import tagger.token.Tagger;
import tagger.words.StopWords;
import tagger.words.Words;

import javax.swing.*;
import java.awt.*;

public class WordList extends CardPanel {

    private WordCheckList checkList;

    public WordList() {
        super();
        this.add(this.buildControlBar(), BorderLayout.NORTH);
        StopWords stopWords = Tagger.getInstance().getStopWords();
        this.checkList = new WordCheckList( stopWords );
        this.add(new JScrollPane(this.checkList), BorderLayout.CENTER);
    }

    @Override
    public String getName() {
        return "Tag Page";
    }

    @Override
    protected void onFocusChange() {

    }

    protected ControlBar buildControlBar() {
        ControlBar controlBar = new ControlBar();
        JLabel label = new JLabel("Select stop words to modify");
        controlBar.add(label, BorderLayout.WEST);
        return controlBar;
    }

    public void setWords(Words words) {
        this.checkList.removeAll();
        this.checkList.addWords(words);
    }

    public Words getSelected() {
        return this.checkList.getSelected();
    }


}
