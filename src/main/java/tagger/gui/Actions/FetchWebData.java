package tagger.gui.Actions;

import tagger.gui.workers.WordPressInit;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FetchWebData extends AbstractAction {


    @Override
    public void actionPerformed(ActionEvent e) {
        this.init();
    }

    public void init() {
        SwingWorker<Void, String> worker = new WordPressInit();
        worker.execute();
    }


}

