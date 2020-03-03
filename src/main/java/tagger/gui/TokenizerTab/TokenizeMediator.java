package tagger.gui.TokenizerTab;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tagger.gui.Page.CardNavigator;
import tagger.gui.TokenizerTab.cards.InputPage;
import tagger.gui.TokenizerTab.cards.PostSelectPage;
import tagger.gui.TokenizerTab.cards.TagPage;

import javax.swing.*;

/**
 * Singleton holding TokenizerPage and child components
 */
@Getter
@Setter
@NoArgsConstructor
public class TokenizeMediator {

    @Getter
    private final static TokenizeMediator instance = new TokenizeMediator();

    private CardNavigator cardNavigator;

    /* Pages */
    private InputPage inputPage;
    private TagPage tagPage;
    private PostSelectPage postSelectPage;

    /* Nav Buttons */
    private JButton nextButton;
    private JButton backButton;

    /* Button Panel's buttons */
    private JButton clearTextButton;
    private JSpinner thresholdSpinner;

    /* Control bar buttons */
    private JButton deselectButton;
    private JButton uploadButton;

}
