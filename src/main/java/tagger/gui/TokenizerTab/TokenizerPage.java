package tagger.gui.TokenizerTab;

import tagger.gui.Page.CardNavigator;
import tagger.gui.Page.Page;
import tagger.gui.Page.components.ControlBar;
import tagger.gui.TokenizerTab.cards.InputPage;
import tagger.gui.TokenizerTab.cards.PostSelectPage;
import tagger.gui.TokenizerTab.cards.TagPage;

import javax.swing.*;
import java.awt.*;

/**
 * Root page container for tokenizer tag
 */
public class TokenizerPage extends Page {

    public TokenizerPage() {
        super();
        this.setLayout(new BorderLayout());
        this.buildMainPanel();
        this.buildNavButtons();
        this.buildButtonPanel();
        ActionBuilder.buildActions();
    }

    public String getTitle() {
        return "Tokenizer";
    }

    protected void buildMainPanel() {
        CardNavigator navigator = new CardNavigator();
        TokenizeMediator.getInstance().setCardNavigator(navigator);
        navigator.addPanel( this.buildInputPage() );
        navigator.addPanel( this.buildTagPage() );
        navigator.addPanel( this.buildUploadPage() );
        navigator.add( new ControlBar(), BorderLayout.NORTH );
        this.add(navigator, BorderLayout.CENTER );
    }

    private InputPage buildInputPage() {
        InputPage page = new InputPage();
        TokenizeMediator.getInstance().setInputPage( page );
        return page;
    }

    private TagPage buildTagPage() {
        TagPage page = new TagPage();
        TokenizeMediator.getInstance().setTagPage( page );
        return page;
    }

    private PostSelectPage buildUploadPage() {
        PostSelectPage page = new PostSelectPage();
        TokenizeMediator.getInstance().setPostSelectPage(page);
        return page;
    }


    private void buildNavButtons() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.add( this.buildBackButton() );
        bottomPanel.add( this.buildNextButton() );
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    private JButton buildNextButton() {
        JButton nextButton = new JButton("Next");
        nextButton.setEnabled(false);
        TokenizeMediator.getInstance().setNextButton(nextButton);
        return nextButton;
    }

    private JButton buildBackButton() {
        JButton backButton = new JButton("Back");
        backButton.setEnabled(false);
        TokenizeMediator.getInstance().setBackButton( backButton );
        return backButton;
    }

    public void buildButtonPanel() {
        TokenButtonPanel buttonPanel = new TokenButtonPanel();
        this.add( buttonPanel, BorderLayout.WEST );
    }





}
