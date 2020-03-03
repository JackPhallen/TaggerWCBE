package tagger.gui.Page.components;

import javax.swing.*;
import java.awt.*;

public abstract class CardPanel extends JPanel {

    protected boolean isFocused = false;

    public CardPanel() {
        super();
        this.setLayout(new BorderLayout());
    }

    public abstract String getName();

    public void focus(boolean isFocused) {
        this.isFocused = isFocused;
        this.onFocusChange();
    }

    protected abstract void onFocusChange();


}
