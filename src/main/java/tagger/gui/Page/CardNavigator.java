package tagger.gui.Page;

import lombok.Getter;
import tagger.gui.Page.components.CardContainer;
import tagger.gui.Page.components.CardPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CardNavigator {

    @Getter
    protected CardContainer cardContainer;
    protected List<CardPanel> panels;
    protected CardPanel focused;
    @Getter
    protected int index = 0;

    public CardNavigator() {
        this.cardContainer = new CardContainer();
        this.panels = new ArrayList<>();
    }

    public CardNavigator(List<CardPanel> panels) {
        this.panels = panels;
    }

    public void add(JComponent panel, String layout) {
        this.cardContainer.add(panel, layout);
    }

    public void addPanel(CardPanel card) {
        if (this.focused == null) {
            this.setFocused(card);
        }
        this.panels.add(card);
        this.cardContainer.add( card );
    }

    public void next() {
        if (this.canIncrement()) {
            this.go(this.index + 1);
            this.render();
        }
    }

    public void back() {
        if (this.canDecrement()) {
            this.go( this.index - 1);
            this.render();
        }
    }

    protected void setFocused(CardPanel card) {
        if (this.focused != null) {
            this.focused.focus(false);
        }
        this.focused = card;
        this.focused.focus(true);
    }

    protected void go(int index) {
        this.index = index;
        this.render();
    }

    public void render() {
        this.setFocused( this.panels.get(this.index) );
        this.cardContainer.renderCard(this.focused);
    }

    public boolean canIncrement() {
        return this.index < this.panels.size() - 1;
    }

    public boolean canDecrement() {
        return this.index > 0;
    }



}
