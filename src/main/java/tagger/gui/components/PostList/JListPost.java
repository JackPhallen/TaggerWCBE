package tagger.gui.components.PostList;

import tagger.http.posts.Post;
import tagger.http.posts.ServerPosts;

import javax.swing.*;

public class JListPost extends JList<Post> {

    DefaultListModel<Post> model = new DefaultListModel<>();

    public JListPost(ServerPosts posts) {
        this();
        this.addPosts(posts);
    }

    public JListPost() {
        super();
        this.setCellRenderer(new PostCellRenderer());
        this.setModel(this.model);
    }

    public void addPosts(ServerPosts posts) {
        for (Post post : posts) {
            this.model.addElement(post);
        }
    }


}
