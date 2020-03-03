package tagger.gui.components.CheckLists;

import tagger.words.Words;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WordCheckList extends JCheckBoxList {

    private DefaultListModel<JCheckBox> model = new DefaultListModel<>();
    private boolean setSelected = false;

    public WordCheckList() {
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

    public WordCheckList(Words words) {
        this();
        this.addWords( words );
    }

    public void addWords(Words words) {
        for (String word : words) {
            JCheckBox checkBox = new JCheckBox(word);
            checkBox.setSelected(this.setSelected);
            this.model.addElement(checkBox);
        }
    }

    public void remove(Words words) {
        for (String word: words) {
            Boolean result = this.model.removeElement(word);
            System.out.println(result);
        }
        this.repaint();
    }

    public void removeAll() {
        this.model.removeAllElements();
        this.repaint();
    }

    public Words getSelected() {
        Words words = new Words();
        for (int i = 0; i < this.model.size(); i++) {
            JCheckBox checkBox = this.model.get(i);
            if (checkBox.isSelected()) {
                words.add( checkBox.getText() );
            }
        }
        return words;
    }

    public void selectAll(boolean doSelect) {
        for (int i = 0; i < this.model.size(); i++) {
            JCheckBox checkBox = this.model.get(i);
            checkBox.setSelected(doSelect);
        }
        this.revalidate();
        this.repaint();
    }


}
