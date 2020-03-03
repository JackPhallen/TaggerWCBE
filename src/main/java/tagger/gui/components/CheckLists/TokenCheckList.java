package tagger.gui.components.CheckLists;

import tagger.token.Token;
import tagger.token.TokenList;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TokenCheckList extends JCheckBoxList {

    private DefaultListModel<JCheckBox> model = new DefaultListModel<>();
    private boolean setSelected = true;

    public TokenCheckList() {
        super();
        this.setModel( this.model );
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int index = locationToIndex(e.getPoint());
                if (index != -1) {
                    JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
                    checkbox.setSelected(!checkbox.isSelected());
                    repaint();
                }
            }
        });
    }

    public TokenCheckList(TokenList tokenList) {
        this();
        this.addWords( tokenList );
    }

    public void addWords(TokenList tokens) {
        for (Token token : tokens) {
            TokenCheckBox checkBox = new TokenCheckBox(token);
            checkBox.setSelected(this.setSelected);
            this.model.addElement(checkBox);
        }
    }

    public void remove(TokenList tokens) {
        for (Token token: tokens) {
            Boolean result = this.model.removeElement(token);
            System.out.println(result);
        }
        this.repaint();
    }

    public void removeAll() {
        this.model.removeAllElements();
        this.repaint();
    }

    public TokenList getSelected() {
        TokenList tokens = new TokenList();
        for (int i = 0; i < this.model.size(); i++) {
            TokenCheckBox checkBox = (TokenCheckBox) this.model.get(i);
            if (checkBox.isSelected()) {
                tokens.add( checkBox.getToken() );
            }
        }
        return tokens;
    }

    public void selectAll(boolean doSelect) {
        for (int i = 0; i < this.model.size(); i++) {
            TokenCheckBox checkBox = (TokenCheckBox) this.model.get(i);
            checkBox.setSelected(doSelect);
        }
        this.revalidate();
        this.repaint();
    }


}
