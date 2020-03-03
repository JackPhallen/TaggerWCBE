package tagger.gui.TokenizerTab.cards;

import lombok.Setter;
import tagger.gui.Page.components.ControlBar;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Page with text area to enter String to be tagged
 */
public class InputPage extends CardTemplate implements DocumentListener {

    private JTextArea textArea;

    @Setter
    private AbstractAction actionListener;

    public InputPage() {
        super();
        this.textArea = new JTextArea();
        this.textArea.getDocument().addDocumentListener(this);
        this.textArea.setLineWrap(true);
        this.add( new JScrollPane(this.textArea) );
    }

    @Override
    public String getName() {
        return "Input Page";
    }

    @Override
    protected void onFocusChange() {

    }


    public void setText(String text) {
        this.textArea.setText(text);
    }

    public String getText() {
        return this.textArea.getText();
    }

    protected ControlBar buildControlBar() {
        ControlBar controlBar = super.buildControlBar();
        JLabel label = new JLabel("Enter text to tokenize or select an option");
        controlBar.add(label, BorderLayout.WEST);
        return controlBar;
    }


    private void textUpdate() {
        this.actionListener.actionPerformed(null);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.textUpdate();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.textUpdate();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.textUpdate();
    }
}

