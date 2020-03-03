package tagger.gui.Page.components;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CardContainer extends JPanel {

    @Getter
    private int index = 0;

    public CardContainer() {
        super();
        this.setLayout(new CardLayout());
    }

    public CardContainer(List<CardPanel> cards) {
        this();
        this.add( cards );
    }

    public void add(CardPanel card) {
        this.add(card, card.getName());
    }

    protected void add(List<CardPanel> cards) {
        for (CardPanel card : cards) {
            this.add(card);
        }
    }

    public void renderCard(CardPanel card) {
        CardLayout layout = (CardLayout)(this.getLayout());
        layout.show(this, card.getName());
        card.focus(true);
    }



}
