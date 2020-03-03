package tagger.gui.Loading;

import javax.swing.*;
import java.awt.*;

public class LoadingPage extends JPanel {

    private JLabel label;

    public LoadingPage(String label) {
        this();
        this.setText(label);
    }

    public LoadingPage() {
        super();
        this.setLayout( new BorderLayout() );
        ImageIcon loading = new ImageIcon("/Users/jackphallen/IdeaProjects/JavaTagger/src/main/resources/ajax-loader.gif");
        this.label = new JLabel("Loading...", loading, JLabel.CENTER);
        this.label.setVerticalTextPosition(JLabel.BOTTOM);
        this.label.setHorizontalTextPosition(JLabel.CENTER);
        this.add( this.label, BorderLayout.CENTER );
    }

    public void setText(String text) {
        this.label.setText(text);
    }


}
