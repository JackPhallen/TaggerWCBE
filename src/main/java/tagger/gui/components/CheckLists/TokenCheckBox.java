package tagger.gui.components.CheckLists;

import lombok.Getter;
import tagger.token.Token;

import javax.swing.*;

public class TokenCheckBox extends JCheckBox {

    @Getter
    private Token token;


    public TokenCheckBox(Token token) {
        super(token.getWord() + " (" + token.getCount() + ")");
        this.token = token;
    }


}
