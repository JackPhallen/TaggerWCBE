package tagger.gui.components.PostList;

import tagger.http.posts.Post;

import javax.swing.*;
import java.awt.*;

public class PostCellRenderer extends JLabel implements ListCellRenderer<Post> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Post> list, Post post, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        setText(post.getTitle());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }

}
