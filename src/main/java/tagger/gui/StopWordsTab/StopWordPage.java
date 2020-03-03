package tagger.gui.StopWordsTab;

import tagger.gui.Page.CardNavigator;
import tagger.gui.Page.Page;
import tagger.gui.Page.components.ControlBar;

import javax.swing.*;
import java.awt.*;

public class StopWordPage extends Page {



    public StopWordPage() {
        super();
        this.setLayout(new BorderLayout());
        this.buildButtonPanel();
        this.buildMainPanel();
        this.buildImportButton();
    }

    protected void buildMainPanel() {
        CardNavigator navigator = new CardNavigator();
        StopMediator.getInstance().setCardNavigator(navigator);
        navigator.addPanel( this.buildWordList() );
        navigator.add( new ControlBar(), BorderLayout.NORTH );
        this.add(navigator, BorderLayout.CENTER );
    }

    private WordList buildWordList() {
        WordList page = new WordList();
        StopMediator.getInstance().setWordList(page);
        return page;
    }

    private void buildButtonPanel() {
        StopButtonPanel buttonPanel = new StopButtonPanel();
        this.add( buttonPanel, BorderLayout.WEST );
    }

    private JButton buildImportButton() {
        JButton button = new JButton("Import File");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }


    @Override
    public String getTitle() {
        return "Manage Stop Words";
    }
}
