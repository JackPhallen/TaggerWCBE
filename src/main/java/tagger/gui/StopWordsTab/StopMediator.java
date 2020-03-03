package tagger.gui.StopWordsTab;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tagger.gui.Page.CardNavigator;

import javax.swing.*;

@Getter
@Setter
@NoArgsConstructor
public class StopMediator {

    @Getter
    private static StopMediator instance =  new StopMediator();

    private WordList wordList;
    private CardNavigator cardNavigator;

    private JButton deleteButton;
    private JButton addButton;
}
