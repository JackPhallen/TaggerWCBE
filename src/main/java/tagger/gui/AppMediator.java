package tagger.gui;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tagger.gui.StopWordsTab.StopWordPage;
import tagger.gui.TokenizerTab.TokenizerPage;

/**
 * Singleton to hold instances of important GUI components
 */
@Getter
@Setter
@NoArgsConstructor
public class AppMediator {

    @Getter
    private static AppMediator instance = new AppMediator();

    private App app;

    private TokenizerPage tokenizerPage;
    private StopWordPage stopWordPage;

}
