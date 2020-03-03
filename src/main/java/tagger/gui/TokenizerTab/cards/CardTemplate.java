package tagger.gui.TokenizerTab.cards;

import tagger.gui.Page.components.CardPanel;
import tagger.gui.Page.components.ControlBar;

import java.awt.*;

/**
 * Layout for each card on the Tokenizer page
 * (Used by TagPage, InputPage, UploadPage)
 */
public abstract class CardTemplate extends CardPanel {

    public CardTemplate() {
        super();
        this.add(this.buildControlBar(), BorderLayout.NORTH);
    }

    protected ControlBar buildControlBar() {
        return new ControlBar();
    }
}
