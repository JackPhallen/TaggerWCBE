package tagger.gui.components.Dialog;

import tagger.gui.AppMediator;

import javax.swing.*;

public class AppDialog extends JDialog {

    public AppDialog(String title, String message) {
        super(AppMediator.getInstance().getApp(), title);
        JLabel label = new JLabel(message);
        this.add( label );
        this.setSize(400, 200);
    }
}
