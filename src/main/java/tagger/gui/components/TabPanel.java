package tagger.gui.components;

import tagger.gui.Page.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class TabPanel extends JPanel {

    private static int[] KEYEVENTS = {KeyEvent.VK_1, KeyEvent.VK_3, KeyEvent.VK_4,
                    KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9};

    private JTabbedPane tabbedPane;

    public TabPanel(List<Page> pages) {
        super(new GridLayout(1, 1));
        this.tabbedPane = new JTabbedPane();

        for (int i = 0; i < pages.size() && i < KEYEVENTS.length; i++ ) {
            this.addPage(pages.get(i), i);
        }
        this.add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    private void addPage(Page page, int index) {
        this.tabbedPane.addTab(page.getTitle(), page);
        this.tabbedPane.setMnemonicAt(index, KEYEVENTS[index]);
    }




}
