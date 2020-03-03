package tagger.gui.Page;

import javax.swing.*;

public abstract class Page extends JPanel {

    public abstract String getTitle();

    public void add(CardNavigator nav, String layout) {
        this.add(nav.getCardContainer(), layout);
    }

}
